package com.test.alpha_App

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class HomeActivity : AppCompatActivity() {

    var backPressedTime: Long = 0
    private lateinit var calculator: ImageButton
    private lateinit var temperature: ImageButton
    private lateinit var scale: ImageButton
    private lateinit var buttonMe: Button
    private lateinit var backToast: Toast
    private lateinit var adView1: AdView

    private fun initComponents() {
        calculator = findViewById(R.id.calculator)
        temperature = findViewById(R.id.temperature)
        scale = findViewById(R.id.scale)
        buttonMe = findViewById(R.id.buttonMe)
        adView1 = findViewById(R.id.adView1)
    }

//    handle device reqruitment by logic, RECOMMENDED
//    private fun checkGyroFunction() {
//        if (packageManager.hasSystemFeature(PackageManager.FEATURE_SENSOR_GYROSCOPE)) {
//            Log.d("Fingerprint Feature", "Fingerprint ON")
//        } else {
//            Log.d("Fingerprint Feature", "Fingerprint OFF")
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initComponents()

        MobileAds.initialize(this) {}

        val adRequest = AdRequest.Builder().build()
        adView1.loadAd(adRequest)

        temperature.setOnClickListener {
            Toast.makeText(this, "Temperature Conversion", Toast.LENGTH_SHORT)
                .show()
            val temp = Intent(this, TemperatureActivity::class.java)
            startActivity(temp)
        }

        calculator.setOnClickListener {
            Toast.makeText(this, "Calculator", Toast.LENGTH_SHORT)
                .show()
            val calc = Intent(this, CalculatorActivity::class.java)
            startActivity(calc)
        }

        scale.setOnClickListener {
            Toast.makeText(this, "Scale", Toast.LENGTH_SHORT)
                .show()
            val sca = Intent(this, ScaleActivity::class.java)
            startActivity(sca)
        }

        buttonMe.setOnClickListener {
            Toast.makeText(this, "About Me", Toast.LENGTH_SHORT)
                .show()
            val me = Intent(this, AboutActivity::class.java)
            startActivity(me)

//            checkGyroFunction()
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel()
            onBackPressedDispatcher.onBackPressed()
            return
        } else {
            backToast = Toast.makeText(baseContext, "Press again to exit", Toast.LENGTH_SHORT)
            backToast.show()
        }
        backPressedTime = System.currentTimeMillis()
    }
}