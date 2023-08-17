package com.example.sangbusanzo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import com.example.sangbusanzo.model.TeamMember

class MainPage : AppCompatActivity() {
    private val loginButton by lazy { findViewById<Button>(R.id.login_button) }
    private val setting by lazy { findViewById<ImageView>(R.id.setting) }
    private val scrollView by lazy { findViewById<ScrollView>(R.id.scrollview_friends) }
    private val notificationCloseButton by lazy { findViewById<ImageButton>(R.id.close_button) }
    private val notification by lazy { findViewById<CardView>(R.id.main_notification) }
    private val notificationTextView by lazy { notification.findViewById<TextView>(R.id.notification_text) }
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
    private val cardViewFirstShortTextView by lazy {
        cardViewFirst.findViewById<TextView>(R.id.friend_profile_short_text)
    }
    private val cardViewSecondImageView by lazy {
        cardViewSecond.findViewById<ImageView>(R.id.friend_profile_imageview)
    }
    private val cardViewSecondTextView by lazy {
        cardViewSecond.findViewById<TextView>(R.id.friend_profile_textview)
    }
    private val cardViewSecondShortTextView by lazy {
        cardViewSecond.findViewById<TextView>(R.id.friend_profile_short_text)
    }
    private val cardViewThirdImageView by lazy {
        cardViewThird.findViewById<ImageView>(R.id.friend_profile_imageview)
    }
    private val cardViewThirdTextView by lazy {
        cardViewThird.findViewById<TextView>(R.id.friend_profile_textview)
    }
    private val cardViewThirdShortTextView by lazy {
        cardViewThird.findViewById<TextView>(R.id.friend_profile_short_text)
    }
    private val cardViewFourthImageView by lazy {
        cardViewFourth.findViewById<ImageView>(R.id.friend_profile_imageview)
    }
    private val cardViewFourthTextView by lazy {
        cardViewFourth.findViewById<TextView>(R.id.friend_profile_textview)
    }
    private val cardViewFourthShortTextView by lazy {
        cardViewFourth.findViewById<TextView>(R.id.friend_profile_short_text)
    }
    private val notLoggedInTextView by lazy { findViewById<TextView>(R.id.not_logged_in) }
    private var isLoggedIn = false
    private lateinit var name: String
    private val list by lazy {
        listOf(
            TeamMember("정도균", R.drawable.icon_apeach, "INFP", "안녕하세요1"),
            TeamMember("김민종", R.drawable.icon_con, "ISTJ", "안녕하세요2"),
            TeamMember("박준수", R.drawable.icon_lion, "INFP", "안녕하세요3"),
            TeamMember("정선호", R.drawable.icon_muji, "ISFP", "안녕하세요4"),
            TeamMember("임재민", R.drawable.icon_tube, "ENTP", "안녕하세요5")
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        isLoggedIn = intent?.getBooleanExtra("isLoggedIn", false) ?: false
        initViews()
        initCardViews()
        initButton()
        getLoginInfo()
    }

    private fun initCardViews() {
        cardViewFirst.setOnClickListener {
            Toast.makeText(this@MainPage, "1", Toast.LENGTH_SHORT).show()
//            startDetailPage(DetailPage::class.java, list[0])
//            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }
        cardViewSecond.setOnClickListener {
            Toast.makeText(this@MainPage, "2", Toast.LENGTH_SHORT).show()
//            startDetailPage(DetailPage::class.java, list[1])
//            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }
        cardViewThird.setOnClickListener {
            Toast.makeText(this@MainPage, "3", Toast.LENGTH_SHORT).show()
//            startDetailPage(DetailPage::class.java, list[2])
//            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }
        cardViewFourth.setOnClickListener {
            Toast.makeText(this@MainPage, "4", Toast.LENGTH_SHORT).show()
//            startDetailPage(DetailPage::class.java, list[3])
//            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }
    }

    private fun <T> startDetailPage(activity: Class<T>, data: TeamMember) {
        startActivity(Intent(this@MainPage, activity).apply {
            // TODO 팀원 정보 리스트를 만들어서 해당인원 정보 넘기기
            putExtra("data", data)
        })
    }

    private fun initViews() {
        notificationTextView.isSelected = true // 흐르는 효과
        when (isLoggedIn) {
            true -> {
                name = intent?.getStringExtra("name") ?: "정도균"
                val filteredList = list.filter { it.name != name }
                scrollView.isVisible = true
                notLoggedInTextView.isVisible = false
//                loginButton.isVisible = false
//                setting.isVisible = true
                cardViewMainTextView.text = name
                cardViewMainImageView.apply {
                    setImageResource(list.filter { it.name == name }[0].titleImage)
                    clipToOutline = true
                }
                cardViewFirstTextView.text = filteredList[0].name
                cardViewFirstImageView.apply {
                    setImageResource(filteredList[0].titleImage)
                    clipToOutline = true
                }
                cardViewFirstShortTextView.text = filteredList[0].shortWord

                cardViewSecondTextView.text = filteredList[1].name
                cardViewSecondImageView.apply {
                    setImageResource(filteredList[1].titleImage)
                    clipToOutline = true
                }
                cardViewSecondShortTextView.text = filteredList[1].shortWord

                cardViewThirdTextView.text = filteredList[2].name
                cardViewThirdImageView.apply {
                    setImageResource(filteredList[2].titleImage)
                    clipToOutline = true
                }
                cardViewThirdShortTextView.text = filteredList[2].shortWord

                cardViewFourthTextView.text = filteredList[3].name
                cardViewFourthImageView.apply {
                    setImageResource(filteredList[3].titleImage)
                    clipToOutline = true
                }
                cardViewFourthShortTextView.text = filteredList[3].shortWord
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
            val animation = AnimationUtils.loadAnimation(notification.context, R.anim.fade_out)
            notification.startAnimation(animation)
            Handler(Looper.getMainLooper()).postDelayed({
                notification.isVisible = false
            }, 500)
        }
        loginButton.setOnClickListener {
            // TODO 로그인 액티비티로 넘어가기
            isLoggedIn = !isLoggedIn // 테스트용
            initViews() // 테스트용
//            startActivity(Intent(this@MainActivity, LogInPage::class.java))
        }
        setting.setOnClickListener {
            println(list.first { it.name == name })
//            startDetailPage(DetailPage::class.java, list.first { it.name == name })
//            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }
    }

    private fun getLoginInfo() {

    }
}