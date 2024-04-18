package com.sopt.now.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.sopt.now.R
import com.sopt.now.data.UserInfoData

class UserInfoAdapter(private var items: List<UserInfoData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_ITEM1 = 1
    private val VIEW_TYPE_ITEM2 = 2
    private val VIEW_TYPE_ITEM3 = 3
    fun setUsersList(userList: List<UserInfoData>) {
        items = userList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_ITEM1 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_myprofile, parent, false)
                MyProfileViewHolder(view)
            }
            VIEW_TYPE_ITEM2 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_birthday_friend, parent, false)
                BirthDayFriendViewHolder(view)
            }
            VIEW_TYPE_ITEM3 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_friend, parent, false)
                FriendViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MyProfileViewHolder -> {
                if (items[position] is UserInfoData.MyInfo) {
                    val myProfile = items[position] as UserInfoData.MyInfo
                    holder.bindMyProfile(myProfile, activity = FragmentActivity())
                }
            }
            is BirthDayFriendViewHolder -> {
                if (items[position] is UserInfoData.BrithDayFriendInfo) {
                    val birthDayFriend = items[position] as UserInfoData.BrithDayFriendInfo
                    holder.bindBirthDayFriend(birthDayFriend)
                }
            }
            is FriendViewHolder -> {
                if (items[position] is UserInfoData.FriendInfo) {
                    val friend = items[position] as UserInfoData.FriendInfo
                    holder.bindFriend(friend)
                }
            }
        }
    }


    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is UserInfoData.MyInfo -> VIEW_TYPE_ITEM1
            is UserInfoData.BrithDayFriendInfo -> VIEW_TYPE_ITEM2
            is UserInfoData.FriendInfo -> VIEW_TYPE_ITEM3
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount() = items.size
}