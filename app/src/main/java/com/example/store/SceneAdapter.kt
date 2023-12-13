package com.example.store

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.store.controlcenter.Rule

class SceneAdapter(private val sceneList: ArrayList<Rule>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SceneViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.scene_item, parent, false)
        return SceneViewHolder(view)
    }

    override fun getItemCount() = sceneList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val scene = sceneList[position]
        if (holder is SceneViewHolder) {
            holder.bind(scene)
        }
    }

    inner class SceneViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val sceneName:TextView = itemView.findViewById(R.id.sceneName)

        fun bind(rule: Rule) {
            sceneName.text = rule.ruleName

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, SceneDetail::class.java)
                intent.putExtra("scene", rule)
                itemView.context.startActivity(intent)
            }
        }
    }

}