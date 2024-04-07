package com.sopt.now.compose

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

class SignUpActivity : ComponentActivity() {
    private val viewModel: SignUpViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NOWSOPTAndroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SignUpContent(viewModel)
                }
            }
        }
    }
}

@Composable
fun SignUpContent(viewModel: SignUpViewModel) {
    val signUpSuccess by viewModel.signUpSuccess.observeAsState(false)
    val context = LocalContext.current
    val id = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val nickname = remember { mutableStateOf("") }
    val address = remember { mutableStateOf("") }
    Column(
        modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        SignUpTitle()
        Spacer(modifier = Modifier.height(10.dp))
        SignUpFields(id, password, nickname, address)
        Spacer(modifier = Modifier.height(20.dp))
        SignUpButton(
            viewModel = viewModel,
            id.value,
            password.value,
            nickname.value,
            address.value,
            signUpSuccess,
            context
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
    address: MutableState<String>
) {
    Column(
        modifier = Modifier.padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        SignUpField("ID", id)
        SignUpField("비밀번호", password)
        SignUpField("닉네임", nickname)
        SignUpField("주소", address)
    }
}

@Composable
fun SignUpField(label: String, value: MutableState<String>) {
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
fun SignUpButton(
    viewModel: SignUpViewModel,
    id: String,
    password: String,
    nickname: String,
    address: String,
    signUpSuccess: Boolean,
    context: Context
) {
    Button(
        onClick = {
            viewModel.signUp(id, password, nickname, address)
            if (signUpSuccess) {
                Toast.makeText(context, "회원가입에 성공하셨습니다", Toast.LENGTH_SHORT).show()
                moveToLoginActivity(
                    context = context,
                    id = id,
                    password = password,
                    nickname = nickname,
                    address = address
                )
            } else {
                Toast.makeText(context, "회원가입이 불가능합니다", Toast.LENGTH_SHORT).show()
            }
        },
        modifier = Modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text("회원가입", color = Color.White)
    }
}

fun moveToLoginActivity(
    context: Context,
    id: String,
    password: String,
    nickname: String,
    address: String
) {
    val intent = Intent(context, LoginActivity::class.java).apply {
        putExtra("ID", id)
        putExtra("PASSWORD", password)
        putExtra("NICKNAME", nickname)
        putExtra("ADDRESS", address)
    }
    context.startActivity(intent)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NOWSOPTAndroidTheme {

    }
}
