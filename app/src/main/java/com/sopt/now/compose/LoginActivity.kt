package com.sopt.now.compose

import android.content.Context
import android.content.Intent
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.now.compose.ui.theme.NOWSOPTAndroidTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NOWSOPTAndroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginContent()
                }
            }
        }
    }
}

@Composable
fun LoginContent() {
    Column(
        modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        LoginTitle()
        Spacer(modifier = Modifier.height(40.dp))
        Login()
        Spacer(modifier = Modifier.height(50.dp))
        LoginButton()
        GoToSignUp()
    }

}

@Composable
fun LoginTitle() {
    Text(
        text = "Welcome to SOPT",
        modifier = Modifier.padding(10.dp),
        color = Color.Blue,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}

@Composable
fun Login() {
    Column(
        modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        LoginId()
        LoginPs()
    }
}

@Composable
fun LoginId() {
    Column(
        modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "ID",
            modifier = Modifier.padding(10.dp),
            fontWeight = FontWeight.Bold,
        )
        LoginIdEdit()
    }
}

@Composable
fun LoginIdEdit() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        label = { Text("아이디를 입력하세요") },
        placeholder = { Text("") },
        leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "User Icon") },
        singleLine = true,
    )
}

@Composable
fun LoginPs() {
    Column(
        modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "비밀번호",
            modifier = Modifier.padding(10.dp),
            fontWeight = FontWeight.Bold,
        )
        LoginPsEdit()
    }
}

@Composable
fun LoginPsEdit() {
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
fun LoginButton() {
    Button(
        onClick = { /* 클릭 시 수행될 동작 */ },
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text("로그인하기", color = Color.White)
    }
}

@Composable
fun GoToSignUp() {
    val context = LocalContext.current
    Button(
        onClick = { navigateToSignUp(context) },
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text("회원가입하기", color = Color.White)
    }
}

private fun navigateToSignUp(context: Context) {
    val intent = Intent(context, SignUpActivity::class.java)
    context.startActivity(intent)
}

@Preview(showBackground = true)
@Composable
fun LoginContentPreview() {
    NOWSOPTAndroidTheme {
        LoginContent()
    }
}

