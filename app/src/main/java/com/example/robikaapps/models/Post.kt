package com.example.robikaapps.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "posts"
)
data class Post(
    @PrimaryKey(autoGenerate = false)
    var id : Int? = null,
    var caption : String,
    var urlImage : String,
    var like : Int,
    var comment : Int
)


