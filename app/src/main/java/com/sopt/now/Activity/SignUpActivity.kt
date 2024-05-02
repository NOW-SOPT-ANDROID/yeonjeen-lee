package com.sopt.now.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.sopt.now.ViewModel.SignUpViewModel
import com.sopt.now.data.SignUpRequestDto
import com.sopt.now.databinding.ActivitySignupBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private val viewModel by viewModels<SignUpViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        initObserver()
    }

    private fun initViews() {
        binding.btnSignUp.setOnClickListener {
            viewModel.signUp(getSignUpRequestDto())
        }
    }

    private fun initObserver() {
        viewModel.liveData.observe(this) { state ->
            Toast.makeText(
                this@SignUpActivity,
                state.message,
                Toast.LENGTH_SHORT
            ).show()

            if (state.isSuccess) {
                // 회원가입 성공 시에 로그인 페이지로 이동
                moveToLogin(
                    binding.etSignUpID.text.toString(), // 아이디
                    binding.etSignUpPassword.text.toString(), // 비밀번호
                    binding.etSignUpNickName.text.toString(), // 닉네임
                    binding.etSignUpPhone.text.toString() // 전화번호
                )
            }
        }
    }

    private fun getSignUpRequestDto(): SignUpRequestDto {
        val id = binding.etSignUpID.text.toString()
        val password = binding.etSignUpPassword.text.toString()
        val nickname = binding.etSignUpNickName.text.toString()
        val phoneNumber = binding.etSignUpPhone.text.toString()
        return SignUpRequestDto(
            authenticationId = id,
            password = password,
            nickname = nickname,
            phone = phoneNumber
        )
    }

    private fun moveToLogin(id: String, password: String, nickname: String, phoneNumber: String) {
        val intent = Intent(this@SignUpActivity, LoginActivity::class.java).apply {
            putExtra("id", id)
            putExtra("password", password)
            putExtra("nickname", nickname)
            putExtra("phoneNumber", phoneNumber)
        }
        startActivity(intent)
        finish() // 현재 SignUpActivity 종료
    }
}

data class SignUpState(
    val isSuccess: Boolean,
    val message: String
)



