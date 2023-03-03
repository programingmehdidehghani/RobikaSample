package com.example.robikaapps.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.robikaapps.repository.PostsRepository

class NewsViewModelProviderFactory(
    val app: Application,
    private val postsRepository: PostsRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PostsViewModel(app , postsRepository) as T
    }
}