package com.sopt.now.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.now.compose.ui.theme.NOWSOPTAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val signUpId = intent.getStringExtra("ID").orEmpty()
        val signUpPassword = intent.getStringExtra("PASSWORD").orEmpty()
        val signUpNickname = intent.getStringExtra("NICKNAME").orEmpty()
        val signUpAddress = intent.getStringExtra("ADDRESS").orEmpty()
        setContent {
            NOWSOPTAndroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainProfileScreen(signUpId, signUpPassword, signUpNickname, signUpAddress)
                }
            }
        }
    }
}

@Composable
fun MainProfileScreen(
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
            Spacer(modifier = Modifier.height(52.dp))
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
        Spacer(modifier = Modifier.height(240.dp))
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




@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    NOWSOPTAndroidTheme {
    }
}



