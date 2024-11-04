package com.test.alpha_App

import android.content.Intent
import android.net.LinkAddress
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.coroutines.handleCoroutineException
import java.net.URL

class AboutActivity : AppCompatActivity() {

    private lateinit var adView2: AdView
    private lateinit var imgBtnfb: ImageButton
    private lateinit var imgBtnig: ImageButton

    private fun initComponents() {
        adView2 = findViewById(R.id.adView2)
        imgBtnfb = findViewById(R.id.imgBtnfb)
        imgBtnig = findViewById(R.id.imgBtnig)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        initComponents()

        MobileAds.initialize(this) {}

        val adRequest = AdRequest.Builder().build()
        adView2.loadAd(adRequest)

        imgBtnfb.setOnClickListener {
            Toast.makeText(this, "facebook", Toast.LENGTH_SHORT)
                .show()
            Log.e("button", "succes")
            fun openWeb(url: String) {
                val webPage : Uri = Uri.parse(url)
                val intent = Intent(Intent.ACTION_VIEW, webPage)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
            }
        }

        imgBtnig.setOnClickListener {
            Toast.makeText(this, "instagram", Toast.LENGTH_SHORT)
                .show()
            fun openWeb(url: String) {
                val webPage : Uri = Uri.parse(url)
                val intent = Intent(Intent.ACTION_VIEW, webPage)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
            }
        }

    }
}