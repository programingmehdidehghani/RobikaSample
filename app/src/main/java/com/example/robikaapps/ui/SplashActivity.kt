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

    private lateinit var viewModel: MainViewModel
    var isFirstRun : Boolean = false


    @SuppressLint("ApplySharedPref")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity_main)
        val postsRepository = PostsRepository(PostsDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application , postsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[MainViewModel::class.java]
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
        val post1 = Post(1,"?????????? ???????? ???????? ???????? ???? ???? ???? ???? ???? ???????????? ?? ?????? ???????? ?????? ?? ?????????? ???????? ???????? ???? ???? ???? ???? ?????? ?? ???????? ???? ?????????? ?? ?????? ???????????? ???????? ???????? ?? ???? ?????????? ???? ???? ???????? ???? ???????? ???? ?????? ?????????? ???? ?????????? ???? ???? ?????????? ??????.","https://picsum.photos/id/10/2500/1667")
        val post2 = Post(2,"?????????? ???????? ???????? ???????? ???? ???? ???? ???? ???? ???????????? ?? ?????? ???????? ?????? ?? ?????????? ???????? ???????? ???? ???? ???? ???? ?????? ?? ???????? ???? ?????????? ?? ?????? ???????????? ???????? ???????? ?? ???? ?????????? ???? ???? ???????? ???? ???????? ???? ?????? ?????????? ???? ?????????? ???? ???? ?????????? ??????.","https://picsum.photos/id/28/4928/3264")
        val post3 = Post(3,"?????????? ???????? ???????? ???????? ???? ???? ???? ???? ???? ???????????? ?? ?????? ???????? ?????? ?? ?????????? ???????? ???????? ???? ???? ???? ???? ?????? ?? ???????? ???? ?????????? ?? ?????? ???????????? ???????? ???????? ?? ???? ?????????? ???? ???? ???????? ???? ???????? ???? ?????? ?????????? ???? ?????????? ???? ???? ?????????? ??????.","https://picsum.photos/id/27/3264/1836")
        val post4 = Post(4,"?????????? ???????? ???????? ???????? ???? ???? ???? ???? ???? ???????????? ?? ?????? ???????? ?????? ?? ?????????? ???????? ???????? ???? ???? ???? ???? ?????? ?? ???????? ???? ?????????? ?? ?????? ???????????? ???????? ???????? ?? ???? ?????????? ???? ???? ???????? ???? ???????? ???? ?????? ?????????? ???? ?????????? ???? ???? ?????????? ??????.","https://picsum.photos/id/24/4855/1803")
        val post5 = Post(5,"?????????? ???????? ???????? ???????? ???? ???? ???? ???? ???? ???????????? ?? ?????? ???????? ?????? ?? ?????????? ???????? ???????? ???? ???? ???? ???? ?????? ?? ???????? ???? ?????????? ?? ?????? ???????????? ???????? ???????? ?? ???? ?????????? ???? ???? ???????? ???? ???????? ???? ?????? ?????????? ???? ?????????? ???? ???? ?????????? ??????.","https://picsum.photos/id/0/5000/3333")
        val post6 = Post(6,"?????????? ???????? ???????? ???????? ???? ???? ???? ???? ???? ???????????? ?? ?????? ???????? ?????? ?? ?????????? ???????? ???????? ???? ???? ???? ???? ?????? ?? ???????? ???? ?????????? ?? ?????? ???????????? ???????? ???????? ?? ???? ?????????? ???? ???? ???????? ???? ???????? ???? ?????? ?????????? ???? ?????????? ???? ???? ?????????? ??????.","https://picsum.photos/id/20/3670/2462")
        val post7 = Post(7,"?????????? ???????? ???????? ???????? ???? ???? ???? ???? ???? ???????????? ?? ?????? ???????? ?????? ?? ?????????? ???????? ???????? ???? ???? ???? ???? ?????? ?? ???????? ???? ?????????? ?? ?????? ???????????? ???????? ???????? ?? ???? ?????????? ???? ???? ???????? ???? ???????? ???? ?????? ?????????? ???? ?????????? ???? ???? ?????????? ??????.","https://picsum.photos/id/20/3670/2462")
        val post8 = Post(8,"?????????? ???????? ???????? ???????? ???? ???? ???? ???? ???? ???????????? ?? ?????? ???????? ?????? ?? ?????????? ???????? ???????? ???? ???? ???? ???? ?????? ?? ???????? ???? ?????????? ?? ?????? ???????????? ???????? ???????? ?? ???? ?????????? ???? ???? ???????? ???? ???????? ???? ?????? ?????????? ???? ?????????? ???? ???? ?????????? ??????.","https://picsum.photos/id/0/5000/3333")
        val post9 = Post(9,"?????????? ???????? ???????? ???????? ???? ???? ???? ???? ???? ???????????? ?? ?????? ???????? ?????? ?? ?????????? ???????? ???????? ???? ???? ???? ???? ?????? ?? ???????? ???? ?????????? ?? ?????? ???????????? ???????? ???????? ?? ???? ?????????? ???? ???? ???????? ???? ???????? ???? ?????? ?????????? ???? ?????????? ???? ???? ?????????? ??????.","https://picsum.photos/id/0/5000/3333")
        val post10 = Post(10,"?????????? ???????? ???????? ???????? ???? ???? ???? ???? ???? ???????????? ?? ?????? ???????? ?????? ?? ?????????? ???????? ???????? ???? ???? ???? ???? ?????? ?? ???????? ???? ?????????? ?? ?????? ???????????? ???????? ???????? ?? ???? ?????????? ???? ???? ???????? ???? ???????? ???? ?????? ?????????? ???? ?????????? ???? ???? ?????????? ??????.","https://picsum.photos/id/29/4000/2670")
        val post11 = Post(11,"?????????? ???????? ???????? ???????? ???? ???? ???? ???? ???? ???????????? ?? ?????? ???????? ?????? ?? ?????????? ???????? ???????? ???? ???? ???? ???? ?????? ?? ???????? ???? ?????????? ?? ?????? ???????????? ???????? ???????? ?? ???? ?????????? ???? ???? ???????? ???? ???????? ???? ?????? ?????????? ???? ?????????? ???? ???? ?????????? ??????.","https://picsum.photos/id/0/5000/3333")
        val post12 = Post(12,"?????????? ???????? ???????? ???????? ???? ???? ???? ???? ???? ???????????? ?? ?????? ???????? ?????? ?? ?????????? ???????? ???????? ???? ???? ???? ???? ?????? ?? ???????? ???? ?????????? ?? ?????? ???????????? ???????? ???????? ?? ???? ?????????? ???? ???? ???????? ???? ???????? ???? ?????? ?????????? ???? ?????????? ???? ???? ?????????? ??????.","https://picsum.photos/id/0/5000/3333")
        val post13 = Post(13,"?????????? ???????? ???????? ???????? ???? ???? ???? ???? ???? ???????????? ?? ?????? ???????? ?????? ?? ?????????? ???????? ???????? ???? ???? ???? ???? ?????? ?? ???????? ???? ?????????? ?? ?????? ???????????? ???????? ???????? ?? ???? ?????????? ???? ???? ???????? ???? ???????? ???? ?????? ?????????? ???? ?????????? ???? ???? ?????????? ??????.","https://picsum.photos/id/0/5000/3333")
        val post14 = Post(14,"?????????? ???????? ???????? ???????? ???? ???? ???? ???? ???? ???????????? ?? ?????? ???????? ?????? ?? ?????????? ???????? ???????? ???? ???? ???? ???? ?????? ?? ???????? ???? ?????????? ?? ?????? ???????????? ???????? ???????? ?? ???? ?????????? ???? ???? ???????? ???? ???????? ???? ?????? ?????????? ???? ?????????? ???? ???? ?????????? ??????.","https://picsum.photos/id/0/5000/3333")
        val post15 = Post(15,"?????????? ???????? ???????? ???????? ???? ???? ???? ???? ???? ???????????? ?? ?????? ???????? ?????? ?? ?????????? ???????? ???????? ???? ???? ???? ???? ?????? ?? ???????? ???? ?????????? ?? ?????? ???????????? ???????? ???????? ?? ???? ?????????? ???? ???? ???????? ???? ???????? ???? ?????? ?????????? ???? ?????????? ???? ???? ?????????? ??????.","https://picsum.photos/id/0/5000/3333")
        val post16 = Post(16,"?????????? ???????? ???????? ???????? ???? ???? ???? ???? ???? ???????????? ?? ?????? ???????? ?????? ?? ?????????? ???????? ???????? ???? ???? ???? ???? ?????? ?? ???????? ???? ?????????? ?? ?????? ???????????? ???????? ???????? ?? ???? ?????????? ???? ???? ???????? ???? ???????? ???? ?????? ?????????? ???? ?????????? ???? ???? ?????????? ??????.","https://picsum.photos/id/0/5000/3333")
        val post17 = Post(17,"?????????? ???????? ???????? ???????? ???? ???? ???? ???? ???? ???????????? ?? ?????? ???????? ?????? ?? ?????????? ???????? ???????? ???? ???? ???? ???? ?????? ?? ???????? ???? ?????????? ?? ?????? ???????????? ???????? ???????? ?? ???? ?????????? ???? ???? ???????? ???? ???????? ???? ?????? ?????????? ???? ?????????? ???? ???? ?????????? ??????.","https://picsum.photos/id/0/5000/3333")
        val post18 = Post(18,"?????????? ???????? ???????? ???????? ???? ???? ???? ???? ???? ???????????? ?? ?????? ???????? ?????? ?? ?????????? ???????? ???????? ???? ???? ???? ???? ?????? ?? ???????? ???? ?????????? ?? ?????? ???????????? ???????? ???????? ?? ???? ?????????? ???? ???? ???????? ???? ???????? ???? ?????? ?????????? ???? ?????????? ???? ???? ?????????? ??????.","https://picsum.photos/id/0/5000/3333")
        val post19 = Post(19,"?????????? ???????? ???????? ???????? ???? ???? ???? ???? ???? ???????????? ?? ?????? ???????? ?????? ?? ?????????? ???????? ???????? ???? ???? ???? ???? ?????? ?? ???????? ???? ?????????? ?? ?????? ???????????? ???????? ???????? ?? ???? ?????????? ???? ???? ???????? ???? ???????? ???? ?????? ?????????? ???? ?????????? ???? ???? ?????????? ??????.","https://picsum.photos/id/0/5000/3333")
        val post20 = Post(20,"?????????? ???????? ???????? ???????? ???? ???? ???? ???? ???? ???????????? ?? ?????? ???????? ?????? ?? ?????????? ???????? ???????? ???? ???? ???? ???? ?????? ?? ???????? ???? ?????????? ?? ?????? ???????????? ???????? ???????? ?? ???? ?????????? ???? ???? ???????? ???? ???????? ???? ?????? ?????????? ???? ?????????? ???? ???? ?????????? ??????.","https://picsum.photos/id/0/5000/3333")
        val post21 = Post(21,"?????????? ???????? ???????? ???????? ???? ???? ???? ???? ???? ???????????? ?? ?????? ???????? ?????? ?? ?????????? ???????? ???????? ???? ???? ???? ???? ?????? ?? ???????? ???? ?????????? ?? ?????? ???????????? ???????? ???????? ?? ???? ?????????? ???? ???? ???????? ???? ???????? ???? ?????? ?????????? ???? ?????????? ???? ???? ?????????? ??????.","https://picsum.photos/id/0/5000/3333")
        val post22 = Post(22,"?????????? ???????? ???????? ???????? ???? ???? ???? ???? ???? ???????????? ?? ?????? ???????? ?????? ?? ?????????? ???????? ???????? ???? ???? ???? ???? ?????? ?? ???????? ???? ?????????? ?? ?????? ???????????? ???????? ???????? ?? ???? ?????????? ???? ???? ???????? ???? ???????? ???? ?????? ?????????? ???? ?????????? ???? ???? ?????????? ??????.","https://picsum.photos/id/0/5000/3333")
        val post23 = Post(23,"?????????? ???????? ???????? ???????? ???? ???? ???? ???? ???? ???????????? ?? ?????? ???????? ?????? ?? ?????????? ???????? ???????? ???? ???? ???? ???? ?????? ?? ???????? ???? ?????????? ?? ?????? ???????????? ???????? ???????? ?? ???? ?????????? ???? ???? ???????? ???? ???????? ???? ?????? ?????????? ???? ?????????? ???? ???? ?????????? ??????.","https://picsum.photos/id/0/5000/3333")
        val post24 = Post(24,"?????????? ???????? ???????? ???????? ???? ???? ???? ???? ???? ???????????? ?? ?????? ???????? ?????? ?? ?????????? ???????? ???????? ???? ???? ???? ???? ?????? ?? ???????? ???? ?????????? ?? ?????? ???????????? ???????? ???????? ?? ???? ?????????? ???? ???? ???????? ???? ???????? ???? ?????? ?????????? ???? ?????????? ???? ???? ?????????? ??????.","https://picsum.photos/id/0/5000/3333")
        val post25 = Post(25,"?????????? ???????? ???????? ???????? ???? ???? ???? ???? ???? ???????????? ?? ?????? ???????? ?????? ?? ?????????? ???????? ???????? ???? ???? ???? ???? ?????? ?? ???????? ???? ?????????? ?? ?????? ???????????? ???????? ???????? ?? ???? ?????????? ???? ???? ???????? ???? ???????? ???? ?????? ?????????? ???? ?????????? ???? ???? ?????????? ??????.","https://picsum.photos/id/0/5000/3333")
        val post26 = Post(26,"?????????? ???????? ???????? ???????? ???? ???? ???? ???? ???? ???????????? ?? ?????? ???????? ?????? ?? ?????????? ???????? ???????? ???? ???? ???? ???? ?????? ?? ???????? ???? ?????????? ?? ?????? ???????????? ???????? ???????? ?? ???? ?????????? ???? ???? ???????? ???? ???????? ???? ?????? ?????????? ???? ?????????? ???? ???? ?????????? ??????.","https://picsum.photos/id/0/5000/3333")
        val post27 = Post(27,"?????????? ???????? ???????? ???????? ???? ???? ???? ???? ???? ???????????? ?? ?????? ???????? ?????? ?? ?????????? ???????? ???????? ???? ???? ???? ???? ?????? ?? ???????? ???? ?????????? ?? ?????? ???????????? ???????? ???????? ?? ???? ?????????? ???? ???? ???????? ???? ???????? ???? ?????? ?????????? ???? ?????????? ???? ???? ?????????? ??????.","https://picsum.photos/id/0/5000/3333")
        val post28 = Post(28,"?????????? ???????? ???????? ???????? ???? ???? ???? ???? ???? ???????????? ?? ?????? ???????? ?????? ?? ?????????? ???????? ???????? ???? ???? ???? ???? ?????? ?? ???????? ???? ?????????? ?? ?????? ???????????? ???????? ???????? ?? ???? ?????????? ???? ???? ???????? ???? ???????? ???? ?????? ?????????? ???? ?????????? ???? ???? ?????????? ??????.","https://picsum.photos/id/0/5000/3333")
        val post29 = Post(29,"?????????? ???????? ???????? ???????? ???? ???? ???? ???? ???? ???????????? ?? ?????? ???????? ?????? ?? ?????????? ???????? ???????? ???? ???? ???? ???? ?????? ?? ???????? ???? ?????????? ?? ?????? ???????????? ???????? ???????? ?? ???? ?????????? ???? ???? ???????? ???? ???????? ???? ?????? ?????????? ???? ?????????? ???? ???? ?????????? ??????.","https://picsum.photos/id/0/5000/3333")
        val post30 = Post(30,"?????????? ???????? ???????? ???????? ???? ???? ???? ???? ???? ???????????? ?? ?????? ???????? ?????? ?? ?????????? ???????? ???????? ???? ???? ???? ???? ?????? ?? ???????? ???? ?????????? ?? ?????? ???????????? ???????? ???????? ?? ???? ?????????? ???? ???? ???????? ???? ???????? ???? ?????? ?????????? ???? ?????????? ???? ???? ?????????? ??????.","https://picsum.photos/id/0/5000/3333")
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
        val comment1 = Comment(1,1,"???? ???? ???? ???? ???????? ???? ???????? ???? ?????? ???? ???????? ???????????? ???? ?????? ???????? ????????",1,1)
        val comment2 = Comment(2,1,"?????????? ???????? ???? ???? ?????? ???????? ???????? ???????????? ??????????\n" +
                "\n",0,1)
        val comment3 = Comment(3,1,"???????? ?????????? ?????????? ?? ???????? ???? ???????? ?????? ???????? ?????? ???????? ?? ???? ???? ?????? ???? ?????????? ????????\n" +
                "\n",0,1)
        val comment4 = Comment(4,1,"???????? ?????????? ?????????? ?? ???????? ???? ???????? ?????? ???????? ?????? ???????? ?? ???? ???? ?????? ???? ?????????? ????????\n" +
                "\n",0,1)
        val comment5 = Comment(5,1,"????",1,1)
        val comment6 = Comment(6,1,"????",1,1)
        val comment7 = Comment(7,1,"????",0,1)
        val comment8 = Comment(8,1,"????",1,1)
        val comment9 = Comment(9,1,"????",0,1)
        val comment10 = Comment(10,1,"????",1,1)
        val comment11 = Comment(11,1,"????",1,1)
        val comment12 = Comment(12,2,"???????? ?????????? ?????????? ?? ???????? ???? ???????? ?????? ???????? ?????? ???????? ?? ???? ???? ?????? ???? ?????????? ????????\n" +
                "\n",0,1)
        val comment13 = Comment(13,2,"???????? ?????????? ?????????? ?? ???????? ???? ???????? ?????? ???????? ?????? ???????? ?? ???? ???? ?????? ???? ?????????? ????????\n" +
                "\n",1,1)
        val comment14 = Comment(14,2,"???????? ?????????? ?????????? ?? ???????? ???? ???????? ?????? ???????? ?????? ???????? ?? ???? ???? ?????? ???? ?????????? ????????\n" +
                "\n",1,1)
        val comment15 = Comment(15,2,"???????? ?????????? ?????????? ?? ???????? ???? ???????? ?????? ???????? ?????? ???????? ?? ???? ???? ?????? ???? ?????????? ????????\n" +
                "\n",1,1)
        val comment16 = Comment(16,2,"???????? ?????????? ?????????? ?? ???????? ???? ???????? ?????? ???????? ?????? ???????? ?? ???? ???? ?????? ???? ?????????? ????????\n" +
                "\n",1,1)
        val comment17 = Comment(17,2,"???????? ?????????? ?????????? ?? ???????? ???? ???????? ?????? ???????? ?????? ???????? ?? ???? ???? ?????? ???? ?????????? ????????\n" +
                "\n",1,1)
        val comment18 = Comment(18,2,"???????? ?????????? ?????????? ?? ???????? ???? ???????? ?????? ???????? ?????? ???????? ?? ???? ???? ?????? ???? ?????????? ????????\n" +
                "\n",1,1)
        val comment19 = Comment(19,2,"???????? ?????????? ?????????? ?? ???????? ???? ???????? ?????? ???????? ?????? ???????? ?? ???? ???? ?????? ???? ?????????? ????????\n" +
                "\n",1,1)
        val comment20 = Comment(20,2,"???????? ?????????? ?????????? ?? ???????? ???? ???????? ?????? ???????? ?????? ???????? ?? ???? ???? ?????? ???? ?????????? ????????\n" +
                "\n",1,1)
        val comment21 = Comment(21,2,"???????? ?????????? ?????????? ?? ???????? ???? ???????? ?????? ???????? ?????? ???????? ?? ???? ???? ?????? ???? ?????????? ????????\n" +
                "\n",1,1)
        val comment22 = Comment(22,2,"???????? ?????????? ?????????? ?? ???????? ???? ???????? ?????? ???????? ?????? ???????? ?? ???? ???? ?????? ???? ?????????? ????????\n" +
                "\n",1,1)
        val comment23 = Comment(23,2,"???????? ?????????? ?????????? ?? ???????? ???? ???????? ?????? ???????? ?????? ???????? ?? ???? ???? ?????? ???? ?????????? ????????\n" +
                "\n",0,1)
        val comment24 = Comment(24,2,"???????? ?????????? ?????????? ?? ???????? ???? ???????? ?????? ???????? ?????? ???????? ?? ???? ???? ?????? ???? ?????????? ????????\n" +
                "\n",0,1)
        val comment25 = Comment(25,2,"???????? ?????????? ?????????? ?? ???????? ???? ???????? ?????? ???????? ?????? ???????? ?? ???? ???? ?????? ???? ?????????? ????????\n" +
                "\n",0,1)
        val comment26 = Comment(26,2,"???????? ?????????? ?????????? ?? ???????? ???? ???????? ?????? ???????? ?????? ???????? ?? ???? ???? ?????? ???? ?????????? ????????\n" +
                "\n",1,1)
        val comment27 = Comment(27,2,"???????? ?????????? ?????????? ?? ???????? ???? ???????? ?????? ???????? ?????? ???????? ?? ???? ???? ?????? ???? ?????????? ????????\n" +
                "\n",1,1)
        val comment28 = Comment(28,5,"????",1,1)
        val comment29 = Comment(29,8,"????",1,1)
        val comment30 = Comment(30,8,"????",1,1)
        val comment31 = Comment(31,8,"????",1,1)
        val comment32 = Comment(32,8,"????",1,1)
        val comment33 = Comment(33,8,"????",1,1)
        val comment34 = Comment(34,8,"????",1,1)


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
        commentList.add(comment29)
        commentList.add(comment30)
        commentList.add(comment31)
        commentList.add(comment32)
        commentList.add(comment33)
        commentList.add(comment34)

        viewModel.savedComments(commentList)



    }
}