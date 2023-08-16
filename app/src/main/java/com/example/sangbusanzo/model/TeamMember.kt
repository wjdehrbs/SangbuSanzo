package com.example.sangbusanzo.model

import java.io.Serializable

data class TeamMember(
    val name: String,
    val titleImage: Int,
    val mbti: String,
    val shortWord: String
): Serializable
