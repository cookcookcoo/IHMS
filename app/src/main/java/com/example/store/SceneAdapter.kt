package com.example.store

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
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
        private val sceneSwitch:Switch = itemView.findViewById(R.id.sceneSwitch)

        fun bind(rule: Rule) {
            sceneName.text = rule.ruleName

            itemView.alpha=0.7f

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, SceneDetail::class.java)
                intent.putExtra("sceneID", rule.ruleID)
                itemView.context.startActivity(intent)
            }

            sceneSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    rule.execute()
                    Toast.makeText(buttonView.context, "Scene Run", Toast.LENGTH_SHORT).show()
                } else { }
            }
        }
    }

}