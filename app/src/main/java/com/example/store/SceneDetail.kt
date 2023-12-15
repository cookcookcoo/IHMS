package com.example.store

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.store.controlcenter.Rule
import com.example.store.controlcenter.sampleCC
import com.example.store.device.Light

class SceneDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene_detail)

        val scene = intent.getSerializableExtra("scene") as Rule

        val recyclerView:RecyclerView = findViewById(R.id.sceneDetailRecycleView)
        val name:TextView = findViewById(R.id.sceneDetailName)

        name.text = scene.ruleName

        val operationList = scene.operationList
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = OperationAdapter(operationList)
        recyclerView.adapter = adapter


        //返回键
        val backButton = findViewById<ImageView>(R.id.imageView8)
        backButton.setOnClickListener {
            // 创建一个Intent并指定目标Activity
            val intent = Intent(this, MainActivity::class.java)

            // 添加额外的信息，例如标识要显示的 Fragment
            intent.putExtra("fragmentToLoad", "sceneFragment")

            // 启动目标Activity
            startActivity(intent)
        }

    }

}