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
import com.example.store.device.AvailableOperation
import com.example.store.device.Television
import com.google.android.material.appbar.CollapsingToolbarLayout

class TelevisionDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_television_detail)

        val layout: CollapsingToolbarLayout = findViewById(R.id.tvDetailLayout)

        val tvID = intent.getSerializableExtra("deviceID") as Int
        val tv = sampleCC.getDevice(tvID) as Television

        val switch: Switch = findViewById(R.id.tvDetailSwitch)
        val volume: SeekBar = findViewById(R.id.tvVolume)
        val channel: TextView = findViewById(R.id.tvChannelText)
        val changeChannel: Button = findViewById(R.id.tvChangeChannel)

        layout.title = tv.name
        switch.isChecked = tv.status
        volume.max = 5
        volume.progress = tv.volume
        channel.text = "No.${tv.channel}"

        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Operation(tv, "TurnOn", 0).run()
                Toast.makeText(
                    buttonView.context,
                    "${tv.deviceID} turnOn",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Operation(tv, "TurnOff", 0).run()
                Toast.makeText(
                    buttonView.context,
                    "${tv.deviceID} turnOff",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        volume.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                var setVolume = Operation(tv, "ChangeVolume", progress)
                setVolume.run()
                Toast.makeText(seekBar?.context, "${tv.volume}", Toast.LENGTH_SHORT).show()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        changeChannel.setOnClickListener {
            showParameterSelectionDialog(
                tv,
                tv.availableOperations[2]
            ) { newChannel ->
                channel.text = "No.$newChannel"
            }
        }

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
        tv: Television,
        selectedOperation: AvailableOperation,
        onUpdateChannelText: (Int) -> Unit
    ) {
        val paras = selectedOperation.parameters.map { it.toString() } // 获取设备支持的操作名称列表

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Select an Temperature")
        builder.setItems(paras.toTypedArray()) { dialog, which ->
            val selectedPara = paras[which]
            val newOperation = Operation(tv, selectedOperation.name, selectedPara.toInt())
            newOperation.run()
            dialog.dismiss()
            val newChannel = tv.channel
            onUpdateChannelText.invoke(newChannel)
        }

        builder.show()
    }
}