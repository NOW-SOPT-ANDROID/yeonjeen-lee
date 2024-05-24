package com.sopt.now.compose.Data

sealed class SignUpResult {
    data class Success(val message: String) : SignUpResult()
    data class Error(val message: String) : SignUpResult()
}