package com.example.splashscreen.data.model

import com.google.gson.annotations.SerializedName

data class User(
    val id: Int? = null,
    val name: String,
    val lastname: String,
    val birthDate: String,
    val password: String,
    val phone: String,
    val image: String? = null,
    val email: String,
    val location: String,
    val number: Int
)
