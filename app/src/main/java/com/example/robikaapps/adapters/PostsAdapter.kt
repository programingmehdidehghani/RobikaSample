package com.example.robikaapps.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.robikaapps.R
import com.example.robikaapps.models.Post
import kotlinx.android.synthetic.main.items_show_post.view.*

class PostsAdapter : RecyclerView.Adapter<PostsAdapter.ArticleViewHolder>() {


    inner class ArticleViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<Post>(){
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this,differCallback)
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


    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val post = differ.currentList[position]
        val numberLike : Int = post.like


        holder.itemView.apply {
            Glide.with(this).load(post.urlImage).into(iv_picture_post_in_item)
            tv_caption_in_show_post_item.text = post.caption

      /*      setOnClickListener {
                onItemClickListener?.let { it(article) }
            }*/

        }
    }


}