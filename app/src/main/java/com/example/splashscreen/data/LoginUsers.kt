package com.example.splashscreen.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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



class AuthViewModel : ViewModel() {
    val isSuccessLoading = mutableStateOf(false)
    val errorMessage = mutableStateOf<String?>(null)
    val progressBar = mutableStateOf(false)

    fun login(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                progressBar.value = true
                val authService = UserApi.RetrofitHelper.getAuthService()
                val responseService = authService.getLogin(
                    DataTransfer.LoginDto(email, password)
                )

                when {
                    responseService.isSuccessful -> {
                        val tokenResponse = responseService.body()
                        tokenResponse?.let {
                            // Store token, user info, etc.
                            isSuccessLoading.value = true
                            Log.d("Login", "Successful: ${it.accessTokenVerify}")
                        }
                    }
                    responseService.code() == 401 -> {
                        errorMessage.value = "Invalid credentials"
                    }
                    else -> {
                        errorMessage.value = "Login failed: ${responseService.message()}"
                    }
                }
            } catch (e: Exception) {
                Log.e("Login", "Error", e)
                errorMessage.value = "Network error: ${e.localizedMessage}"
            } finally {
                progressBar.value = false
            }
        }
    }

    fun register(name: String,email: String, password: String, userType: String, lastName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                progressBar.value = true
                val authService = UserApi.RetrofitHelper.getAuthService()
                val responseService = authService.registerUser(
                    DataTransfer.RegisterDto(name, email,lastName, password, userType)
                )

                when {
                    responseService.isSuccessful -> {
                        val tokenResponse = responseService.body()
                        tokenResponse?.let {
                            // Store token, user info, etc.
                            isSuccessLoading.value = true
                            Log.d("Register", "Successful: ${it.accessTokenVerify}")
                        }
                    }
                    responseService.code() == 409 -> {
                        errorMessage.value = "User already exists"
                    }
                    else -> {
                        errorMessage.value = "Registration failed: ${responseService.message()}"
                    }
                }
            } catch (e: Exception) {
                Log.e("Register", "Error", e)
                errorMessage.value = "Network error: ${e.localizedMessage}"
            } finally {
                progressBar.value = false
            }
        }
    }
    fun validateLoginInput(email: String, password: String): Boolean {
        return when {
            email.isBlank() -> {
                errorMessage.value = "Email cannot be empty"
                false
            }
            password.isBlank() -> {
                errorMessage.value = "Password cannot be empty"
                false
            }
            !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                errorMessage.value = "Invalid email format"
                false
            }
            password.length < 6 -> {
                errorMessage.value = "Password must be at least 6 characters"
                false
            }
            else -> true
        }
    }
    fun validateRegistrationInput(name: String, lastName: String, email: String, password: String): Boolean {
        return when {
            name.isBlank() -> {
                errorMessage.value = "Name cannot be empty"
                false
            }
            lastName.isBlank() -> {
                errorMessage.value = "Last name cannot be empty"
                false
            }
            // Add other validations similar to login validation
            else -> true
        }
    }



}
