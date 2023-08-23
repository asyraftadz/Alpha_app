package com.test.alpha_App

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class AboutActivity : AppCompatActivity() {

    private lateinit var adView2: AdView

    private fun initComponents() {
        adView2 = findViewById(R.id.adView2)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        initComponents()

        MobileAds.initialize(this) {}

        val adRequest = AdRequest.Builder().build()
        adView2.loadAd(adRequest)

    }
}