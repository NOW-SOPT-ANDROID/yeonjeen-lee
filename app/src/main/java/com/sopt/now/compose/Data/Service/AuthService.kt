package com.sopt.now.compose.Data.Service

import com.sopt.now.compose.Data.Request.SignUpRequestDto
import com.sopt.now.compose.Data.Response.SignUpResponseDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("member/join")
    fun signUp(
        @Body request: SignUpRequestDto,
    ): Call<SignUpResponseDto>
}