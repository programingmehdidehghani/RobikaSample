package com.example.robikaapps.db

import androidx.room.TypeConverter

class Converters{

    @TypeConverter
    fun fromSource(comments: List<String>) : List<String>{
        return comments
    }


}