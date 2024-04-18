package com.sopt.now.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.sopt.now.Fragment.MyPageFragment
import com.sopt.now.R
import com.sopt.now.data.UserInfoData
import com.sopt.now.databinding.ItemMyprofileBinding

class MyProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding: ItemMyprofileBinding = ItemMyprofileBinding.bind(itemView)
    private val ivProfile: ShapeableImageView = binding.ivHomeMyProfile
    private val tvName: TextView = binding.tvHomeMyProfileName
    private val tvSelfDescription: TextView = binding.tvHomeMyProfileFriendDescription

    fun bindMyProfile(myProfile: UserInfoData.MyInfo,activity: FragmentActivity) {
        ivProfile.setImageResource(myProfile.profileImage)
        tvName.text = myProfile.name
        tvSelfDescription.text = myProfile.selfDescription
    }

}