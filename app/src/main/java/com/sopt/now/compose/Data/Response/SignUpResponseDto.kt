package com.sopt.now.compose.Data.Response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignUpResponseDto(
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String,
)
