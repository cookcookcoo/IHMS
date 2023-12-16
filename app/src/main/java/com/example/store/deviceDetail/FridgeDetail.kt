package com.example.store.deviceDetail

import android.os.Bundle
import android.widget.Button
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
import com.example.store.device.Fridge
import com.google.android.material.appbar.CollapsingToolbarLayout

class FridgeDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fridge_detail)

        val layout: CollapsingToolbarLayout = findViewById(R.id.fridgeDetailLayout)

        val fridgeID = intent.getSerializableExtra("deviceID") as Int
        val fridge = sampleCC.getDevice(fridgeID) as Fridge

        val switch:Switch = findViewById(R.id.fridgeDetailSwitch)
        val upperText:TextView = findViewById(R.id.fridgeUpperTempText)
        val changeUpper:Button = findViewById(R.id.fridgeChangeUpper)
        val lowerText:TextView = findViewById(R.id.fridgeLowerTempText)
        val changeLower:Button = findViewById(R.id.fridgeChangeLower)

        layout.title = fridge.name
        switch.isChecked = fridge.status
        upperText.text = fridge.upperTemperature.toString()
        lowerText.text = fridge.lowerTemperature.toString()

        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Operation(fridge, "TurnOn", 0).run()
                Toast.makeText(
                    buttonView.context,
                    "${fridge.deviceID} turnOn",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Operation(fridge, "TurnOff", 0).run()
                Toast.makeText(
                    buttonView.context,
                    "${fridge.deviceID} turnOff",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        changeUpper.setOnClickListener {
            showParameterSelectionDialogUpper(
                fridge,
                fridge.availableOperations[2]
            ) { temperature ->
                upperText.text = "$temperature°C"
            }
        }

        changeLower.setOnClickListener {
            showParameterSelectionDialogLower(
                fridge,
                fridge.availableOperations[3]
            ) { temperature ->
                lowerText.text = "$temperature°C"
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
    private fun showParameterSelectionDialogUpper(
        fridge: Fridge,
        selectedOperation: AvailableOperation,
        onUpdateTempText: (Int) -> Unit
    ) {
        val paras = selectedOperation.parameters.map { it.toString() } // 获取设备支持的操作名称列表

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Select an Temperature")
        builder.setItems(paras.toTypedArray()) { dialog, which ->
            val selectedPara = paras[which]
            val newOperation = Operation(fridge, selectedOperation.name, selectedPara.toInt())
            newOperation.run()
            dialog.dismiss()
            val temperature = fridge.upperTemperature
            onUpdateTempText.invoke(temperature)
        }
        builder.show()
    }

    private fun showParameterSelectionDialogLower(
        fridge: Fridge,
        selectedOperation: AvailableOperation,
        onUpdateTempText: (Int) -> Unit
    ) {
        val paras = selectedOperation.parameters.map { it.toString() } // 获取设备支持的操作名称列表

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Select an Temperature")
        builder.setItems(paras.toTypedArray()) { dialog, which ->
            val selectedPara = paras[which]
            val newOperation = Operation(fridge, selectedOperation.name, selectedPara.toInt())
            newOperation.run()
            dialog.dismiss()
            val temperature = fridge.lowerTemperature
            onUpdateTempText.invoke(temperature)
        }
        builder.show()
    }
}