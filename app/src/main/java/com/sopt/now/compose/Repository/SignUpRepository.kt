package com.sopt.now.compose.Repository

import com.sopt.now.compose.Data.Request.SignUpRequestDto
import com.sopt.now.compose.Data.Response.SignUpResponseDto
import com.sopt.now.compose.Data.Service.AuthService
import retrofit2.Response

class SignUpRepository(private val authService: AuthService) {

    suspend fun signUp(requestDto: SignUpRequestDto): Response<SignUpResponseDto> {
        return authService.signUp(requestDto)
    }
}

