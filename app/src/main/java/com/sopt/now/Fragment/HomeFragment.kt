package com.sopt.now.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sopt.now.ViewModel.HomeViewModel
import com.sopt.now.adapter.FriendAdapter
import com.sopt.now.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var friendAdapter: FriendAdapter
    private val binding
        get() = requireNotNull(_binding) {
            "바인딩 객체 좀 생성해주세요"
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initObserver()
        viewModel.getUsers()
    }

    private fun initAdapter() {
        friendAdapter = FriendAdapter()
        binding.rvHomeUser.adapter = friendAdapter
    }

    private fun initObserver() {
        viewModel.friendListLiveData.observe(this) { friendList ->
            friendAdapter.setFriendList(friendList)
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}