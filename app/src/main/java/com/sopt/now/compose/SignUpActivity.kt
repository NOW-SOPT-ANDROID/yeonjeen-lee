package com.sopt.now.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.now.compose.ui.theme.NOWSOPTAndroidTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NOWSOPTAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    getSignUp()
                }
            }
        }
    }
}

@Composable
fun getSignUp() {
    Column(
        modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        SignUpTitle()
        Spacer(modifier = Modifier.height(0.dp))
        SignUp()
        Spacer(modifier = Modifier.height(20.dp))
        SignUpButton()
        Spacer(modifier = Modifier.height(40.dp))
    }
}

@Composable
fun SignUpTitle() {
    Text(
        text = "SIGN UP",
        modifier = Modifier.padding(10.dp),
        color = Color.Black,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}

@Composable
fun SignUp() {
    Column(
        modifier = Modifier.padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        SignUpId()
        SignUpPs()
        SignUpNickName()
        SignUpAdress()
    }
}

@Composable
fun SignUpId() {
    Column(
        modifier = Modifier.padding(0.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "ID",
            modifier = Modifier.padding(10.dp),
            fontWeight = FontWeight.Bold,
        )
        SignUpIdEdit()
    }
}

@Composable
fun SignUpIdEdit() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        label = { Text("아이디를 입력하세요") },
        placeholder = { Text("Euijin Kwak") },
        leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "User Icon") },
        singleLine = true,
    )
}

@Composable
fun SignUpPs() {
    Column(
        modifier = Modifier.padding(0.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "비밀번호",
            modifier = Modifier.padding(10.dp),
            fontWeight = FontWeight.Bold,
        )
        SignUpPsEdit()
    }
}

@Composable
fun SignUpPsEdit() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        label = { Text("비밀번호를 입력하세요") },
        placeholder = { Text("Euijin Kwak") },
        leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "User Icon") },
        singleLine = true,
    )

}

@Composable
fun SignUpNickName(){
    Column(
        modifier = Modifier.padding(0.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "닉네임",
            modifier = Modifier.padding(10.dp),
            fontWeight = FontWeight.Bold,
        )
        SignUpNickNameEdit()
    }
}

@Composable
fun SignUpNickNameEdit(){
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        label = { Text("닉네임을 입력하세요") },
        placeholder = { Text("Euijin Kwak") },
        leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "User Icon") },
        singleLine = true,
    )

}

@Composable
fun SignUpAdress(){
    Column(
        modifier = Modifier.padding(0.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "주소",
            modifier = Modifier.padding(10.dp),
            fontWeight = FontWeight.Bold,
        )
        SignUpAdressEdit()
    }
}

@Composable
fun SignUpAdressEdit(){
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        label = { Text("주소를 입력하세요") },
        placeholder = { Text("Euijin Kwak") },
        leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "User Icon") },
        singleLine = true,
    )

}

@Composable
fun SignUpButton() {
    Button(
        onClick = { /* 클릭 시 수행될 동작 */ },
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text("회원가입", color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NOWSOPTAndroidTheme {
        getSignUp()
    }
}
