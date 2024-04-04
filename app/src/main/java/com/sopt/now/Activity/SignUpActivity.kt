package com.sopt.now.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.sopt.now.R
import com.sopt.now.ViewModel.SignUpViewModel
import com.sopt.now.databinding.ActivitySignupBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var viewModel: SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)

        setMbtiSpinner()
        setupSignUpButton()
    }

    private fun setMbtiSpinner() {
        val mbtiTypes = resources.getStringArray(R.array.mbti_type)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, mbtiTypes)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spSignUpMbti.adapter = adapter
    }

    private fun setupSignUpButton() {
        binding.btnSignUp.setOnClickListener {
            val id = binding.etSignUpID.text.toString()
            val password = binding.etSignUpPs.text.toString()
            val nickname = binding.etSignUpNickName.text.toString()
            val selectedMbti = binding.spSignUpMbti.selectedItem.toString()

            handleSignUpResult(id, password, nickname, selectedMbti)
        }
    }

    private fun handleSignUpResult(
        id: String,
        password: String,
        nickname: String,
        selectedMbti: String
    ) {
        if (viewModel.checkSignUpAllowed(id, password, nickname, selectedMbti)) {
            Toast.makeText(this, "회원가입에 성공했습니다.", Toast.LENGTH_SHORT).show()
            moveToLoginScreen(id, password, nickname, selectedMbti)
        } else {
            Toast.makeText(this, "회원가입에 실패하셨습니다.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun moveToLoginScreen(
        id: String,
        password: String,
        nickname: String,
        selectedMbti: String
    ) {
        val intent = Intent(this, LoginActivity::class.java)
        intent.putExtra("id", id)
        intent.putExtra("password", password)
        intent.putExtra("nickname", nickname)
        intent.putExtra("mbti", selectedMbti)
        startActivity(intent)
        finish()
    }
}