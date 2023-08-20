package com.example.sangbusanzo.data

import android.content.Context
import com.example.sangbusanzo.R
import com.example.sangbusanzo.model.TeamMember

class TeamMemberData(val context: Context) {
    private val list =
        listOf(
            TeamMember(
                context.getString(R.string.name1), R.drawable.icon_apeach, context.getString(
                    R.string.infp
                ), context.getString(R.string.short_word_1)
            ),
            TeamMember(
                context.getString(R.string.name2),
                R.drawable.icon_con,
                context.getString(R.string.istj),
                context.getString(R.string.short_word_2)
            ),
            TeamMember(
                context.getString(R.string.name3), R.drawable.icon_lion, context.getString(
                    R.string.infp
                ), context.getString(R.string.short_word_3)
            ),
            TeamMember(
                context.getString(R.string.name4),
                R.drawable.icon_muji,
                context.getString(R.string.isfp),
                context.getString(R.string.short_word_4)
            ),
            TeamMember(
                context.getString(R.string.name5),
                R.drawable.icon_tube,
                context.getString(R.string.entp),
                context.getString(R.string.short_word_5)
            )
        )

    fun getFilteredMemberByName(name: String): TeamMember = list.first { it.name == name }

    fun getMemberListByName(name: String): List<TeamMember> = list.filter { it.name != name }
}