package com.jikisan.fogdistrictcatalog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.jikisan.fogdistrictcatalog.View.HomePage

class SplashScreen : AppCompatActivity() {

    private val SPLASH_DELAY: Long = 2000 // 5 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Delay for 5 seconds and then start the home screen activity
        Handler().postDelayed({
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
            finish() // Prevent returning to splash screen when back button is pressed
        }, SPLASH_DELAY)

    }
}