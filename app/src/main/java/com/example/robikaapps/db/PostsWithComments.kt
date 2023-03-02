package com.example.robikaapps.db

import androidx.room.Embedded
import androidx.room.Relation
import com.example.robikaapps.models.Comments
import com.example.robikaapps.models.Posts

data class PostsWithComments (
    @Embedded val posts: Posts,
    @Relation(
        parentColumn = "id",
        entityColumn = "postId"
    )
    val student: List<Comments>

)