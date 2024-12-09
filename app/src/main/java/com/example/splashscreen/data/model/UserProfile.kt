package com.example.splashscreen.data.model

import com.google.gson.annotations.SerializedName

data class UserProfile(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("location") val location: String,
    @SerializedName("birthdate") val birthDate: String,
    @SerializedName("image") val image: String
)