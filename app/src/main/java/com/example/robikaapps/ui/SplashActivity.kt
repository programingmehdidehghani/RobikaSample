package com.example.robikaapps.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.robikaapps.R
import com.example.robikaapps.db.PostsDatabase
import com.example.robikaapps.models.Comment
import com.example.robikaapps.models.Post
import com.example.robikaapps.repository.PostsRepository
import java.util.*

class SplashActivity : AppCompatActivity() {

    private lateinit var viewModel: PostsViewModel
    var isFirstRun : Boolean = false


    @SuppressLint("ApplySharedPref")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val postsRepository = PostsRepository(PostsDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application , postsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[PostsViewModel::class.java]
        val sharedPreference =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)

        isFirstRun = sharedPreference.getBoolean("PREFERENCE_NAME",false)

        if (!isFirstRun){
            val editor = sharedPreference.edit()
            editor.putBoolean("PREFERENCE_NAME",true)
            editor.commit()
            editor.apply()
            insertPosts()
            insertComments()
        }
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
        val postList = mutableListOf<Post>()
        val post1 = Post(2,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post2 = Post(3,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post3 = Post(4,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post4 = Post(5,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post5 = Post(6,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post6 = Post(7,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post7 = Post(8,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post8 = Post(9,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post9 = Post(10,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post10 = Post(11,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post11 = Post(12,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post12 = Post(13,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post13 = Post(14,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post14 = Post(15,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post15 = Post(16,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post16 = Post(17,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post17 = Post(18,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post18 = Post(19,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post19 = Post(20,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post20 = Post(21,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post21 = Post(22,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post22 = Post(23,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post23 = Post(24,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post24 = Post(25,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post25 = Post(26,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post26 = Post(27,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post27 = Post(28,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post28 = Post(29,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post29 = Post(30,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
        val post30 = Post(30,"طبیعت مادر است، مادر هر آن چه که از زیبایی و عشق دیده ایم و ندیده ایم، مادر هر آن چه از خیر و برکت می دانیم و نمی دانیم، مادر خوبی و هر تصوری که می توان از خوبی در ذهن نگاشت یا تصورش را هم نتوان کرد.","https://picsum.photos/id/0/5000/3333",50)
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
        val commentList = mutableListOf<Comment>()
        val comment1 = Comment(1,1,"خیلی خوبه")
        val comment2 = Comment(1,1,"بهتر از این نیست")
        val comment3 = Comment(1,1,"عالی")
        val comment4 = Comment(1,1,"بد")
        commentList.add(comment1)
        commentList.add(comment2)
        commentList.add(comment3)
        commentList.add(comment4)
        viewModel.savedComments(commentList)



    }
}