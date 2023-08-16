package com.example.sangbusanzo

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.view.children
import androidx.core.view.get
import androidx.core.view.isVisible
import com.example.sangbusanzo.model.TeamMember

class MainPage : AppCompatActivity() {
    private val loginButton by lazy { findViewById<Button>(R.id.login_button) }
    private val setting by lazy { findViewById<ImageView>(R.id.setting) }
    private val scrollView by lazy { findViewById<ScrollView>(R.id.scrollview_friends) }
    private val notificationCloseButton by lazy { findViewById<ImageButton>(R.id.close_button) }
    private val notification by lazy { findViewById<CardView>(R.id.main_notification) }
    private val cardViewMain by lazy { findViewById<CardView>(R.id.main_profile) }
    private val cardViewFirst by lazy { findViewById<CardView>(R.id.main_friend_1) }
    private val cardViewSecond by lazy { findViewById<CardView>(R.id.main_friend_2) }
    private val cardViewThird by lazy { findViewById<CardView>(R.id.main_friend_3) }
    private val cardViewFourth by lazy { findViewById<CardView>(R.id.main_friend_4) }
    private val cardViewMainImageView by lazy {
        cardViewMain.findViewById<ImageView>(R.id.main_profile_imageview)
    }
    private val cardViewMainTextView by lazy {
        cardViewMain.findViewById<TextView>(R.id.main_profile_textview)
    }
    private val cardViewFirstImageView by lazy {
        cardViewFirst.findViewById<ImageView>(R.id.friend_profile_imageview)
    }
    private val cardViewFirstTextView by lazy {
        cardViewFirst.findViewById<TextView>(R.id.friend_profile_textview)
    }
    private val cardViewSecondImageView by lazy {
        cardViewSecond.findViewById<ImageView>(R.id.friend_profile_imageview)
    }
    private val cardViewSecondTextView by lazy {
        cardViewSecond.findViewById<TextView>(R.id.friend_profile_textview)
    }
    private val cardViewThirdImageView by lazy {
        cardViewThird.findViewById<ImageView>(R.id.friend_profile_imageview)
    }
    private val cardViewThirdTextView by lazy {
        cardViewThird.findViewById<TextView>(R.id.friend_profile_textview)
    }
    private val cardViewFourthImageView by lazy {
        cardViewFourth.findViewById<ImageView>(R.id.friend_profile_imageview)
    }
    private val cardViewFourthTextView by lazy {
        cardViewFourth.findViewById<TextView>(R.id.friend_profile_textview)
    }





    private val notLoggedInTextView by lazy { findViewById<TextView>(R.id.not_logged_in) }
    private var isLoggedIn = false
    private val list by lazy {
        listOf(
            TeamMember("정도균", R.mipmap.ic_launcher_round, "INFP", "안녕하세요"),
            TeamMember("김민종", R.mipmap.ic_launcher_round, "ISTJ", "안녕하세요"),
            TeamMember("박준수", R.mipmap.ic_launcher_round, "INFP", "안녕하세요"),
            TeamMember("정선호", R.mipmap.ic_launcher_round, "ISFP", "안녕하세요"),
            TeamMember("임재민", R.mipmap.ic_launcher_round, "ENTP", "안녕하세요")
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        isLoggedIn = intent?.getBooleanExtra("isLoggedIn",false) ?: false
        initViews()
        initCardViews()
        initButton()
        getLoginInfo()
    }
    private fun initCardViews() {
        cardViewFirst.setOnClickListener {
            Toast.makeText(this@MainPage, "1",Toast.LENGTH_SHORT).show()
//            startDetailPage(DetailPage::class.java, list[0])
        }
        cardViewSecond.setOnClickListener {
            Toast.makeText(this@MainPage, "2",Toast.LENGTH_SHORT).show()
//            startDetailPage(DetailPage::class.java, list[1])
        }
        cardViewThird.setOnClickListener {
            Toast.makeText(this@MainPage, "3",Toast.LENGTH_SHORT).show()
//            startDetailPage(DetailPage::class.java, list[2])
        }
        cardViewFourth.setOnClickListener {
            Toast.makeText(this@MainPage, "4",Toast.LENGTH_SHORT).show()
//            startDetailPage(DetailPage::class.java, list[3])
        }
    }
    private fun startDetailPage(activity: AppCompatActivity, data: TeamMember ) {
        startActivity(Intent(this@MainPage, activity::class.java).apply {
            // TODO 팀원 정보 리스트를 만들어서 해당인원 정보 넘기기
            putExtra("data", data)
        })
    }

    private fun initViews() {
        when(isLoggedIn) {
            true -> {
                scrollView.isVisible = true
                notLoggedInTextView.isVisible = false
//                loginButton.isVisible = false
//                setting.isVisible = true
                val name = intent?.getStringExtra("name") ?: "정도균"
                val filteredList = list.filter{ it.name != name }
                cardViewMainTextView.text = name
                cardViewMainImageView.setImageResource(list.filter{it.name == name}[0].titleImage)
                cardViewFirstTextView.text = filteredList[0].name
                cardViewFirstImageView.setImageResource(filteredList[0].titleImage)
                cardViewSecondTextView.text = filteredList[1].name
                cardViewSecondImageView.setImageResource(filteredList[1].titleImage)
                cardViewThirdTextView.text = filteredList[2].name
                cardViewThirdImageView.setImageResource(filteredList[2].titleImage)
                cardViewFourthTextView.text = filteredList[3].name
                cardViewFourthImageView.setImageResource(filteredList[3].titleImage)
            }
            false -> {
                scrollView.isVisible = false
                notLoggedInTextView.isVisible = true
//                loginButton.isVisible = true
//                setting.isVisible = false
            }
        }
    }

    private fun initButton() {
        notificationCloseButton.setOnClickListener {
            notification.isVisible = false
        }
        loginButton.setOnClickListener {
            // TODO 로그인 액티비티로 넘어가기
            isLoggedIn = !isLoggedIn // 테스트용
            initViews() // 테스트용
//            startActivity(Intent(this@MainActivity, LogInPage::class.java))
        }
    }

    private fun getLoginInfo() {

    }
}