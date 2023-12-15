package com.example.store.deviceDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.store.R
import com.example.store.controlcenter.Operation
import com.example.store.controlcenter.sampleCC
import com.example.store.device.Light
import com.google.android.material.appbar.CollapsingToolbarLayout

class LightDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_light_detail)
        val lightID = intent.getSerializableExtra("deviceID") as Int
        val light = sampleCC.getDevice(lightID) as Light

        val image:ImageView = findViewById(R.id.LightDetailImage)
        val layout:CollapsingToolbarLayout = findViewById(R.id.LightDetailLayout)
        val image2:ImageView = findViewById(R.id.imageView4)
        val image3:ImageView = findViewById(R.id.imageView5)
        val image4:ImageView = findViewById(R.id.imageView6)
        val detailContent = StringBuilder()

        val lightSwitch = findViewById<Switch>(R.id.lightDetailSwitch)
        val lightLuminance = findViewById<SeekBar>(R.id.lightDetailLuminance)

        detailContent.apply {
            append(light.deviceID)
            append(light.type)
            append(light.currentPower)
        }

        image.setImageResource(R.drawable.devices_background)
        layout.title = light.name


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

        lightSwitch.isChecked = light.status
        lightSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Operation(light, "TurnOn", 0).run()
                Toast.makeText(
                    buttonView.context,
                    "${light.deviceID} turnOn",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Operation(light, "TurnOff", 0).run()
                Toast.makeText(
                    buttonView.context,
                    "${light.deviceID} turnOff",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        lightLuminance.max = 5
        lightLuminance.progress = light.luminance
        lightLuminance.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                var setLum = Operation(light, "ChangeLuminance", progress)
                setLum.run()
                Toast.makeText(seekBar?.context, "${light.luminance}", Toast.LENGTH_SHORT).show()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

    }
}