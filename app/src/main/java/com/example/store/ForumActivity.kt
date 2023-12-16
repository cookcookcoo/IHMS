package com.example.store

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.store.forum.Post

class ForumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        setContentView(R.layout.activity_forum)




        //返回键
        val backButton = findViewById<ImageView>(R.id.imageView10)
        backButton.setOnClickListener {
            finish()
        }

        //加号键
        val addButton = findViewById<ImageView>(R.id.imageView11)
        addButton.setOnClickListener{
            // 创建一个Intent并指定目标Activity
            val intent = Intent(this, AddPost::class.java)
            // 启动目标Activity
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        val postRecyclerView:RecyclerView = findViewById(R.id.forumRecycleView)

        val layoutManager = LinearLayoutManager(this)
        postRecyclerView?.layoutManager = layoutManager
        val adapter = PostAdapter(Post.samplePostList)
        postRecyclerView?.adapter = adapter
    }
}