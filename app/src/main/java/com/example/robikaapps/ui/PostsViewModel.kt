package com.example.robikaapps.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.robikaapps.models.Comments
import com.example.robikaapps.models.Posts
import com.example.robikaapps.repository.PostsRepository
import kotlinx.coroutines.launch

class PostsViewModel(
    app : Application,
    private val postsRepository : PostsRepository
) : AndroidViewModel(app) {


    fun savedPosts(posts: MutableList<Posts>) = viewModelScope.launch {
        postsRepository.insertPosts(posts)
    }

    fun savedComments(comments: MutableList<Comments>) = viewModelScope.launch {
        postsRepository.insertComments(comments)
    }
}