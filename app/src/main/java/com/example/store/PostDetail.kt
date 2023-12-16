package com.example.store

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.store.forum.Post

class PostDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_detail)

        val postID = intent.getSerializableExtra("postID") as Int
        val post = Post.samplePostList.find { it.postID == postID } as Post

        val postTitle:TextView = findViewById(R.id.postDetailTitle)
        val postContent:TextView = findViewById(R.id.postDetailContent)
        val backBtn:Button = findViewById(R.id.postDetailBack)


        postTitle.text = post.title
        postContent.text = post.content

        backBtn.setOnClickListener {
            finish()
        }
    }
}