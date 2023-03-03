package com.example.robikaapps.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.robikaapps.models.Comment
import com.example.robikaapps.models.Post
import com.example.robikaapps.repository.PostsRepository
import kotlinx.coroutines.launch

class MainViewModel(
    app : Application,
    private val postsRepository : PostsRepository
) : AndroidViewModel(app) {


    fun savedPosts(posts: MutableList<Post>) = viewModelScope.launch {
        postsRepository.insertPosts(posts)
    }

    fun savedComments(comments: MutableList<Comment>) = viewModelScope.launch {
        postsRepository.insertComments(comments)
    }

    fun getNumberComment(id : Int) = viewModelScope.launch {
         postsRepository.getShowNumberComment(id)
    }
}