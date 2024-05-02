package com.sopt.now.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.sopt.now.data.UserInfoData
import com.sopt.now.databinding.ItemFriendBinding

class FriendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding: ItemFriendBinding = ItemFriendBinding.bind(itemView)
    private val ivProfile: ShapeableImageView = binding.ivHomeFriend
    private val tvName: TextView = binding.tvHomeFriendName
    private val tvSelfDescription: TextView = binding.tvHomeFriendDescription


    fun bindFriend(friend: UserInfoData.FriendInfo) {
        ivProfile.setImageResource(friend.profileImage)
        tvName.text = friend.name
        tvSelfDescription.text = friend.selfDescription
    }
}