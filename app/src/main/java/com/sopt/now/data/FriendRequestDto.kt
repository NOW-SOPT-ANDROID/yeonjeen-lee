package com.sopt.now.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FriendRequestDto (
    @SerialName("page")
    val page: Int=1,
    @SerialName("per_page")
    val per_page: Int,
    @SerialName("total")
    val total: Int,
    @SerialName("total_pages")
    val total_pages: Int,
    @SerialName("data")
    val data: List<FriendResponseDto>,
    @SerialName("support")
    val support: SupportResponseDto
)