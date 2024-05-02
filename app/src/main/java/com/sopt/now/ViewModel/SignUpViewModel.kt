package com.sopt.now.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.now.Activity.SignUpState
import com.sopt.now.data.ServicePool
import com.sopt.now.data.SignUpRequestDto
import com.sopt.now.data.SignUpResponseDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpViewModel : ViewModel() {
    private val authService by lazy { ServicePool.authService }
    val liveData = MutableLiveData<SignUpState>()

    fun signUp(request: SignUpRequestDto) {
        authService.signUp(request).enqueue(object : Callback<SignUpResponseDto> {
            override fun onResponse(
                call: Call<SignUpResponseDto>,
                response: Response<SignUpResponseDto>,
            ) {
                if (response.isSuccessful) {
                    val data: SignUpResponseDto? = response.body()
                    val userId = response.headers()["location"]
                    liveData.value = SignUpState(
                        isSuccess = true,
                        message = "회원가입 성공 유저의 ID는 $userId 입니둥"
                    )
                    Log.d("SignUp", "data: $data, userId: $userId")
                } else {
                    if (!response.isSuccessful) {
                        val errorCode = response.code()
                        Log.e("SignUp", "HTTP Error Code: $errorCode")
                    }
                    val error = response.message()
                    liveData.value = SignUpState(
                        isSuccess = false,
                        message = "로그인이 실패 $error"
                    )
                    val errorBody = response.errorBody()?.string()
                    Log.e("SignUp", "Error Body: $errorBody")
                }
            }

            override fun onFailure(call: Call<SignUpResponseDto>, t: Throwable) {
                liveData.value = SignUpState(
                    isSuccess = false,
                    message = "서버에러"
                )
            }
        })
    }
}