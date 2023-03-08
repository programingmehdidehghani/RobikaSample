package com.example.robikaapps.adapters

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.transition.Transition
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.Target
import com.example.robikaapps.R
import com.example.robikaapps.models.Comment
import com.example.robikaapps.models.Post
import com.example.robikaapps.ui.ShowPostActivity
import kotlinx.android.synthetic.main.items_show_post.view.*
import java.util.Objects
import javax.sql.DataSource


@Suppress("UNSAFE_CALL_ON_PARTIALLY_DEFINED_RESOURCE")
class PostsAdapter(private val showPostActivity: ShowPostActivity) : RecyclerView.Adapter<PostsAdapter.ArticleViewHolder>() {


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


        holder.itemView.apply {
            Glide.with(this).load("https://www.soorban.com/images/news/2022/03/1647069572_U9tU4.jpg")
                .listener(object: RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        Log.i("load","doesn't failed")
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: com.bumptech.glide.load.DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        Log.i("load","ready")
                        return false
                    }

                })
                .into(iv_picture_post_in_item)


            tv_caption_in_show_post_item.text = post.caption

            showPostActivity.viewModel.getNumberComment(post.id!!,1).observe(showPostActivity, Observer {
                tv_number_comment_show_post_item.text = showPostActivity.getString(R.string.show_number_comment_post,it.size)
            })
            showPostActivity.viewModel.getNumberLike(post.id!!,1).observe(showPostActivity, Observer {
                tv_number_like_by_people_in_show_post.text = showPostActivity.getString(R.string.show_number_like_post,it.size)
            })
      /*      setOnClickListener {
                onItemClickListener?.let { it(article) }
            }*/

        }
    }


}