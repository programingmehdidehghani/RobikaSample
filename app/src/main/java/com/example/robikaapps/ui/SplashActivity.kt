package com.example.robikaapps.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.robikaapps.R
import com.example.robikaapps.models.Posts
import java.util.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
        var comment : kotlin.collections.List<String> = listOf(
            ""
        )

         val posts = Posts(
             1,"زندگی در شرایط سخت"
         ,"https://picsum.photos/id/0/5000/3333" ,100,comment
         )
    }
}