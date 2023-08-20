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
    private lateinit var filteredList: List<TeamMember>
    private lateinit var name: String
    private val list by lazy {
        listOf(
            TeamMember("정도균", R.drawable.icon_apeach, "INFP", "언제든 편하게 아무거나 사소한 개인적인 것도 질문하시고 말씀 걸어주셔도 됩니다! 저도 질문 많이 할게요!"),
            TeamMember("김민종", R.drawable.icon_con, "ISTJ", "3주 열심히 같이 해봅시다! "),
            TeamMember("박준수", R.drawable.icon_lion, "INFP", "열심히 하겠습니다!"),
            TeamMember("정선호", R.drawable.icon_muji, "ISFP", "행복하지마요~ 행복하려면~"),
            TeamMember("임재민", R.drawable.icon_tube, "ENTP", "잘 놀다 가겠습니다")
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name = intent?.getStringExtra("nameFromSignUpActivity")?.trim() ?: ""
        initViews()
        initButton()
        overridePendingTransition(androidx.appcompat.R.anim.abc_slide_in_bottom , androidx.appcompat.R.anim.abc_slide_out_bottom)
    }

    private fun initCardViews() {
        cardViewFirst.setOnClickListener {
            startDetailPage(DetailPage::class.java, filteredList[0])
            overridePendingTransition(androidx.appcompat.R.anim.abc_slide_in_bottom, androidx.appcompat.R.anim.abc_slide_out_bottom)
        }
        cardViewSecond.setOnClickListener {
            startDetailPage(DetailPage::class.java, filteredList[1])
            overridePendingTransition(androidx.appcompat.R.anim.abc_slide_in_bottom, androidx.appcompat.R.anim.abc_slide_out_bottom)
        }
        cardViewThird.setOnClickListener {
            startDetailPage(DetailPage::class.java, filteredList[2])
            overridePendingTransition(androidx.appcompat.R.anim.abc_slide_in_bottom, androidx.appcompat.R.anim.abc_slide_out_bottom)
        }
        cardViewFourth.setOnClickListener {
            startDetailPage(DetailPage::class.java, filteredList[3])
            overridePendingTransition(androidx.appcompat.R.anim.abc_slide_in_bottom, androidx.appcompat.R.anim.abc_slide_out_bottom)
        }
    }

    private fun <T> startDetailPage(activity: Class<T>, data: TeamMember) {
        startActivity(Intent(this@MainPage, activity).apply {
            putExtra("data", data)
            if(data.name == name) {
                putExtra("isValid", true)
            } else {
                putExtra("isValid", false)
            }
        })
    }

    private fun initViews() {
        notificationTextView.isSelected = true // 흐르는 효과
        when (name.isNotEmpty()) {
            true -> {
                filteredList = list.filter { it.name != name }
                initCardViews()
                scrollView.isVisible = true
                notLoggedInTextView.isVisible = false
                loginButton.isVisible = false
                setting.isVisible = true

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
                loginButton.isVisible = true
                setting.isVisible = false
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
            startActivity(Intent(this@MainPage, LogInPage::class.java))
            overridePendingTransition(R.anim.fade_out, R.anim.fade_in)
        }
        setting.setOnClickListener {
            startDetailPage(DetailPage::class.java, list.first { it.name == name })
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }
        cardViewFirstShortTextView.setOnClickListener {
            it.isSelected = true
        }
        cardViewSecondShortTextView.setOnClickListener {
            it.isSelected = true
        }
        cardViewThirdShortTextView.setOnClickListener {
            it.isSelected = true
        }
        cardViewFourthShortTextView.setOnClickListener {
            it.isSelected = true
        }
    }
}