package com.sopt.now.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FriendAuthService {
    @GET("api/users")
    fun getUsers(
        @Query("page") page: Int
    ): Call<FriendResponseDto>
}