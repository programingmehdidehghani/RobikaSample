package com.example.robikaapps.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.robikaapps.models.Comment
import com.example.robikaapps.models.Post


@Dao
interface PostsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(article: MutableList<Post>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComments(article: MutableList<Comment>)
}