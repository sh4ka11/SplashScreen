package com.example.splashscreen.data.model

import androidx.annotation.Nullable
import com.google.gson.annotations.SerializedName
import okhttp3.MultipartBody
import retrofit2.http.Multipart

data class User(
    val name: String,
    val lastname: String,
    val email: String,
    val phone: String,
    val birth_date: String,
    val location: String,
    val number: String,
    val password: String,
    val password_confirmation: String,
    val role: String,
    var image: String? // Asegúrate de que sea nullable
)
