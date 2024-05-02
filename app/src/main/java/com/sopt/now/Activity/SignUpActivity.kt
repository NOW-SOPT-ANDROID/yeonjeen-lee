package com.sopt.now.Activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.sopt.now.ViewModel.SignUpViewModel
import com.sopt.now.data.ServicePool
import com.sopt.now.data.SignUpRequestDto
import com.sopt.now.data.SignUpResponseDto
import com.sopt.now.databinding.ActivitySignupBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var viewModel: SignUpViewModel
    private val authService by lazy { ServicePool.authService }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)

        initViews()
    }

    private fun initViews() {
        binding.btnSignUp.setOnClickListener {
            signUp()
        }
    }

    private fun signUp() {
        val signUpRequest = getSignUpRequestDto()
        authService.signUp(signUpRequest).enqueue(object : Callback<SignUpResponseDto> {
            override fun onResponse(
                call: Call<SignUpResponseDto>,
                response: Response<SignUpResponseDto>,
            ) {
                if (response.isSuccessful) {
                    val data: SignUpResponseDto? = response.body()
                    val userId = response.headers()["location"]
                    Toast.makeText(
                        this@SignUpActivity,
                        "회원가입 성공 유저의 ID는 $userId 입니둥",
                        Toast.LENGTH_SHORT,
                    ).show()
                    Log.d("SignUp", "data: $data, userId: $userId")
                } else {
                    val error = response.message()
                    Toast.makeText(
                        this@SignUpActivity,
                        "로그인이 실패 $error",
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }

            override fun onFailure(call: Call<SignUpResponseDto>, t: Throwable) {
                Log.e("SignUp", "서버 에러 발생", t)
                Toast.makeText(this@SignUpActivity, "서버 에러 발생 ", Toast.LENGTH_SHORT).show()
            }
        })
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
}

//    private fun setupSignUp() {
//        binding.btnSignUp.setOnClickListener {
//            val id = binding.etSignUpID.text.toString()
//            val password = binding.etSignUpPassword.text.toString()
//            val nickname = binding.etSignUpNickName.text.toString()
//            val phoneNumber = binding.etSignUpPhone.text.toString()
//
//            handleSignUpResult(id, password, nickname, phoneNumber)
//        }
//    }
//
//    private fun handleSignUpResult(
//        id: String,
//        password: String,
//        nickname: String,
//        selectedMbti: String
//    ) {
//        if (viewModel.checkSignUpAllowed(id, password, nickname, selectedMbti)) {
//            Toast.makeText(this, "회원가입에 성공했습니다.", Toast.LENGTH_SHORT).show()
//            moveToLogin(id, password, nickname, selectedMbti)
//        } else {
//            Toast.makeText(this, "회원가입에 실패하셨습니다.", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    private fun moveToLogin(
//        id: String,
//        password: String,
//        nickname: String,
//        selectedMbti: String
//    ) {
//        val intent = Intent(this, LoginActivity::class.java)
//        intent.putExtra("id", id)
//        intent.putExtra("password", password)
//        intent.putExtra("nickname", nickname)
//        intent.putExtra("mbti", selectedMbti)
//        startActivity(intent)
//        finish()
//    }
//}