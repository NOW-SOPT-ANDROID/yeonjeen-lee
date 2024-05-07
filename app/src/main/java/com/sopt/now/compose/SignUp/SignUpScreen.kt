package com.sopt.now.compose.SignUp

import android.content.Context
import android.content.Intent
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.now.compose.Data.Request.SignUpRequestDto
import com.sopt.now.compose.Login.LoginActivity

@Composable
fun SignUpScreen(viewModel: SignUpViewModel) {
    val signUpState by viewModel.signUpState.collectAsState()

    val id = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val nickname = remember { mutableStateOf("") }
    val phoneNumber = remember { mutableStateOf("") }

    val context = LocalContext.current

    val onSignUpSuccess: () -> Unit = {
        moveToLogin(context)
    }

    val requestDto = SignUpRequestDto(
        authenticationId = id.value,
        password = password.value,
        nickname = nickname.value,
        phoneNumber = phoneNumber.value
    )

    Column(
        modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        SignUpTitle()
        Spacer(modifier = Modifier.height(10.dp))
        SignUpFields(id, password, nickname, phoneNumber)
        Spacer(modifier = Modifier.height(20.dp))
        SignUpButton(
            viewModel = viewModel,
            requestDto = requestDto,
            signUpState = signUpState,
            onSignUpSuccess = onSignUpSuccess
        )
        val messageColor = if (signUpState.isSuccess) Color.Green else Color.Red
        Text(
            text = signUpState.message,
            color = messageColor,
            modifier = Modifier.padding(top = 16.dp)
        )
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
fun SignUpFields(
    id: MutableState<String>,
    password: MutableState<String>,
    nickname: MutableState<String>,
    phoneNumber: MutableState<String>
) {
    Column(
        modifier = Modifier.padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        SignUpField(label = "ID", value = id)
        SignUpField(label = "비밀번호", value = password, isPassword = true)
        SignUpField(label = "닉네임", value = nickname)
        SignUpField(label = "전화번호", value = phoneNumber)
    }
}

@Composable
fun SignUpField(label: String, value: MutableState<String>, isPassword: Boolean = false) {
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
            label = { Text("입력하세요") },
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None
        )
    }
}

@Composable
fun SignUpButton(
    viewModel: SignUpViewModel,
    requestDto: SignUpRequestDto,
    signUpState: SignUpState,
    onSignUpSuccess: () -> Unit
) {
    Button(
        onClick = {
            viewModel.signUp(
                requestDto.authenticationId,
                requestDto.password,
                requestDto.nickname,
                requestDto.phoneNumber
            )
        },
        modifier = Modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
        shape = RoundedCornerShape(8.dp)
    ) {
        if (signUpState.isSuccess) {
            Text("회원가입 성공!", color = Color.White)
        } else {
            Text("회원가입", color = Color.White)
        }
    }

    LaunchedEffect(signUpState.isSuccess) {
        if (signUpState.isSuccess) {
            onSignUpSuccess()
        }
    }
}

fun moveToLogin(context: Context) {
    val intent = Intent(context, LoginActivity::class.java)
    context.startActivity(intent)
}
