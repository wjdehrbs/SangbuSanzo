package com.example.sangbusanzo

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailPageActivity : AppCompatActivity() {
    private lateinit var textname: TextView
    private lateinit var textmbti: TextView
    private lateinit var textshortWord: TextView
    private lateinit var image: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailpage)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){

          val member =  intent?.getSerializableExtra("data", TeamMember::class.java)
            val isvald = intent?.getBooleanExtra("isvalid",false )

            if (isvald == true){
                val btn = findViewById<Button>(R.id.button1)
                btn.visibility = View.VISIBLE

                btn.setOnClickListener {
                    val intent = Intent(this, mypageActivity::class.java)
                    startActivity(intent)
                }
            }
            else if(isvald == false){
                val btn = findViewById<Button>(R.id.button1)
                btn.visibility = View.GONE
            }

            textname = findViewById(R.id.name)
            textmbti = findViewById(R.id.mbti)
            textshortWord = findViewById(R.id.textshortWord)
            image = findViewById(R.id.image1)

            textname.text = member.name
            textmbti.text = member.mbti
            textshortWord.text = member.shortWord
            image.setImageResource(member.titleImage)

        }else{
            intent?.getSerializableExtra("data") as TeamMember
        }
    }
}