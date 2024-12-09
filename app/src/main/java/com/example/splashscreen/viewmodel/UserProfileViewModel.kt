package com.example.splashscreen.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.splashscreen.data.model.UserProfile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response

class UserProfileViewModel : ViewModel() {
    private val _user = MutableStateFlow<UserProfile?>(null)
    val user: StateFlow<UserProfile?> = _user

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun loadUserProfile(context: Context) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null

            // Recuperar token de SharedPreferences
            val token = context.getSharedPreferences("auth_prefs", Context.MODE_PRIVATE)
                .getString("token", null)

            if (token.isNullOrEmpty()) {
                _error.value = "Token no encontrado"
                _isLoading.value = false
                return@launch
            }

            try {
                val response: Response<com.example.splashscreen.screens.UserProfile> = RetrofitInstance.apiService.getUserProfile("Bearer $token")
                if (response.isSuccessful) {
                    _user.value = response.body()
                    _error.value = null
                } else {
                    val errorMessage = response.errorBody()?.string() ?: "Error en la respuesta de la API"
                    _error.value = "Error: $errorMessage (${response.code()})"
                }
            } catch (e: Exception) {
                _error.value = "Excepción al obtener perfil: ${e.localizedMessage}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}