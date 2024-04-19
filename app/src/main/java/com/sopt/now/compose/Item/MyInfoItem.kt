package com.sopt.now.compose.Item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sopt.now.compose.Data.UserInfoData

@Composable
fun MyInfoItem(myInfoList: UserInfoData.MyInfo) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(20.dp)
            .height(80.dp)
    ) {
        val painter: Painter = painterResource(id = myInfoList.profileImage)
        Image(
            painter = painter,
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(80.dp)
                .padding(end = 16.dp)
                .clip(shape = CircleShape)
        )
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = myInfoList.name,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = myInfoList.selfDescription,
                color = Color.Gray
            )
        }
    }
}