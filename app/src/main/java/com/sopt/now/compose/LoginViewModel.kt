package com.sopt.now.compose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val _loginSuccess = MutableLiveData<Boolean>()
    val loginSuccess: LiveData<Boolean> = _loginSuccess

    fun login(id: String, password: String, signUpId: String, signUpPassword: String) {
        val isLoginSuccess = id == signUpId && password == signUpPassword
        _loginSuccess.value = isLoginSuccess
    }
}