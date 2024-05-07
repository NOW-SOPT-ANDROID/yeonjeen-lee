package com.sopt.now.compose.Data.Service

import com.sopt.now.compose.Data.Request.LoginRequestDto
import com.sopt.now.compose.Data.Request.SignUpRequestDto
import com.sopt.now.compose.Data.Response.LoginResponseDto
import com.sopt.now.compose.Data.Response.SignUpResponseDto
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("member/join")
    suspend fun signUp(
        @Body request: SignUpRequestDto,
    ): Response<SignUpResponseDto>

    @POST("member/login")
    suspend fun signIn(
        @Body request: LoginRequestDto,
    ): Response<LoginResponseDto>
}