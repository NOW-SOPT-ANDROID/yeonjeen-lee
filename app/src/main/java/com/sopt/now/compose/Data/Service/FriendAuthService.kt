package com.sopt.now.compose.Data.Service

import com.sopt.now.compose.Data.Response.FriendResponseDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FriendAuthService {
    @GET("api/users")
    fun getUsers(
        @Query("page") page: Int
    ): Call<FriendResponseDto>
}