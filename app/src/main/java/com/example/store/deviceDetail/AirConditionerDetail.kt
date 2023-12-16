package com.example.store.deviceDetail

import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.store.R
import com.example.store.controlcenter.Operation
import com.example.store.controlcenter.sampleCC
import com.example.store.device.AirConditioner
import com.example.store.device.AvailableOperation

class AirConditionerDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_air_conditioner_detail)

        val lightID = intent.getSerializableExtra("deviceID") as Int
        val airConditioner = sampleCC.getDevice(lightID) as AirConditioner

        val switch: Switch = findViewById(R.id.acDetailSwitch)
        val tempText: TextView = findViewById(R.id.acTemp)
        val tempChange: Button = findViewById(R.id.acChangeTemp)
        val changeRotate: Switch = findViewById(R.id.acChangeRotate)
        val windSpeed: SeekBar = findViewById(R.id.acChangeWindSpeed)

        switch.isChecked = airConditioner.status
        tempText.text = airConditioner.temperature.toString() + "°C"
        changeRotate.isChecked = (airConditioner.fanRotate == 1)

        windSpeed.max = 3
        windSpeed.progress = airConditioner.windSpeed

        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Operation(airConditioner, "TurnOn", 0).run()
                Toast.makeText(
                    buttonView.context,
                    "${airConditioner.deviceID} turnOn",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Operation(airConditioner, "TurnOff", 0).run()
                Toast.makeText(
                    buttonView.context,
                    "${airConditioner.deviceID} turnOff",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        tempChange.setOnClickListener {
            showParameterSelectionDialog(
                airConditioner,
                airConditioner.availableOperations[2]
            ) { temperature ->
                tempText.text = "$temperature°C"
            }
        }

        changeRotate.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Operation(airConditioner, "ChangeFanRotate", 1).run()
                Toast.makeText(
                    buttonView.context,
                    "${airConditioner.deviceID} Rotate",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Operation(airConditioner, "ChangeFanRotate", 0).run()
                Toast.makeText(
                    buttonView.context,
                    "${airConditioner.deviceID} Stop",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        windSpeed.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                var setWindSpeed = Operation(airConditioner, "ChangeWindSpeed", progress)
                setWindSpeed.run()
                Toast.makeText(seekBar?.context, "${airConditioner.windSpeed}", Toast.LENGTH_SHORT).show()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })


        //        启用导航栏的返回键
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true) // 启用返回按钮
        supportActionBar?.setDisplayShowHomeEnabled(true) // 显示返回按钮

        // 设置导航按钮点击监听
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

    }

    private fun showParameterSelectionDialog(
        ac: AirConditioner,
        selectedOperation: AvailableOperation,
        onUpdateTempText: (Int) -> Unit
    ) {
        val paras = selectedOperation.parameters.map { it.toString() } // 获取设备支持的操作名称列表

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Select an Temperature")
        builder.setItems(paras.toTypedArray()) { dialog, which ->
            val selectedPara = paras[which]
            val newOperation = Operation(ac, selectedOperation.name, selectedPara.toInt())
            newOperation.run()
            dialog.dismiss()
            val temperature = ac.temperature
            onUpdateTempText.invoke(temperature)
        }

        builder.show()
    }
}