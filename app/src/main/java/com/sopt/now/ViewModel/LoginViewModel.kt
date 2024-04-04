package com.sopt.now.ViewModel

import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    fun checkLoginCredentials(inputId: String, inputPassword: String, savedId: String?, savedPassword: String?): Boolean {
        if (savedId != null && savedPassword != null) {
            return inputId == savedId && inputPassword == savedPassword
        }
        return false
    }
}