package com.example.splashscreen.data.model


data class UserProfile(
    val id: Int,
    val name: String,
    val lastname: String,
    val birth_date: String,
    val phone: String,
    val image: String?,
    val email: String,
    val location: String,
    val number: Int,
    val created_at: String,
    val updated_at: String
)
