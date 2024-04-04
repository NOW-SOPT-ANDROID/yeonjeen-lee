package com.sopt.now.ViewModel

import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {
    private val MIN_ID_LENGTH = 6
    private val MAX_ID_LENGTH = 10
    private val MIN_PASSWORD_LENGTH = 8
    private val MAX_PASSWORD_LENGTH = 12

    fun checkSignUpAllowed(id: String, password: String, nickname: String,selectedMbti: String): Boolean {
        val idLengthValid = id.length in MIN_ID_LENGTH..MAX_ID_LENGTH
        val passwordLengthValid = password.length in MIN_PASSWORD_LENGTH..MAX_PASSWORD_LENGTH
        val nicknameValid = nickname.isNotEmpty() && !nickname.trim().contains(" ")
        val mbtiValid = selectedMbti.isNotEmpty()

        return idLengthValid && passwordLengthValid && nicknameValid && mbtiValid
    }
}