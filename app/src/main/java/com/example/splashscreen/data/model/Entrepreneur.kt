package com.example.splashscreen.data.model

import com.google.gson.annotations.SerializedName

data class Entrepreneur(
    val id: Int,
    @SerializedName("user_id") val userId: Int,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("updated_at") val updatedAt: String,
    val user: User
)


