package com.example.store.deviceDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.store.R

class FridgeDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fridge_detail)





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
}