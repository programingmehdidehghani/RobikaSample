package com.example.robikaapps.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.robikaapps.R
import com.example.robikaapps.db.PostsDatabase
import com.example.robikaapps.repository.PostsRepository

class ShowPostActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_post)
        val postsRepository = PostsRepository(PostsDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application , postsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[MainViewModel::class.java]
    }
}