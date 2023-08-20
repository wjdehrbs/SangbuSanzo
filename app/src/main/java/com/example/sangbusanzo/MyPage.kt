package com.example.sangbusanzo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MyPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)

        val receivedImage1 = intent?.getIntExtra("image",0)
        val receivedImage2 = intent?.getIntExtra("image2",0)
        val receivedtext1 = intent?.getStringExtra("textname")
        val receivedtext2 = intent?.getStringExtra("textmbti")
        val receivedtext3 = intent?.getStringExtra("textshortWord")
        val receivedtext4 = intent?.getStringExtra("view_text1")
        val receivedtext5 = intent?.getStringExtra("view_text2")


        val image1 = findViewById<ImageView>(R.id.mypage_image1)
        val image2 = findViewById<ImageView>(R.id.mypage_image2)
        val text1 = findViewById<TextView>(R.id.mypage_text1)
        val text2 = findViewById<TextView>(R.id.mypage_text2)
        val text3 = findViewById<TextView>(R.id.mypage_text3)
        val text4 = findViewById<EditText>(R.id.mypage_text4)
        val text5 = findViewById<EditText>(R.id.mypage_text5)

        if(receivedImage1 != null && receivedImage1 != 0){
            image1.setImageResource(receivedImage1)
        }
        if(receivedImage2 != null && receivedImage2 != 0){
            image2.setImageResource(receivedImage2)
        }

        text1.text = receivedtext1
        text2.text = receivedtext2
        text3.text = receivedtext3
        text4.setText(receivedtext4)
        text5.setText(receivedtext5)


        val mypagebt1 = findViewById<Button>(R.id.mypageButton)

        mypagebt1.setOnClickListener{

            val intent = Intent(this,DetailPage::class.java)
            intent.putExtra("mypagetext1",text1.text.toString())
            intent.putExtra("mypagetext2",text2.text.toString())
            intent.putExtra("mypagetext3",text3.text.toString())
            intent.putExtra("mypagetext4",text4.text.toString())
            intent.putExtra("mypagetext5",text5.text.toString())
            intent.putExtra("mypageimage1",R.drawable.icon_apeach)
            intent.putExtra("mypageimage2",R.drawable.num1)
            startActivity(intent)
        }





    }

}