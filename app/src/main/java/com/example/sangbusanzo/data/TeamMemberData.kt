package com.example.sangbusanzo.data

import com.example.sangbusanzo.R
import com.example.sangbusanzo.model.TeamMember

object TeamMemberData {
    private val list  =
        listOf(
            TeamMember("정도균", R.drawable.icon_apeach, "INFP", "언제든 편하게 아무거나 사소한 개인적인 것도 질문하시고 말씀 걸어주셔도 됩니다! 저도 질문 많이 할게요!"),
            TeamMember("김민종", R.drawable.icon_con, "ISTJ", "3주 열심히 같이 해봅시다! "),
            TeamMember("박준수", R.drawable.icon_lion, "INFP", "열심히 하겠습니다!"),
            TeamMember("정선호", R.drawable.icon_muji, "ISFP", "행복하지마요~ 행복하려면~"),
            TeamMember("임재민", R.drawable.icon_tube, "ENTP", "잘 놀다 가겠습니다")
        )

    fun getFilteredMemberByName(name: String): TeamMember = list.first { it.name == name }

    fun getMemberListByName(name: String): List<TeamMember> = list.filter { it.name != name  }
}