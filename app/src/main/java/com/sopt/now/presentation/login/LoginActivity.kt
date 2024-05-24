package com.sopt.now.presentation.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.sopt.now.R
import com.sopt.now.databinding.ActivityLoginBinding
import com.sopt.now.presentation.MainActivity
import com.sopt.now.presentation.signup.SignUpActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        val savedId = intent.getStringExtra(EXTRA_ID) ?: ""
        val savedPassword = intent.getStringExtra(EXTRA_PASSWORD) ?: ""

        moveToSignUp()
        initializeLoginButton(savedId, savedPassword)
    }

    private fun moveToSignUp() {
        binding.btnGotoSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initializeLoginButton(savedId: String, savedPassword: String) {
        binding.btnLogin.setOnClickListener {
            val inputId = binding.etLoginID.text.toString()
            val inputPassword = binding.etLoginPassword.text.toString()

            validateAndPerformLogin(inputId, inputPassword, savedId, savedPassword)
        }
    }

    private fun validateAndPerformLogin(inputId: String, inputPassword: String, savedId: String, savedPassword: String) {
        if (viewModel.checkLoginCredentials(inputId, inputPassword, savedId, savedPassword)) {
            Toast.makeText(this, getString(R.string.login_success_message), Toast.LENGTH_SHORT).show()
            moveToMainActivity(savedId, savedPassword)
        } else {
            Toast.makeText(this, getString(R.string.login_failure_message), Toast.LENGTH_SHORT).show()
        }
    }

    private fun moveToMainActivity(savedId: String, savedPassword: String) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtras(createBundleForUserInfo(savedId, savedPassword))
        startActivity(intent)
        finish()
    }

    private fun createBundleForUserInfo(savedId: String, savedPassword: String): Bundle {
        val userInfoBundle = Bundle()
        with(userInfoBundle) {
            putString(EXTRA_ID, savedId)
            putString(EXTRA_PASSWORD, savedPassword)
            putString(EXTRA_NICKNAME, intent.getStringExtra(EXTRA_NICKNAME))
            putString(EXTRA_PHONE_NUMBER, intent.getStringExtra(EXTRA_PHONE_NUMBER))
        }
        return userInfoBundle
    }

    companion object {
        private const val EXTRA_ID = "id"
        private const val EXTRA_PASSWORD = "password"
        private const val EXTRA_NICKNAME = "nickname"
        private const val EXTRA_PHONE_NUMBER = "phoneNumber"

        fun createIntent(context: Context, id: String, password: String, nickname: String, phoneNumber: String): Intent {
            return Intent(context, LoginActivity::class.java).apply {
                putExtra(EXTRA_ID, id)
                putExtra(EXTRA_PASSWORD, password)
                putExtra(EXTRA_NICKNAME, nickname)
                putExtra(EXTRA_PHONE_NUMBER, phoneNumber)
            }
        }
    }
}