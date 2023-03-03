package com.example.robikaapps.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.robikaapps.R
import com.example.robikaapps.db.PostsDatabase
import com.example.robikaapps.models.Posts
import com.example.robikaapps.repository.PostsRepository
import java.util.*
import kotlin.collections.ArrayList

class SplashActivity : AppCompatActivity() {

    private lateinit var viewModel: PostsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val postsRepository = PostsRepository(PostsDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application , postsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[PostsViewModel::class.java]
        insertPosts();
        Timer().schedule(object : TimerTask() {
            override fun run() {
                val intent = Intent(this@SplashActivity, ShowPostActivity::class.java)
                intent.addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or
                            Intent.FLAG_ACTIVITY_NEW_TASK
                )
                startActivity(intent)
                finishAffinity();
                finish();
            }
        }, 3000)
    }

    fun insertPosts(){
        val postList = mutableListOf<Posts>()
        val post1 = Posts(2,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post2 = Posts(3,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post3 = Posts(4,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post4 = Posts(5,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post5 = Posts(6,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post6 = Posts(7,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post7 = Posts(8,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post8 = Posts(9,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post9 = Posts(10,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post10 = Posts(11,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post11 = Posts(12,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post12 = Posts(13,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post13 = Posts(14,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post14 = Posts(15,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post15 = Posts(16,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post16 = Posts(17,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post17 = Posts(18,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post18 = Posts(19,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post19 = Posts(20,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post20 = Posts(21,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post21 = Posts(22,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post22 = Posts(23,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post23 = Posts(24,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post24 = Posts(25,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post25 = Posts(26,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post26 = Posts(27,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post27 = Posts(28,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post28 = Posts(29,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post29 = Posts(30,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post30 = Posts(30,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        postList.add(post1)
        postList.add(post2)
        postList.add(post3)
        postList.add(post4)
        postList.add(post5)
        postList.add(post6)
        postList.add(post7)
        postList.add(post8)
        postList.add(post9)
        postList.add(post10)
        postList.add(post11)
        postList.add(post12)
        postList.add(post13)
        postList.add(post14)
        postList.add(post15)
        postList.add(post16)
        postList.add(post17)
        postList.add(post18)
        postList.add(post19)
        postList.add(post20)
        postList.add(post21)
        postList.add(post22)
        postList.add(post23)
        postList.add(post24)
        postList.add(post25)
        postList.add(post26)
        postList.add(post27)
        postList.add(post28)
        postList.add(post29)
        postList.add(post30)
        viewModel.savedPosts(postList)
    }

    fun insertComments(){

    }
}