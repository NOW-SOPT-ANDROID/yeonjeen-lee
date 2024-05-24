package com.sopt.now.compose.SignUp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.now.compose.Data.ServicePool
import com.sopt.now.compose.Data.Request.SignUpRequestDto
import com.sopt.now.compose.Data.Response.SignUpResponseDto
import com.sopt.now.compose.Data.SignUpResult
import com.sopt.now.compose.Repository.SignUpRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class SignUpViewModel(private val repository: SignUpRepository) : ViewModel() {

    private val _signUpState = MutableStateFlow(SignUpState())
    val signUpState: StateFlow<SignUpState> = _signUpState

    fun signUp(authenticationId: String, password: String, nickname: String, phone: String) {
        val requestDto = SignUpRequestDto(authenticationId, password, nickname, phone)

        viewModelScope.launch {
            try {
                val response = repository.signUp(requestDto)
                handleResponse(response)
            } catch (e: Exception) {
                _signUpState.value = SignUpState(
                    isSuccess = false,
                    message = "서버 에러: ${e.message}"
                )
            }
        }
    }

    private fun handleResponse(response: Response<SignUpResponseDto>) {
        if (response.isSuccessful) {
            val userId = response.headers()["location"]
            _signUpState.value = SignUpState(
                isSuccess = true,
                message = "회원가입 성공! 유저의 ID는 $userId 입니다"
            )
        } else {
            val errorCode = response.code()
            val errorMessage = response.message()
            _signUpState.value = SignUpState(
                isSuccess = false,
                message = "회원가입 실패: $errorCode, $errorMessage"
            )
        }
    }
}

data class SignUpState(
    val isSuccess: Boolean = false,
    val message: String = ""
)
