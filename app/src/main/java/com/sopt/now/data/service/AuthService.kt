package com.sopt.now.data.service

import com.sopt.now.data.model.request.SignUpRequestDto
import com.sopt.now.data.model.response.SignUpResponseDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("member/join")
    fun signUp(
        @Body request: SignUpRequestDto,
    ): Call<SignUpResponseDto>
}