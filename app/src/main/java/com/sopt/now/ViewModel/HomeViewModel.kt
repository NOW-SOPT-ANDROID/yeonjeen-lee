package com.sopt.now.ViewModel

import androidx.lifecycle.ViewModel
import com.sopt.now.R
import com.sopt.now.data.UserInfoData

class HomeViewModel : ViewModel() {
    private val mockUserList = mutableListOf<UserInfoData>()

    init {
        initializeMockUserList()
    }

    fun getMockUserList(): List<UserInfoData> {
        return mockUserList.toList()
    }

    private fun initializeMockUserList() {
        mockUserList.apply {
            add(
                UserInfoData.MyInfo(
                    profileImage = R.drawable.img_yeonjeen,
                    name = "이연진",
                    selfDescription = "짱짱개발자가 될거야",
                    type = "MyProfileViewHolder",
                ),
            )
            add(
                UserInfoData.BrithDayFriendInfo(
                    profileImage = R.drawable.img_junseo,
                    name = "최준서",
                    selfDescription = "아주 야무지게~",
                    birthdayMark = true,
                    giftButton = true,
                    type = "BirthDayFriendViewHolder",
                ),
            )
            add(
                UserInfoData.FriendInfo(
                    profileImage = R.drawable.img_arin,
                    name = "김아린",
                    selfDescription = "컴포즈가 제일 쉬웠어요",
                    type = "FriendViewHolder",
                ),
            )
            add(
                UserInfoData.FriendInfo(
                    profileImage = R.drawable.img_minjae,
                    name = "손민재",
                    selfDescription = "안드 재능러",
                    type = "FriendViewHolder",
                ),
            )
            add(
                UserInfoData.FriendInfo(
                    profileImage = R.drawable.img_euijin,
                    name = "곽의진",
                    selfDescription = "꽃보다 곽의진",
                    type = "FriendViewHolder",
                ),
            )
            add(
                UserInfoData.FriendInfo(
                    profileImage = R.drawable.img_arin2,
                    name = "김아린",
                    selfDescription = "핑퐁스터디 최고",
                    type = "FriendViewHolder",
                ),
            )
            add(
                UserInfoData.FriendInfo(
                    profileImage = R.drawable.img_minjae2,
                    name = "손민재",
                    selfDescription = "안드? 뭐 쉽던데?",
                    type = "FriendViewHolder",
                ),
            )
            add(
                UserInfoData.FriendInfo(
                    profileImage = R.drawable.img_euijin2,
                    name = "곽의진",
                    selfDescription = "나는야 안팟장",
                    type = "FriendViewHolder",
                ),
            )


        }
    }
}


