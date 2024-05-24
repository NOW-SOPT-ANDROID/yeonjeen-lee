package com.sopt.now.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sopt.now.data.FriendInfoData
import com.sopt.now.databinding.ItemFriendBinding

class FriendAdapter : RecyclerView.Adapter<FriendViewHolder>() {
    private var friendList: List<FriendInfoData> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFriendBinding.inflate(inflater, parent, false)
        return FriendViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        holder.onBindFriend(friendList[position])
    }

    override fun getItemCount(): Int = friendList.size

    fun setFriendList(newList: List<FriendInfoData>) {
        val diffCallback = FriendDiffCallback(friendList, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        friendList = newList
        diffResult.dispatchUpdatesTo(this)
    }
}