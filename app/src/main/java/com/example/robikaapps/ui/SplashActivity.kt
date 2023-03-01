package com.example.robikaapps.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.robikaapps.R
import java.util.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timer().schedule(object : TimerTask() {
            override fun run() {
                startActivity(Intent(applicationContext, ShowPostActivity::class.java))
            }
        }, 3000)
    }
}