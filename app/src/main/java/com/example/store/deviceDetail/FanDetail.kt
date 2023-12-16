package com.example.store.deviceDetail

import android.os.Bundle
import android.widget.SeekBar
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.store.R
import com.example.store.controlcenter.Operation
import com.example.store.controlcenter.sampleCC
import com.example.store.device.Fan
import com.google.android.material.appbar.CollapsingToolbarLayout

class FanDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fan_detail)

        val layout: CollapsingToolbarLayout = findViewById(R.id.fanDetailLayout)


        val fanID = intent.getSerializableExtra("deviceID") as Int
        val fan = sampleCC.getDevice(fanID) as Fan

        val switch:Switch = findViewById(R.id.fanDetailSwitch)
        val autoSwitch:Switch = findViewById(R.id.fanAuto)
        val windSpeed:SeekBar = findViewById(R.id.fanWindSpeed)


        layout.title = fan.name
        switch.isChecked = fan.status
        autoSwitch.isChecked = (fan.rotate == 1)
        windSpeed.max = 5
        windSpeed.progress = fan.windSpeed

        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Operation(fan, "TurnOn", 0).run()
                Toast.makeText(
                    buttonView.context,
                    "${fan.deviceID} turnOn",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Operation(fan, "TurnOff", 0).run()
                Toast.makeText(
                    buttonView.context,
                    "${fan.deviceID} turnOff",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        autoSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Operation(fan, "Rotate", 0).run()
            } else {
                Operation(fan, "Stop", 0).run()
            }
        }

        windSpeed.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                var setWindSpeed = Operation(fan, "ChangeWindSpeed", progress)
                setWindSpeed.run()
                Toast.makeText(seekBar?.context, "${fan.windSpeed}", Toast.LENGTH_SHORT).show()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })





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