package com.example.robikaapps.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.robikaapps.R
import com.example.robikaapps.adapters.PostsAdapter
import com.example.robikaapps.db.PostsDatabase
import com.example.robikaapps.models.Comment
import com.example.robikaapps.repository.PostsRepository
import kotlinx.android.synthetic.main.activity_show_post.*

class ShowPostActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var showNumberComments : List<Comment>
    lateinit var postsAdapter: PostsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_post)
        val postsRepository = PostsRepository(PostsDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application , postsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[MainViewModel::class.java]
        setupRecyclerView()
    }

    private fun setupRecyclerView(){
        postsAdapter = PostsAdapter()
        rv_show_posts_in_activity.apply {
            adapter = postsAdapter
            layoutManager = LinearLayoutManager(this@ShowPostActivity)
        }
    }
}