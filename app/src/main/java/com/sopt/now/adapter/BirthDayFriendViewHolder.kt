package com.sopt.now.adapter

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.sopt.now.data.UserInfoData
import com.sopt.now.databinding.ItemBirthdayFriendBinding

class BirthDayFriendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding: ItemBirthdayFriendBinding = ItemBirthdayFriendBinding.bind(itemView)
    private val ivProfile: ShapeableImageView = binding.ivHomeBirthday
    private val tvName: TextView = binding.tvHomeBirthdayName
    private val tvSelfDescription: TextView = binding.tvHomeBirthdayDescription
    private val btnGift: Button = binding.btnHomeBirthdayGiveGift
    private val ivBirthdayMark: ImageView = binding.tvHomeBirthdayMark

    fun bindBirthDayFriend(birthdayFriend: UserInfoData.BrithDayFriendInfo) {
        ivProfile.setImageResource(birthdayFriend.profileImage)
        tvName.text = birthdayFriend.name
        tvSelfDescription.text = birthdayFriend.selfDescription
        ivBirthdayMark.setOnClickListener { }
        btnGift.setOnClickListener{}
    }
}

