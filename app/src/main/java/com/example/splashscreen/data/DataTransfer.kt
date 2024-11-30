package com.example.splashscreen.data

import com.google.gson.annotations.SerializedName

    class DataTransfer {
        data class LoginDto(
            @SerializedName("email") val email: String,
            @SerializedName("password") val password: String
        )

        data class RegisterDto(
            @SerializedName("name") val name: String,
            @SerializedName("LastName") val lastName: String,
            @SerializedName("email") val email: String,
            @SerializedName("password") val password: String,
            @SerializedName("userType") val userType: String // "ENTREPRENEUR" or "INVESTOR"
        )

        data class TokenDto(
            @SerializedName("accessToken") val accessTokenVerify: String,
            @SerializedName("user") val user: UserData
        )

        data class UserData(
            @SerializedName("id") val id: Int,
            @SerializedName("name") val name: String,
            @SerializedName("email") val email: String
        )




    }



