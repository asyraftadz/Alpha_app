package com.test.alpha_App

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashScreen: AppCompatActivity() {

    private var splashscreen: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        Handler(Looper.getMainLooper()).postDelayed( {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }, splashscreen)
    }
}