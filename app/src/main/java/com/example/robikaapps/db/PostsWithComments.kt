package com.example.robikaapps.db

import androidx.room.Embedded
import androidx.room.Relation
import com.example.robikaapps.models.Comment
import com.example.robikaapps.models.Post

data class PostsWithComments (
    @Embedded val posts: Post,
    @Relation(
        parentColumn = "id",
        entityColumn = "postId"
    )
    val student: List<Comment>

)