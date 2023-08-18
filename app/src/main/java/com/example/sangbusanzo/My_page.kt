package com.example.week5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class My_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)
        val intent = intent
        val input_detail_text1 = intent.getStringExtra("detail_text1")
        val input_detail_text2 = intent.getStringExtra("detail_text2")

        val detail_text1 : EditText = findViewById(R.id.detail_text1)
        detail_text1.setText(input_detail_text1)
        val detail_text2 : EditText = findViewById(R.id.detail_text2)
        detail_text2.setText(input_detail_text2)
    }
}