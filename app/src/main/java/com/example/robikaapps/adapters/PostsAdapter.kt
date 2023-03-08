package com.example.robikaapps.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.TypedArrayUtils.getString
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.robikaapps.R
import com.example.robikaapps.models.Comment
import com.example.robikaapps.models.Post
import com.example.robikaapps.ui.ShowPostActivity
import kotlinx.android.synthetic.main.items_show_post.view.*
import kotlinx.coroutines.Job

@Suppress("UNSAFE_CALL_ON_PARTIALLY_DEFINED_RESOURCE")
class PostsAdapter(private val showPostActivity: ShowPostActivity) : RecyclerView.Adapter<PostsAdapter.ArticleViewHolder>() {

    private lateinit var showComment : MutableList<Comment>

    inner class ArticleViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<Post>(){
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this,differCallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.items_show_post,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener : ((Post) -> Unit) ?= null


    @SuppressLint("StringFormatMatches")
    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val post = differ.currentList[position]

        showComment  = showPostActivity.viewModel.getNumberComment(post.id!!,1) as MutableList<Comment>
        showComment.size

        holder.itemView.apply {
            Glide.with(this).load(post.urlImage).into(iv_picture_post_in_item)
            tv_caption_in_show_post_item.text = post.caption
            tv_number_comment_show_post_item.text = showPostActivity.getString(R.string.show_number_comment_post,showComment.size)
            tv_number_comment_show_post_item.text = showPostActivity.getString(R.string.show_number_comment_post,showComment.size)
      /*      setOnClickListener {
                onItemClickListener?.let { it(article) }
            }*/

        }
    }


}