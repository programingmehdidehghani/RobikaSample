package com.example.robikaapps.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.robikaapps.models.Comment
import com.example.robikaapps.models.Post


@Dao
interface PostsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(article: MutableList<Post>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComments(article: MutableList<Comment>)

    @Query("SELECT * FROM posts WHERE id = :id")
    suspend fun getShowComment( id : Int) : List<Comment>
}