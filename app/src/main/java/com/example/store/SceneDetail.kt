package com.example.store

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.store.controlcenter.Rule
import com.example.store.device.Light

class SceneDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene_detail)

        val scene = intent.getSerializableExtra("scene") as Rule

        val name:TextView = findViewById(R.id.sceneDetailName)

        name.text = scene.ruleName

    }
}