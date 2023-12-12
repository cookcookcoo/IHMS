package com.example.store

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class AddDevices : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_devices)
        supportActionBar?.hide()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        //返回箭头
        val ImageView = findViewById<ImageView>(R.id.imageView7)
        ImageView.setOnClickListener{
            // 创建一个Intent并指定目标Activity
            val intent = Intent(this, MainActivity::class.java)
            // 启动目标Activity
            startActivity(intent)
        }

        //manual addition
        val manualAddition = findViewById<Button>(R.id.button2)
        manualAddition.setOnClickListener{
            // 创建弹窗
            createDialog(this);
        }

    }

    // 创建弹窗的方法
    private fun createDialog(context: Context) {
        // 获取自定义布局
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.custom_dialog_layout, null)

        // 获取选择框和输入框
        val spinner: Spinner = view.findViewById(R.id.spinner)
        val editText: EditText = view.findViewById(R.id.editText)

        // 设置选择框的选项
        val adapter = ArrayAdapter.createFromResource(
            context,
            R.array.spinner_options,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // 构建弹窗
        val builder = AlertDialog.Builder(context)
        builder.setTitle("new device")
            .setView(view) // 将自定义布局设置给弹窗
            .setPositiveButton("confirm") { dialogInterface, _ ->
                // 点击确定按钮的处理逻辑
                val selectedOption = spinner.selectedItem.toString()
                val userInput = editText.text.toString()
                // 在这里处理选择框和输入框的值
                dialogInterface.dismiss() // 关闭弹窗
                // 返回家居页面
                val intent = Intent(this, MainActivity::class.java)
                // 启动目标Activity
                startActivity(intent)
            }
            .setNegativeButton("cancel") { dialogInterface, _ ->
                // 点击取消按钮的处理逻辑
                dialogInterface.dismiss() // 关闭弹窗
            }

        // 创建并显示弹窗
        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }
}