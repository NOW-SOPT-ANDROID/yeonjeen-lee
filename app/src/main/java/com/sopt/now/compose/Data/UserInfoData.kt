package com.sopt.now.compose.Data

sealed class UserInfoData {
    data class MyInfo(
        val profileImage: Int,
        val name: String,
        val selfDescription: String,
    ) : UserInfoData()

    data class FriendInfo(
        val profileImage: Int,
        val name: String,
        val selfDescription: String,
    ) : UserInfoData()
}
