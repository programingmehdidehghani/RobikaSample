package com.example.robikaapps.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "Posts"
)
data class Posts(
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null,
    var caption : String,
    var urlImage : String,
    var like : Int,
    var comment : List<String>
)
