package com.example.store.DeviceDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.store.R
import com.example.store.controlcenter.Operation
import com.example.store.device.Light

class LightDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_light_detail)
        val light = intent.getSerializableExtra("device") as Light

        val name:TextView = findViewById(R.id.LightDetailName)
        val detail:TextView = findViewById(R.id.LightDetailDetail)
        val image:ImageView = findViewById(R.id.LightDetailImage)
        val button:Button = findViewById(R.id.LightDetailSwitch)
        val detailContent = StringBuilder()

        detailContent.apply {
            append(light.deviceID)
            append(light.type)
            append(light.currentPower)
        }

        name.text = light.name
        detail.text = detailContent.toString()
        image.setImageResource(light.imageID)
        button.setOnClickListener {
            light.changeOperation(Operation(light.deviceID, "turnOn", 0))
        }

    }
}