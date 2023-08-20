package com.example.sangbusanzo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

class SignInPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signinpage)
        overridePendingTransition(androidx.appcompat.R.anim.abc_slide_in_bottom , androidx.appcompat.R.anim.abc_slide_out_bottom)

        val btnCancel = findViewById<Button>(R.id.cancel_button)
        btnCancel.setOnClickListener {
            finish() // 취소버튼을 누르면 로그인페이지로 이동
            overridePendingTransition(androidx.appcompat.R.anim.abc_slide_in_bottom , androidx.appcompat.R.anim.abc_slide_out_bottom)
        }

        val btnAdd = findViewById<Button>(R.id.btn_signup)
        btnAdd.setOnClickListener {
            val textName = findViewById<EditText>(R.id.edit_name)
            val textId = findViewById<EditText>(R.id.edit_text_Id)
            val textPass = findViewById<EditText>(R.id.edit_Text_Pw)
            val username = textName.text.toString()
            val userId = textId.text.toString()
            val password = textPass.text.toString()

            var hasError = false

            if (username.length > 4) {
                textName.error = "이름은 4자 이내로 입력해주세요."
                hasError = true
            }

            if (userId.length > 20) {
                textId.error = "아이디는 20자 이내로 입력해주세요."
                hasError = true
            }

            if (password.length < 8 || password.length > 16) {
                textPass.error = "비밀번호는 영문, 숫자, 특수문자를 조합하여 8자에서 16자 사이로 입력해주세요."
                hasError = true
            } else if (!isValidPassword(password)) {
                textPass.error = "비밀번호는 영어, 숫자, 특수문자만 사용하여 입력해주세요."
                hasError = true
            }

            if (!hasError) {
                Toast.makeText(this, "회원가입 성공!!", Toast.LENGTH_SHORT).show()

                val resultIntent = Intent()
                resultIntent.putExtra("dataFromSignUpActivity", userId)
                resultIntent.putExtra("passwordFromSignUpActivity", password)
                resultIntent.putExtra("nameFromSignUpActivity", username)
                setResult(RESULT_OK, resultIntent)
                finish()
                overridePendingTransition(androidx.appcompat.R.anim.abc_slide_in_bottom , androidx.appcompat.R.anim.abc_slide_out_bottom)
            }
        }
    }
    private fun isValidPassword(password: String): Boolean {
        val pattern = Pattern.compile("^[a-zA-Z0-9!@#\$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]*$")
        return pattern.matcher(password).matches()
    }

}