package com.sopt.now.presentation.signup

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.sopt.now.data.ServicePool
import com.sopt.now.data.model.request.SignUpRequestDto
import com.sopt.now.databinding.ActivitySignupBinding
import com.sopt.now.presentation.login.LoginActivity

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var viewModel: SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val authService = ServicePool.authService
        val factory = SignUpViewModelFactory(authService)
        viewModel = ViewModelProvider(this, factory).get(SignUpViewModel::class.java)

        initViews()
        initObserver()
    }

    private fun initViews() {
        binding.btnSignUp.setOnClickListener {
            viewModel.signUp(getSignUpRequestDto(),this)
        }
    }

    private fun initObserver() {
        viewModel.signUpStateLiveData.observe(this) { state ->
            Toast.makeText(
                this@SignUpActivity,
                state.message,
                Toast.LENGTH_SHORT
            ).show()

            if (state.isSuccess) {
                moveToLogin(
                    binding.etSignUpID.text.toString(),
                    binding.etSignUpPassword.text.toString(),
                    binding.etSignUpNickName.text.toString(),
                    binding.etSignUpPhone.text.toString()
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
        val intent = LoginActivity.createIntent(this, id, password, nickname, phoneNumber)
        startActivity(intent)
        finish()
    }
}

data class SignUpState(
    val isSuccess: Boolean,
    val message: String
)



