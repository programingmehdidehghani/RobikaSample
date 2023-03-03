package com.example.robikaapps.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "comment"
)
data class Comment(
    @PrimaryKey(autoGenerate = false)
    var id : Int? = null,
    var postId : Int,
    val comment : String,
    val like : Int,
    val isComment: Int,
)