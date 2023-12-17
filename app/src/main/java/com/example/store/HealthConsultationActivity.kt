package com.example.store


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.store.controlcenter.chat

class HealthConsultationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        setContentView(R.layout.activity_health_consultation)

        val healthAnswer: TextView = findViewById(R.id.healthAnswer)
        val refresh:Button = findViewById(R.id.refresh)
        val backButton = findViewById<ImageView>(R.id.imageView10)

        var question = "Give me some health advice."
        chat(question) { answer ->
            runOnUiThread {
                healthAnswer.text = answer
            }
        }

        refresh.setOnClickListener {
            chat(question) { answer ->
                runOnUiThread {
                    healthAnswer.text = answer
                }
            }
        }

        backButton.setOnClickListener {
            finish()
        }
    }
}