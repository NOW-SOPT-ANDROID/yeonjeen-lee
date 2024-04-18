package com.sopt.now.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.sopt.now.ViewModel.LoginViewModel
import com.sopt.now.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        val savedId = intent.getStringExtra("id")
        val savedPassword = intent.getStringExtra("password")

        moveToSignUp()
        initializeLoginButton(savedId, savedPassword)
    }

    private fun moveToSignUp() {
        binding.btnGotoSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initializeLoginButton(savedId: String?, savedPassword: String?) {
        binding.btnLogin.setOnClickListener {
            val inputId = binding.etLoginID.text.toString()
            val inputPassword = binding.etLoginPs.text.toString()

            validateAndPerformLogin(inputId, inputPassword, savedId, savedPassword)
        }
    }

    private fun validateAndPerformLogin(
        inputId: String,
        inputPassword: String,
        savedId: String?,
        savedPassword: String?
    ) {
        if (viewModel.checkLoginCredentials(inputId, inputPassword, savedId, savedPassword)) {
            Toast.makeText(this, "로그인에 성공했습니다.", Toast.LENGTH_SHORT).show()
            moveToMainActivity(savedId, savedPassword)
        } else {
            Toast.makeText(this, "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun moveToMainActivity(savedId: String?, savedPassword: String?) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtras(createBundleForUserInfo(savedId, savedPassword))
        startActivity(intent)
        finish()
    }

    private fun createBundleForUserInfo(savedId: String?, savedPassword: String?): Bundle {
        val userInfoBundle = Bundle()
        with(userInfoBundle) {
            putString("id", savedId)
            putString("password", savedPassword)
            putString("nickname", intent.getStringExtra("nickname"))
            putString("mbti", intent.getStringExtra("mbti"))
        }
        return userInfoBundle
    }
}