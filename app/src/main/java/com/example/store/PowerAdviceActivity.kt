package com.example.store

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.store.controlcenter.chat
import com.example.store.controlcenter.sampleCC

class PowerAdviceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        setContentView(R.layout.activity_power_advice)

        val powerUsage: TextView = findViewById(R.id.powerUsage)
        val advice: TextView = findViewById(R.id.powerAdvice)
        val backButton: ImageView = findViewById(R.id.imageView10)

        val deviceList = sampleCC.deviceList.sortedByDescending { it.currentPower  }
        val stringBuilder = StringBuilder()

        for (device in deviceList) {
            if (device.currentPower !== 0) {
                stringBuilder.append("Type: ${device.type}, name: ${device.name}, power usage: ${device.currentPower}\n")
            }
        }

        val powerDetail = stringBuilder.toString()

        val question =
            "The following is the electricity consumption of some equipment, and give me some suggestions on electricity consumption.\n$powerDetail"
//            "The following is the electricity consumption of some equipment, make a summary\n$powerDetail"

        Log.d("AI", question)
        chat(question) { answer ->
            runOnUiThread {
                advice.text = answer
                powerUsage.text = powerDetail
            }
        }


        backButton.setOnClickListener {
            finish()
        }
    }
}