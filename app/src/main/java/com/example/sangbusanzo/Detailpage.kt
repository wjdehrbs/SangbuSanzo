package com.example.sangbusanzo

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.example.sangbusanzo.model.TeamMember

class DetailPage : AppCompatActivity() {

    private lateinit var textname: TextView
    private lateinit var textmbti: TextView
    private lateinit var textshortWord: TextView
    private lateinit var image: ImageView
    private lateinit var backbutton: ImageButton
    private lateinit var member : TeamMember

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailpage)

        overridePendingTransition(androidx.appcompat.R.anim.abc_slide_in_bottom , androidx.appcompat.R.anim.abc_slide_out_bottom)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){

            member = intent?.getSerializableExtra("data", TeamMember::class.java)!!

        }else{
            member = intent?.getSerializableExtra("data") as TeamMember
        }

        val isvald = intent?.getBooleanExtra("isValid",false )

        if (isvald == true){
            val btn = findViewById<Button>(R.id.button1)
            btn.visibility = View.VISIBLE
            //true면 수정버튼 보이게

//            btn.setOnClickListener {
//                val intent = Intent(this, mypage::class.java)
//                startActivity(intent)
//            }

        }
        else if(isvald == false){
            val btn = findViewById<Button>(R.id.button1)
            btn.visibility = View.GONE
            //false면 수정버튼 숨기기
        }

        textname = findViewById(R.id.name)
        textmbti = findViewById(R.id.mbti)
        textshortWord = findViewById(R.id.textshortWord)
        image = findViewById(R.id.image1)
        backbutton = findViewById(R.id.backButton)

        textname.text = member?.name
        textmbti.text = member?.mbti
        textshortWord.text = member?.shortWord
        image.apply {setImageResource(member.titleImage)
            clipToOutline = true }

        backbutton.setOnClickListener {
            val intent = Intent(this , MainPage::class.java)
            finish()
            overridePendingTransition(androidx.appcompat.R.anim.abc_slide_in_bottom , androidx.appcompat.R.anim.abc_slide_out_bottom)
        }
    }

}