package com.example.robikaapps.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.robikaapps.models.Posts
import com.example.robikaapps.repository.PostsRepository
import kotlinx.coroutines.launch

class PostsViewModel(
    app : Application,
    private val postsRepository : PostsRepository
) : AndroidViewModel(app) {


    fun savedArticle(posts: MutableList<Posts>) = viewModelScope.launch {
        postsRepository.upsert(posts)
    }
}