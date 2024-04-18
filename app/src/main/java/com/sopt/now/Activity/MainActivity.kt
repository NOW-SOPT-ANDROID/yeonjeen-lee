package com.sopt.now.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sopt.now.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getStringExtra("id") ?: ""
        val password = intent.getStringExtra("password") ?: ""
        val nickname = intent.getStringExtra("nickname") ?: ""
        val mbti = intent.getStringExtra("mbti") ?: ""

        setMainProfile(id, password, nickname, mbti)
    }

    private fun setMainProfile(id: String, password: String, nickname: String, mbti: String) {
        with(binding) {
            tvMainId.text = id
            tvMainPs.text = password
            tvMainNickName.text = nickname
            tvMainMbti.text = mbti
        }
    }
}