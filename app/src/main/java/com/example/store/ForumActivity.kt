package com.example.store

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class ForumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        setContentView(R.layout.activity_forum)


        //返回键
        val backButton = findViewById<ImageView>(R.id.imageView10)
        backButton.setOnClickListener {
            finish()
        }

        //加号键
        val addButton = findViewById<ImageView>(R.id.imageView11)
        addButton.setOnClickListener{
            // 创建一个Intent并指定目标Activity
            val intent = Intent(this, AddPost::class.java)
            // 启动目标Activity
            startActivity(intent)
        }

    }
}