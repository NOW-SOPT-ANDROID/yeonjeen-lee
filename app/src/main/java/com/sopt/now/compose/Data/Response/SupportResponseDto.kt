package com.sopt.now.compose.Data.Response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SupportResponseDto(
    @SerialName("url")
    val url: String,
    @SerialName("text")
    val text: String,
)
