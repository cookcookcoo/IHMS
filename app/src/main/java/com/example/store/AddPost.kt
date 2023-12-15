package com.example.store

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AddPost : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post)

        //cancel
        val cancelButton = findViewById<Button>(R.id.button3)
        cancelButton.setOnClickListener{
            finish()
        }

        //confirm
        val confirmButton = findViewById<Button>(R.id.button4)
        confirmButton.setOnClickListener{
            finish()
        }

    }
}