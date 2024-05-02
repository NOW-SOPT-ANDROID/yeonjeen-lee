package com.sopt.now.compose.Login

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.now.compose.Main.MainActivity
import com.sopt.now.compose.SignUp.SignUpActivity


@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    signUpId: String,
    signUpPassword: String,
    signUpNickname: String,
    signUpAddress: String
) {
    val id = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val context = LocalContext.current

    val handleLoginButtonClick: () -> Unit = {
        val isLoginSuccess =
            viewModel.checkLoginCredentials(id.value, password.value, signUpId, signUpPassword)
        if (isLoginSuccess) {
            Toast.makeText(context, "로그인에 성공하셨습니다", Toast.LENGTH_SHORT).show()
            moveToMainActivity(context, signUpId, signUpPassword, signUpNickname, signUpAddress)
        } else {
            Toast.makeText(context, "로그인이 불가능합니다", Toast.LENGTH_SHORT).show()
        }
    }
    Column(
        modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        LoginTitle()
        Spacer(modifier = Modifier.height(40.dp))
        Login(id, password)
        Spacer(modifier = Modifier.height(50.dp))
        LoginButton(handleLoginButtonClick)
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
fun Login(
    id: MutableState<String>,
    password: MutableState<String>
) {
    Column(
        modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        LoginField("ID", id)
        LoginField("비밀번호", password)
    }
}

@Composable
fun LoginField(
    label: String,
    value: MutableState<String>
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = label,
            modifier = Modifier.padding(start = 8.dp),
            fontWeight = FontWeight.Bold,
        )
        OutlinedTextField(
            value = value.value,
            onValueChange = { value.value = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("입력하세요") }
        )
    }
}

@Composable
fun LoginButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text("로그인하기", color = Color.White)
    }
}

fun moveToMainActivity(
    context: Context,
    signUpId: String,
    signUpPassword: String,
    signUpNickname: String,
    signUpAddress: String
) {
    val intent = Intent(context, MainActivity::class.java).apply {
        putExtra("ID", signUpId)
        putExtra("PASSWORD", signUpPassword)
        putExtra("NICKNAME", signUpNickname)
        putExtra("ADDRESS", signUpAddress)
    }
    context.startActivity(intent)
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