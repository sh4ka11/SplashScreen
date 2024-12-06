package com.example.splashscreen.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.splashscreen.data.model.User
//import com.example.splashscreen.data.network.RegisterResponse
//import com.example.splashscreen.data.network.RetrofitClient
import kotlinx.coroutines.launch
import retrofit2.HttpException

class RegistrationViewModel : ViewModel() {
//    var name by mutableStateOf("")
//    var lastname by mutableStateOf("")
//    var email by mutableStateOf("")
//    var password by mutableStateOf("")
//    var phone by mutableStateOf("")
//    var birthDate by mutableStateOf("")
//    var location by mutableStateOf("")
//    var number by mutableStateOf("")
//
//    var registrationError by mutableStateOf<String?>(null)
//    var isLoading by mutableStateOf(false)
//
//    fun onNameChanged(newName: String) { name = newName }
//    fun onLastnameChanged(newLastname: String) { lastname = newLastname }
//    fun onEmailChanged(newEmail: String) { email = newEmail }
//    fun onPasswordChanged(newPassword: String) { password = newPassword }
//    fun onPhoneChanged(newPhone: String) { phone = newPhone }
//    fun onBirthDateChanged(newBirthDate: String) { birthDate = newBirthDate }
//    fun onLocationChanged(newLocation: String) { location = newLocation }
//    fun onNumberChanged(newNumber: String) { number = newNumber }
//
//    fun register(
//        onRegistrationSuccess: () -> Unit,
//        onRegistrationFailure: (String) -> Unit
//    ) {
//        // Validación básica
//        if (name.isBlank() || lastname.isBlank() || email.isBlank() ||
//            password.isBlank() || phone.isBlank() || birthDate.isBlank()) {
//            onRegistrationFailure("Por favor, complete todos los campos obligatorios")
//            return
//        }
//
//        isLoading = true
//        viewModelScope.launch {
//            try {
//                // Crear el objeto User con los datos del formulario
//                val user = User(
//                    name = name,
//                    lastname = lastname,
//                    email = email,
//                    password = password,
//                    phone = phone,
//                    birthDate = birthDate,
//                    location = location,
//                    number = number.toIntOrNull() ?: 0
//                )
//
//                // Llamar al endpoint de registro
//                val call = RetrofitClient.instance.registerUser(user)
//                val response = call.execute() // Ejecutar la solicitud
//
//                if (response.isSuccessful) {
//                    response.body()?.let { registerResponse ->
//                        // Guardar token (implementa el método de guardado)
//                        saveToken(registerResponse.token)
//                        onRegistrationSuccess()
//                    } ?: run {
//                        onRegistrationFailure("Respuesta vacía del servidor")
//                    }
//                } else {
//                    val errorMessage = response.errorBody()?.string()
//                        ?: "Error de registro"
//                    onRegistrationFailure(errorMessage)
//                }
//            } catch (e: HttpException) {
//                onRegistrationFailure("Error de registro: ${e.message()}")
//            } catch (e: Exception) {
//                onRegistrationFailure("Error de red: ${e.localizedMessage}")
//            } finally {
//                isLoading = false
//            }
//        }
    }


    private fun saveToken(token: String) {
        // Implementa el guardado seguro del token
        // Puedes usar DataStore o EncryptedSharedPreferences
    }
