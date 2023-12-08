package com.example.store

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class AddDevices : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_devices)
        supportActionBar?.hide()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN


        val ImageView = findViewById<ImageView>(R.id.imageView7)
        ImageView.setOnClickListener{
            // 创建一个Intent并指定目标Activity
            val intent = Intent(this, MainActivity::class.java)
            // 启动目标Activity
            startActivity(intent)
        }
    }
}