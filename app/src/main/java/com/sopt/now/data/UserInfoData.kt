package com.sopt.now.data

import android.widget.Button
import androidx.annotation.DrawableRes

sealed class UserInfoData {
    data class MyInfo(
        @DrawableRes val profileImage: Int,
        val name: String,
        val selfDescription: String,
        val type: String,
    ) : UserInfoData()

    data class BrithDayFriendInfo(
        @DrawableRes val profileImage: Int,
        val name: String,
        val selfDescription: String,
        val birthdayMark: Boolean,
        val giftButton: Boolean,
        val type: String,
    )   : UserInfoData()

    data class FriendInfo(
        @DrawableRes val profileImage: Int,
        val name: String,
        val selfDescription: String,
        val type: String,
    )   : UserInfoData()


}
