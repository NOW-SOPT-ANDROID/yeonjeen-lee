package com.sopt.now.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FriendResponseDto(
    @SerialName("data") val data: List<ResponseReqresFriendDto>,
    @SerialName("page") val page: Int,
    @SerialName("per_page") val per_page: Int,
    @SerialName("total") val total: Int,
    @SerialName("support") val support: Support,
    @SerialName("total_pages") val total_pages: Int,
) {
    @Serializable
    data class ResponseReqresFriendDto(
        @SerialName("avatar") val avatar: String,
        @SerialName("email") val email: String,
        @SerialName("first_name") val first_name: String,
        @SerialName("id") val id: Int,
        @SerialName("last_name") val last_name: String,
    )

    @Serializable
    data class Support(
        @SerialName("text") val text: String,
        @SerialName("url") val url: String,
    )
}