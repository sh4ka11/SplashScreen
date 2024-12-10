package com.example.splashscreen.data.repository

import LoginViewModel
import UserProfileViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UserProfileViewModelFactory(
    private val loginViewModel: LoginViewModel
) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(UserProfileViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return UserProfileViewModel(loginViewModel) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
}