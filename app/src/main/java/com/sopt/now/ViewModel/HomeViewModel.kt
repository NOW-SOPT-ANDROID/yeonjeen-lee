package com.sopt.now.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.now.data.FriendInfoData
import com.sopt.now.data.FriendResponseDto
import com.sopt.now.data.ServicePool
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    private val _friendListLiveData = MutableLiveData<List<FriendInfoData>>()
    val friendListLiveData: LiveData<List<FriendInfoData>> = _friendListLiveData

    fun getUsers() {
        ServicePool.reqresService.getUsers(page = 2).enqueue(
            object : Callback< FriendResponseDto> {
                override fun onResponse(
                    call: Call<FriendResponseDto>,
                    response: Response<FriendResponseDto>
                ) {
                    if (response.isSuccessful) {
                        val friendResponse = response.body()

                        friendResponse?.let { friendResponse ->
                            val friendList = friendResponse.data.map {
                                FriendInfoData(
                                    profileImage = it.avatar,
                                    name = "${it.first_name} ${it.last_name}",
                                    type = "",
                                    eMail = it.email,
                                    id = it.id
                                )
                            }
                            _friendListLiveData.value = friendList
                        }
                    } else {
                        Log.e("FriendViewModel", response.errorBody().toString())
                    }
                }
                override fun onFailure(call: Call<FriendResponseDto>, t: Throwable) {
                    t.printStackTrace()
                }
            }
        )
    }
}


