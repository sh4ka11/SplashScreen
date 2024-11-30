package com.example.splashscreen.data

import com.google.gson.annotations.SerializedName
class DataTransfer {

    data class LoginDto(
        @SerializedName("email") val email: String,
        @SerializedName("password") val password: String
    )
    data class TokenDto(
        @SerializedName("accessToken") val accessTokenVerify: String
    )

}