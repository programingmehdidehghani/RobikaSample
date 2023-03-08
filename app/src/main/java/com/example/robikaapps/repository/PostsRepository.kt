package com.example.robikaapps.repository

import androidx.lifecycle.LiveData
import com.example.robikaapps.db.PostsDatabase
import com.example.robikaapps.db.PostsWithComments
import com.example.robikaapps.models.Comment
import com.example.robikaapps.models.Post

class PostsRepository(
    val db : PostsDatabase
) {
    suspend fun insertPosts (posts: MutableList<Post>) = db.getPostsDao().insertPosts(posts)

    suspend fun insertComments (comments: MutableList<Comment>) = db.getPostsDao().insertComments(comments)

    fun getShowNumberComment (id: Int,type: Int) : LiveData<List<Comment>> = db.getPostsDao().getShowComment(id,type)

    fun getListPost () = db.getPostsDao().getListPosts()



}