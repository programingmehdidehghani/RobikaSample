package com.example.robikaapps.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.robikaapps.models.Posts


@Database(
    entities = [Posts::class],
    version = 1
)
abstract class PostsDatabase : RoomDatabase(){

    abstract fun getPostsDao() : PostsDAO


    companion object{
        @Volatile
        private var instance : PostsDatabase ?= null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also{ instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                PostsDatabase::class.java,
                "posts_db.db"
            ).build()

    }
}