package com.sopt.now.presentation.home

import androidx.recyclerview.widget.RecyclerView
import com.sopt.now.data.FriendInfoData
import com.sopt.now.databinding.ItemFriendBinding
import com.bumptech.glide.Glide

class FriendViewHolder(private val binding: ItemFriendBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBindFriend(friend: FriendInfoData) {
        Glide.with(itemView)
            .load(friend.profileImage)
            .into(binding.ivHomeFriend)
        binding.tvHomeFriendName.text = friend.name
        binding.tvHomeFriendEMail.text = friend.eMail
    }
}
