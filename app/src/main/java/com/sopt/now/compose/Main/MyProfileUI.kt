package com.sopt.now.compose.Main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.now.compose.R

@Composable
fun MyProfileUi(
    signUpId: String,
    signUpPassword: String,
    signUpNickname: String,
    signUpAddress: String
) {
    Row(
        modifier = Modifier.padding(16.dp)
    ) {

        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(shape = RoundedCornerShape(16.dp))
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_yeonjeen),
                contentDescription = "Profile Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Column(
            modifier = Modifier.padding(start = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "이연진",
                style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(48.dp))
            Text(
                text = "안녕 나는 연진이야",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

    Column(
        modifier = Modifier.padding(start = 20.dp)
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "ID: $signUpId",
            style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Password: $signUpPassword",
            style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Nickname: $signUpNickname",
            style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Address: $signUpAddress",
            style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold)
        )
    }
}