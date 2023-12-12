package com.example.store

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class RealTimePowerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        setContentView(R.layout.activity_real_time_power)
    }
}