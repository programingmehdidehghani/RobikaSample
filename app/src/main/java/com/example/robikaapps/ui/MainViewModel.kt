package com.example.robikaapps.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.robikaapps.models.Comment
import com.example.robikaapps.models.Post
import com.example.robikaapps.repository.PostsRepository
import kotlinx.coroutines.*

class MainViewModel(
    app: Application,
    private val postsRepository: PostsRepository
) : AndroidViewModel(app) {


    fun savedPosts(posts: MutableList<Post>) = viewModelScope.launch {
        postsRepository.insertPosts(posts)
    }

    fun savedComments(comments: MutableList<Comment>) = viewModelScope.launch {
        postsRepository.insertComments(comments)
    }

    fun getNumberComment(id: Int, type: Int): LiveData<List<Comment>>  {
        return postsRepository.getShowNumberComment(id,type)
    }

    fun getNumberLike(id: Int, like: Int): LiveData<List<Comment>>  {
        return postsRepository.getShowNumberLike(id,like)
    }

    fun getShowPosts(): LiveData<List<Post>> {
        return postsRepository.getListPost()
    }
}