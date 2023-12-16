package com.example.store

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.store.forum.Post
import com.google.android.material.textfield.TextInputEditText

class AddPost : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post)

        val addingPostTitle:TextInputEditText = findViewById(R.id.addingPostTitle)
        val addingPostContent:EditText = findViewById(R.id.addingPostContent)

        //cancel
        val cancelButton = findViewById<Button>(R.id.button3)
        cancelButton.setOnClickListener{
            finish()
        }

        //confirm
        val confirmButton = findViewById<Button>(R.id.button4)
        confirmButton.setOnClickListener{
            Post.addPost(addingPostTitle.text.toString(), addingPostContent.text.toString())
            finish()
        }

    }
}