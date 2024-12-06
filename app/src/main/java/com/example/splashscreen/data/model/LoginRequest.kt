package com.example.splashscreen.data.model


data class LoginRequest(
    val email: String,
    val password: String,
    val role: String // "entrepreneur" or "investor"
)