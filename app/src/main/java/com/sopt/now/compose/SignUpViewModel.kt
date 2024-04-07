package com.sopt.now.compose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {
    private val _signUpSuccess = MutableLiveData<Boolean>()
    val signUpSuccess: LiveData<Boolean> = _signUpSuccess

    fun signUp(id: String, password: String, nickname: String, address: String) {
        val isIdValid = id.length in MIN_ID_LENGTH..MAX_ID_LENGTH
        val isPasswordValid = password.length in MIN_PASSWORD_LENGTH..MAX_PASSWORD_LENGTH
        val isNicknameValid = nickname.isNotBlank() && !nickname.contains(" ")
        val isAddressValid = address.isNotBlank()

        _signUpSuccess.postValue(isIdValid && isPasswordValid && isNicknameValid && isAddressValid)
    }

    companion object {
        private const val MIN_ID_LENGTH = 6
        private const val MAX_ID_LENGTH = 10
        private const val MIN_PASSWORD_LENGTH = 8
        private const val MAX_PASSWORD_LENGTH = 12
    }
}
