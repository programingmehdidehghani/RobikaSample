package com.example.robikaapps.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.robikaapps.models.Comments
import com.example.robikaapps.models.Posts


@Dao
interface PostsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(article: MutableList<Posts>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComments(article: MutableList<Comments>)
}