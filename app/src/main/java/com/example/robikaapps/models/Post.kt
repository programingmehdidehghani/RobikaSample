package com.example.robikaapps.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "posts"
)
data class Post(
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null,
    var caption : String,
    var urlImage : String,
)


