package com.example.store

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.store.forum.Post

class PostAdapter(private val postList: ArrayList<Post>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.forum_item, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount() = postList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val post = postList[position]
        if (holder is PostViewHolder) {
            holder.bind(post)
        }
    }


    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val postTitle:TextView = itemView.findViewById(R.id.forumItemTitle)
        private val postContent:TextView = itemView.findViewById(R.id.forumItemContent)

        fun bind(post: Post) {
            postTitle.text = post.title
            postContent.text = post.content

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, PostDetail::class.java)
                intent.putExtra("postID", post.postID)
                itemView.context.startActivity(intent)
            }
        }
    }
}