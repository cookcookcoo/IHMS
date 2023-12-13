package com.example.store

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    }

}