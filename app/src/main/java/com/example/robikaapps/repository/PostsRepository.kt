package com.example.robikaapps.repository

import com.example.robikaapps.db.PostsDatabase
import com.example.robikaapps.models.Comments
import com.example.robikaapps.models.Posts

class PostsRepository(
    val db : PostsDatabase
) {
    suspend fun insertPosts (posts: MutableList<Posts>) = db.getPostsDao().insertPosts(posts)

    suspend fun insertComments (comments: MutableList<Comments>) = db.getPostsDao().insertComments(comments)

}