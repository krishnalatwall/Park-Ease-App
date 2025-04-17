package com.example.parkease

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val splashImage = findViewById<ImageView>(R.id.splashImage)
        val images = arrayOf(
            R.drawable.sp1, R.drawable.sp2, R.drawable.sp3, R.drawable.sp4,
            R.drawable.sp5, R.drawable.sp6, R.drawable.sp7, R.drawable.sp8
        )
        var index = 0

        val handler = Handler(Looper.getMainLooper())
        val runnable = object : Runnable {
            override fun run() {
                splashImage.setImageResource(images[index])
                index++
                if (index < images.size) {
                    handler.postDelayed(this, 100) // Change image every 100ms
                } else {
                    navigateToNextScreen() // Call function after animation ends
                }
            }
        }
        handler.postDelayed(runnable, 100)
    }

    private fun navigateToNextScreen() {
        val sharedPreferences: SharedPreferences = getSharedPreferences("ParkEasePrefs", MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        val nextActivity = if (isLoggedIn) MainActivity::class.java else LoginActivity::class.java
//        val nextActivity = MainActivity::class.java
        startActivity(Intent(this, nextActivity))
        finish() // Ensures SplashActivity is closed
    }
}
