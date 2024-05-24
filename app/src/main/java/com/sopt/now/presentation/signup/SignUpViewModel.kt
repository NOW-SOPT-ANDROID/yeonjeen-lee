package com.sopt.now.presentation.signup

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.now.R
import com.sopt.now.data.model.request.SignUpRequestDto
import com.sopt.now.data.model.response.SignUpResponseDto
import com.sopt.now.data.service.AuthService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpViewModel(
    private val context: Context,
    private val authService: AuthService
) : ViewModel() {
    val signUpStateLiveData = MutableLiveData<SignUpState>()

    fun signUp(request: SignUpRequestDto) {
        authService.signUp(request).enqueue(object : Callback<SignUpResponseDto> {
            override fun onResponse(
                call: Call<SignUpResponseDto>,
                response: Response<SignUpResponseDto>
            ) {
                if (response.isSuccessful) {
                    val data: SignUpResponseDto? = response.body()
                    val userId = response.headers()["location"]
                    signUpStateLiveData.value = SignUpState(
                        isSuccess = true,
                        message = context.getString(R.string.signup_success_message, userId)
                    )
                    Log.d("SignUp", "data: $data, userId: $userId")
                } else {
                    val errorCode = response.code()
                    Log.e("SignUp", context.getString(R.string.signup_error_http_code, errorCode))
                    val error = response.message()
                    signUpStateLiveData.value = SignUpState(
                        isSuccess = false,
                        message = context.getString(R.string.signup_failure_message, error)
                    )
                    val errorBody = response.errorBody()?.string()
                    Log.e("SignUp", context.getString(R.string.signup_error_body, errorBody))
                }
            }

            override fun onFailure(call: Call<SignUpResponseDto>, t: Throwable) {
                signUpStateLiveData.value = SignUpState(
                    isSuccess = false,
                    message = context.getString(R.string.server_error)
                )
            }
        })
    }
}