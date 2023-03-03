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
        setContentView(R.layout.splash_activity_main)
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
        val comment1 = Comment(1,1,"بی شک آن که درخت می کارد به غیر از خودش دیگران را نیز دوست دارد")
        val comment2 = Comment(2,1,"طبیعت هرگز از مد نمی افتد زیرا شاهکار خداست\n" +
                "\n")
        val comment3 = Comment(3,1,"جرات داشته باشید و جهان را برای کشف مکان های زیبا و سر به مهر آن جستجو کنید\n" +
                "\n")
        val comment4 = Comment(4,1,"جرات داشته باشید و جهان را برای کشف مکان های زیبا و سر به مهر آن جستجو کنید\n" +
                "\n")
        val comment5 = Comment(5,1,"بد")
        val comment6 = Comment(6,1,"بد")
        val comment7 = Comment(7,1,"بد")
        val comment8 = Comment(8,1,"بد")
        val comment9 = Comment(9,1,"بد")
        val comment10 = Comment(10,1,"بد")
        val comment11 = Comment(11,1,"بد")
        val comment12 = Comment(12,2,"جرات داشته باشید و جهان را برای کشف مکان های زیبا و سر به مهر آن جستجو کنید\n" +
                "\n")
        val comment13 = Comment(13,2,"جرات داشته باشید و جهان را برای کشف مکان های زیبا و سر به مهر آن جستجو کنید\n" +
                "\n")
        val comment14 = Comment(14,2,"جرات داشته باشید و جهان را برای کشف مکان های زیبا و سر به مهر آن جستجو کنید\n" +
                "\n")
        val comment15 = Comment(15,2,"جرات داشته باشید و جهان را برای کشف مکان های زیبا و سر به مهر آن جستجو کنید\n" +
                "\n")
        val comment16 = Comment(16,2,"جرات داشته باشید و جهان را برای کشف مکان های زیبا و سر به مهر آن جستجو کنید\n" +
                "\n")
        val comment17 = Comment(17,2,"جرات داشته باشید و جهان را برای کشف مکان های زیبا و سر به مهر آن جستجو کنید\n" +
                "\n")
        val comment18 = Comment(18,2,"جرات داشته باشید و جهان را برای کشف مکان های زیبا و سر به مهر آن جستجو کنید\n" +
                "\n")
        val comment19 = Comment(19,2,"جرات داشته باشید و جهان را برای کشف مکان های زیبا و سر به مهر آن جستجو کنید\n" +
                "\n")
        val comment20 = Comment(20,2,"جرات داشته باشید و جهان را برای کشف مکان های زیبا و سر به مهر آن جستجو کنید\n" +
                "\n")
        val comment21 = Comment(21,2,"جرات داشته باشید و جهان را برای کشف مکان های زیبا و سر به مهر آن جستجو کنید\n" +
                "\n")
        val comment22 = Comment(22,2,"جرات داشته باشید و جهان را برای کشف مکان های زیبا و سر به مهر آن جستجو کنید\n" +
                "\n")
        val comment23 = Comment(23,2,"جرات داشته باشید و جهان را برای کشف مکان های زیبا و سر به مهر آن جستجو کنید\n" +
                "\n")
        val comment24 = Comment(24,2,"جرات داشته باشید و جهان را برای کشف مکان های زیبا و سر به مهر آن جستجو کنید\n" +
                "\n")
        val comment25 = Comment(25,2,"جرات داشته باشید و جهان را برای کشف مکان های زیبا و سر به مهر آن جستجو کنید\n" +
                "\n")
        val comment26 = Comment(26,2,"جرات داشته باشید و جهان را برای کشف مکان های زیبا و سر به مهر آن جستجو کنید\n" +
                "\n")
        val comment27 = Comment(27,2,"جرات داشته باشید و جهان را برای کشف مکان های زیبا و سر به مهر آن جستجو کنید\n" +
                "\n")
        val comment28 = Comment(28,2,"بد")

        commentList.add(comment1)
        commentList.add(comment2)
        commentList.add(comment3)
        commentList.add(comment4)
        commentList.add(comment5)
        commentList.add(comment6)
        commentList.add(comment7)
        commentList.add(comment8)
        commentList.add(comment9)
        commentList.add(comment10)
        commentList.add(comment11)
        commentList.add(comment12)
        commentList.add(comment13)
        commentList.add(comment14)
        commentList.add(comment15)
        commentList.add(comment16)
        commentList.add(comment17)
        commentList.add(comment18)
        commentList.add(comment19)
        commentList.add(comment20)
        commentList.add(comment21)
        commentList.add(comment22)
        commentList.add(comment23)
        commentList.add(comment24)
        commentList.add(comment25)
        commentList.add(comment26)
        commentList.add(comment27)
        commentList.add(comment28)

        viewModel.savedComments(commentList)



    }
}