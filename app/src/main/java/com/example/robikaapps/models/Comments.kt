package com.example.robikaapps.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "comment"
)
data class Comments(
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null,
    var postId : Int,
    val comment : String
)