package com.sopt.now.data.service

import com.sopt.now.data.model.response.FriendResponseDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FriendAuthService {
    @GET("api/users")
    fun getUsers(
        @Query("page") page: Int
    ): Call<FriendResponseDto>
}