package com.example.store.deviceDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import com.example.store.R
import com.example.store.controlcenter.Operation
import com.example.store.device.Light
import com.google.android.material.appbar.CollapsingToolbarLayout

class LightDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_light_detail)
        val light = intent.getSerializableExtra("device") as Light

        val image:ImageView = findViewById(R.id.LightDetailImage)
        val button:Button = findViewById(R.id.LightDetailSwitch)
        val layout:CollapsingToolbarLayout = findViewById(R.id.LightDetailLayout)
        val detailContent = StringBuilder()

        detailContent.apply {
            append(light.deviceID)
            append(light.type)
            append(light.currentPower)
        }

        image.setImageResource(light.imageID)
        layout.title = light.name
        button.setOnClickListener {
            light.changeOperation(Operation(light, "turnOn", 0))
        }

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