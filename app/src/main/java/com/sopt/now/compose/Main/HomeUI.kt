package com.sopt.now.compose.Main

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.sopt.now.compose.Data.UserInfoData
import com.sopt.now.compose.Item.FriendItem
import com.sopt.now.compose.Item.MyInfoItem
import com.sopt.now.compose.R

@Composable
fun HomeUi() {
    LazyColumn {
        item {
            MyInfoItem(myInfoList)
        }
        items(friendList) { friendInfo ->
            FriendItem(friendInfo)
        }
    }
}

val myInfoList = (
    UserInfoData.MyInfo(
        profileImage = R.drawable.img_yeonjeen,
        name = "이연진",
        selfDescription = "나는야 미래의 짱짱개발자"
    )
)

val friendList = listOf(
    UserInfoData.FriendInfo(
        profileImage = R.drawable.img_junseo,
        name = "최준서",
        selfDescription = "검은피 뽑아줄게"
    ),
    UserInfoData.FriendInfo(
        profileImage = R.drawable.img_arin,
        name = "김아린",
        selfDescription = "나는야 우주최강 귀요미"
    ),
    UserInfoData.FriendInfo(
        profileImage = R.drawable.img_minjae,
        name = "손민재",
        selfDescription = "안드 재능러"
    ),
    UserInfoData.FriendInfo(
        profileImage = R.drawable.img_euijin,
        name = "곽의진",
        selfDescription = "내가 34기 안팟장이다"
    ),
    UserInfoData.FriendInfo(
        profileImage = R.drawable.img_yeonjeen2,
        name = "이연진",
        selfDescription = "이때로 돌아가리라"
    ),
    UserInfoData.FriendInfo(
        profileImage = R.drawable.img_junseo2,
        name = "최준서",
        selfDescription = "지칠 줄 모르는 열정맨"
    ),
    UserInfoData.FriendInfo(
        profileImage = R.drawable.img_arin2,
        name = "김아린",
        selfDescription = "컴포즈가 제일 쉬웠어요"
    ),
    UserInfoData.FriendInfo(
        profileImage = R.drawable.img_minjae2,
        name = "손민재",
        selfDescription = "열정 열정 열정"
    ),
    UserInfoData.FriendInfo(
        profileImage = R.drawable.img_euijin2,
        name = "곽의진",
        selfDescription = "의피티 업데이트 중"
    ),
)
