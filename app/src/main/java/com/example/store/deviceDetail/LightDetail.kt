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
        val layout:CollapsingToolbarLayout = findViewById(R.id.LightDetailLayout)
        val image2:ImageView = findViewById(R.id.imageView4)
        val image3:ImageView = findViewById(R.id.imageView5)
        val image4:ImageView = findViewById(R.id.imageView6)
        val detailContent = StringBuilder()

        detailContent.apply {
            append(light.deviceID)
            append(light.type)
            append(light.currentPower)
        }

        image.setImageResource(R.drawable.devices_background)
        layout.title = light.name
//        button.setOnClickListener {
//            light.changeOperation(Operation(light, "turnOn", 0))
//        }


        image2.setImageResource(R.drawable.ic_devices_notchosen)
        image3.setImageResource(R.drawable.device_light)
        image4.setImageResource(R.drawable.device_light)


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