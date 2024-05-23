package com.sopt.now.compose.Data.Request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginRequestDto (
    @SerialName("authenticationId")
    val authenticationId: String,
    @SerialName("password")
    val password: String,
)