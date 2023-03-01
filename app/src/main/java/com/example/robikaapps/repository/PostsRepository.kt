package com.example.robikaapps.repository

import com.example.robikaapps.db.PostsDatabase
import com.example.robikaapps.models.Posts

class PostsRepository(
    val db : PostsDatabase
) {
    suspend fun upsert (posts: MutableList<Posts>) = db.getPostsDao().insertPosts(posts)

}