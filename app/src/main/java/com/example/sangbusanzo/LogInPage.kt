package com.example.sangbusanzo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LogInPage : AppCompatActivity() {

    private lateinit var idEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var LogInButton: Button
    private lateinit var SignInButton: Button
    private lateinit var messageTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in_page)
        supportActionBar?.hide()

        idEditText = findViewById(R.id.idET)
        passwordEditText = findViewById(R.id.pwET)
        LogInButton = findViewById(R.id.loginbt)
        SignInButton = findViewById(R.id.SIBT)
        messageTextView = findViewById(R.id.messageTextView)

        LogInButton.setOnClickListener {

            val id = idEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (TextUtils.isEmpty(id) || TextUtils.isEmpty(password)) {
                messageTextView.visibility = View.VISIBLE
                messageTextView.text = "모든 정보를 입력해주세요."

            } else {
                messageTextView.visibility = View.GONE
                messageTextView.text = ""

                Toast.makeText(this, "xxx님 반갑습니다.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainPage(메인 페이지 명)::class.java)
                startActivity(intent)
            }
        }
        SignInButton.setOnClickListener{
            val intent = Intent(this, SignInPage(회원가입 페이지 명)::class.java)
            startActivity(intent)
        }
    }
}