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

    fun getNumberComment(id: Int, type: Int): MutableList<Comment>  {
        var showComment : List<Comment> = emptyList()
        CoroutineScope(Dispatchers.Default).launch {
            showComment =  postsRepository.getShowNumberComment(id,type)
        }
        return showComment.toMutableList()

    }

    fun getShowPosts(): LiveData<List<Post>> {
        return postsRepository.getListPost()
    }
}