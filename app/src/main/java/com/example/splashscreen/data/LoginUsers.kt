package com.example.splashscreen.data

class LoginUsersdata class LoginRequest(
    val email: String,
    val password: String
)

data class LoginResponse(
    val token: String,
    val user: User
)

data class User(
    val id: Int,
    val email: String,
    val name: String
)
