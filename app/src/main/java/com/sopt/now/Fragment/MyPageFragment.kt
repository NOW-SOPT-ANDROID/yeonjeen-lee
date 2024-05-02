package com.sopt.now.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sopt.now.databinding.FragmentMypageBinding

class MyPageFragment : Fragment() {
    private var _binding: FragmentMypageBinding? = null
    private val binding
        get() = requireNotNull(_binding) {
            "바인딩 객체 좀 생성해주세요"
        }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMypageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getString("id") ?: ""
        val password = arguments?.getString("password") ?: ""
        val nickname = arguments?.getString("nickname") ?: ""
        val phoneNumber = arguments?.getString("phonenumber") ?: ""

        setMainProfile(id, password, nickname, phoneNumber)

    }

    private fun setMainProfile(id: String, password: String, nickname: String, phoneNumber: String) {
        with(binding) {
            tvMyId.text = id
            tvMyPassword.text = password
            tvMyNickName.text = nickname
            tvMyPhoneNumber.text = phoneNumber
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}