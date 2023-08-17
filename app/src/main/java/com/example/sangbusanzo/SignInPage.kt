package com.example.sangbusanzo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SignInPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_page)
        supportActionBar?.hide()

    }
}