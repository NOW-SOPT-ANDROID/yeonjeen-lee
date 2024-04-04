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

        goToSignUp()
        setupLogin(savedId, savedPassword)
    }

    private fun goToSignUp() {
        binding.btnGotoSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupLogin(savedId: String?, savedPassword: String?) {
        binding.btnLogin.setOnClickListener {
            val inputId = binding.etLoginID.text.toString()
            val inputPassword = binding.etLoginPs.text.toString()

            if (viewModel.checkLoginCredentials(inputId, inputPassword, savedId, savedPassword)) {
                Toast.makeText(this, "로그인에 성공했습니다.", Toast.LENGTH_SHORT).show()
                moveToMainActivity(savedId, savedPassword)
            } else {
                Toast.makeText(this, "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun moveToMainActivity(savedId: String?, savedPassword: String?) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtras(createMainActivityExtras(savedId, savedPassword))
        startActivity(intent)
        finish()
    }

    private fun createMainActivityExtras(savedId: String?, savedPassword: String?): Bundle {
        val extras = Bundle()
        extras.putString("id", savedId)
        extras.putString("password", savedPassword)
        extras.putString("nickname", intent.getStringExtra("nickname"))
        extras.putString("mbti", intent.getStringExtra("mbti"))
        return extras
    }
}