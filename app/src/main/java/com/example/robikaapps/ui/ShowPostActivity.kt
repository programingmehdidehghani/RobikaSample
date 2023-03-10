package com.example.robikaapps.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AbsListView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.robikaapps.R
import com.example.robikaapps.adapters.PostsAdapter
import com.example.robikaapps.db.PostsDatabase
import com.example.robikaapps.repository.PostsRepository
import kotlinx.android.synthetic.main.activity_show_post.*
import java.util.Objects

class ShowPostActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    private lateinit var postsAdapter: PostsAdapter
    var isLoading = false
    var isLastPage = false
    var isScrolling = false
    var currentItems = 0
    var totalItems = 0
    var scrollItems = 0
    val QUERY_PAGE_SIZE = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_post)
        showProgressBar()
        val postsRepository = PostsRepository(PostsDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application , postsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[MainViewModel::class.java]
        setupRecyclerView()
        fetchData()


    }


    private fun hideProgressBar() {
        progress_in_show_post_activity.visibility = View.INVISIBLE
        isLoading = false
    }

    private fun showProgressBar() {
        progress_in_show_post_activity.visibility = View.VISIBLE
        isLoading = true
    }

    val scrollListener = object : RecyclerView.OnScrollListener(){
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val layoutManager = recyclerView.layoutManager as LinearLayoutManager
            currentItems = layoutManager.childCount
            totalItems = layoutManager.itemCount
            scrollItems = layoutManager.findFirstVisibleItemPosition()
            val isNotLoadingAndNotLastPage = !isLoading
            val isAtLastItem = scrollItems + currentItems >= totalItems
            val isNotAtBeginning = scrollItems >= 0
            val isTotalMoreThanVisible = totalItems >= QUERY_PAGE_SIZE
            val shouldPaginate = isNotLoadingAndNotLastPage && isAtLastItem && isNotAtBeginning &&
                    isTotalMoreThanVisible && isScrolling
            if (shouldPaginate){
                fetchData()
                isScrolling = false
                hideProgressBar()
            }
        }


        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                isScrolling = true
                showProgressBar()
            }
        }
    }


    private fun fetchData() {
        viewModel.getShowPosts().observe(this, Observer {
            postsAdapter.differ.submitList(it)
        })
    }

    private fun setupRecyclerView(){
        postsAdapter = PostsAdapter(this@ShowPostActivity)
        rv_show_posts_in_activity.apply {
            adapter = postsAdapter
            layoutManager = LinearLayoutManager(this@ShowPostActivity)
            addOnScrollListener(this@ShowPostActivity.scrollListener)
        }
    }
}