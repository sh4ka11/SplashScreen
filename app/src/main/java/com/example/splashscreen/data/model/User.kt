package com.example.splashscreen.data.model

import com.google.gson.annotations.SerializedName

data class User(
    val name: String,
    val lastname: String,
    val email: String,
    val phone: String,
    val birth_date: String,
    val location: String,
    val password: String,
    val password_confirmation: String,
    val role: String,
    val image: String
)
