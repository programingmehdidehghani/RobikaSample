package com.example.robikaapps.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
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
    private lateinit var postsAdapter: PostsAdapter
    var isLoading = false
    var isLastPage = false
    var isScrolling = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_post)
        showProgressBar()
        val postsRepository = PostsRepository(PostsDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application , postsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[MainViewModel::class.java]
        setupRecyclerView()
        viewModel.getShowPosts().observe(this, Observer {
            hideProgressBar()
            postsAdapter.differ.submitList(it)
        })
    }

    private fun hideProgressBar() {
        progress_in_show_post_activity.visibility = View.INVISIBLE
        isLoading = false
    }

    private fun showProgressBar() {
        progress_in_show_post_activity.visibility = View.VISIBLE
        isLoading = true
    }

    private fun setupRecyclerView(){
        postsAdapter = PostsAdapter()
        rv_show_posts_in_activity.apply {
            adapter = postsAdapter
            layoutManager = LinearLayoutManager(this@ShowPostActivity)
        }
    }
}