package com.example.sangbusanzo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.sangbusanzo.R
import java.util.regex.Pattern

class SignInPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signinpage)

            val btn_add = findViewById<Button>(R.id.btn_signup)
            btn_add.setOnClickListener {
                val textname = findViewById<EditText>(R.id.edit_name)
                val text_Id = findViewById<EditText>(R.id.edittextId)
                val text_Pass = findViewById<EditText>(R.id.editTextPw)
                val username = textname.text.toString()
                val userId = text_Id.text.toString()
                val password = text_Pass.text.toString()

                var hasError = false

                if (username.length > 4) {
                    textname.error = "이름은 4자 이내로 입력해주세요."
                    hasError = true
                }

                if (userId.length > 20) {
                    text_Id.error = "아이디는 20자 이내로 입력해주세요."
                    hasError = true
                }

                if (password.length < 8 || password.length > 16) {
                    text_Pass.error = "비밀번호는 영문, 숫자, 특수문자를 조합하여 8자에서 16자 사이로 입력해주세요."
                    hasError = true
                } else if (!isValidPassword(password)) {
                    text_Pass.error = "비밀번호는 영어, 숫자, 특수문자만 사용하여 입력해주세요."
                    hasError = true
                }

                if (!hasError) {
                    Toast.makeText(this, "회원가입 성공!!", Toast.LENGTH_SHORT).show()

                    val resultIntent = Intent()
                    resultIntent.putExtra("dataFromSignUpActivity", userId)
                    resultIntent.putExtra("passwordFromSignUpActivity", password)
                    setResult(RESULT_OK, resultIntent)
                    finish()
                }
            }
    }
        private fun isValidPassword(password: String): Boolean {
            val pattern = Pattern.compile("^[a-zA-Z0-9!@#\$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]*$")
            return pattern.matcher(password).matches()
        }
}