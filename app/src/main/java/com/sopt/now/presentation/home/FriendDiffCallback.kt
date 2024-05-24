package com.sopt.now.presentation.home

import androidx.recyclerview.widget.DiffUtil
import com.sopt.now.data.FriendInfoData

class FriendDiffCallback(private val oldList: List<FriendInfoData>, private val newList: List<FriendInfoData>) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}