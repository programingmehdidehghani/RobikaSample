package com.example.robikaapps.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.robikaapps.models.Comment
import com.example.robikaapps.models.Post


@Dao
interface PostsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(article: MutableList<Post>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComments(article: MutableList<Comment>)

    @Query("SELECT * FROM comment WHERE postId = :id AND isComment = :type")
    fun getShowComment(id: Int,type: Int) : LiveData<List<Comment>>



    @Query("SELECT * FROM posts")
    fun getListPosts() : LiveData<List<Post>>
}