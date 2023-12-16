package com.example.store.forum

class Post(val postID: Int, val title: String, val content: String) {
    companion object {
        private var newPostID = 40000 + 1
        val samplePostList = ArrayList<Post>()

        fun addPost(title: String, content: String) {
            samplePostList.add(Post(newPostID, title, content))
            newPostID += 1
        }
    }
}