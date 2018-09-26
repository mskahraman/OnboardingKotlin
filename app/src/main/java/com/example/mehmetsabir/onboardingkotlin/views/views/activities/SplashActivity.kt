package com.example.mehmetsabir.onboardingkotlin.views.views.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.mehmetsabir.onboardingkotlin.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val thread = object : Thread() {

            override fun run() {

                try {

                    sleep(1000)
                    val intent = Intent(this@SplashActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()

                } catch (e: Exception) {

                    e.printStackTrace()
                }
            }
        }

        thread.start()

    }
}
