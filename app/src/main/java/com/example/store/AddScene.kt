package com.example.store

import android.content.Intent
import android.graphics.Path.Op
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.store.controlcenter.Operation
import com.example.store.controlcenter.sampleCC
import com.example.store.device.Device

class AddScene : AppCompatActivity() {
    private val operationList = ArrayList<Operation>()
    private val deviceList = sampleCC.deviceList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_scene)

        val addScene = findViewById<Button>(R.id.addScene)
        val confirmScene = findViewById<Button>(R.id.confirmScene)

        addScene.setOnClickListener {
            showDeviceSelectionDialog()
        }


        //confirm键
        confirmScene.setOnClickListener {
            sampleCC.addRule("New Scene", operationList)
            finish()
        }

        //返回键
        val backButton = findViewById<ImageView>(R.id.imageView2)
        backButton.setOnClickListener {
            finish()
        }


    }

    private fun showDeviceSelectionDialog() {
        val deviceNames = deviceList.map { it.name } // 获取设备名称列表

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Select a Device")
        builder.setItems(deviceNames.toTypedArray()) { dialog, which ->
            val selectedDevice = deviceList[which] // 获取用户选择的设备实例
            showOperationSelectionDialog(selectedDevice) // 展示操作选择对话框
        }
        builder.show()
    }

    private fun showOperationSelectionDialog(device: Device) {
        val operationNames = device.availableOperations.map { it.name } // 获取设备支持的操作名称列表

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Select an Operation")
        builder.setItems(operationNames.toTypedArray()) { dialog, which ->
            val selectedOperation = device.availableOperations[which] // 获取用户选择的操作实例
            // 这里可以根据选择的操作展示参数选择对话框，处理参数选择逻辑
            // ...

            val newOperation = Operation(device, selectedOperation.name, 0)
            addSelectedItemView(newOperation) // 将选择结果添加到界面中
            operationList.add(newOperation) // 将选择结果添加到 OperationList 中
        }
        builder.show()
    }

    private fun addSelectedItemView(operation: Operation) {
        val textView = TextView(this)
        textView.text = "${operation.operation} ${operation.para}"
        val selectedItemsLayout: LinearLayout = findViewById<LinearLayout>(R.id.selectedItemsLayout)
        selectedItemsLayout.addView(textView) // 将选择结果添加到界面的 LinearLayout 中显示
    }

}