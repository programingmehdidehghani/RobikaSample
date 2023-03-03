package com.example.robikaapps.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "posts"
)
data class Posts(
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null,
    var caption : String,
    var urlImage : String,
    var like : Int
)


