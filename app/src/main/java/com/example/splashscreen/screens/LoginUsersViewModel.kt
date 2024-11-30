package com.example.splashscreen.screens

//import androidx.compose.runtime.mutableStateOf
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.splashscreen.data.User
//import com.example.splashscreen.navigation.LoginRepository
//import kotlinx.coroutines.launch
//
//class LoginViewModel : ViewModel() {
//    private val repository = LoginRepository()
//
//    private val _loginState = mutableStateOf<LoginState>(LoginState.Initial)
//    val loginState: Thread.State<LoginState> = _loginState
//
//    sealed class LoginState {
//        object Initial : LoginState()
//        object Loading : LoginState()
//        data class Success(val user: User) : LoginState()
//        data class Error(val message: String) : LoginState()
//    }
//
//    fun login(email: String, password: String) {
//        viewModelScope.launch {
//            _loginState.value = LoginState.Loading
//
//            repository.login(email, password)
//                .onSuccess { response ->
//                    _loginState.value = LoginState.Success(response.user)
//                    // Guarda el token para futuras peticiones
//                    saveToken(response.token)
//                }
//                .onFailure { exception ->
//                    _loginState.value = LoginState.Error(exception.message ?: "Error desconocido")
//                }
//        }
//    }
//
//    private fun saveToken(token: String) {
//        // Implementa el guardado del token según tu preferencia
//        // Podrías usar DataStore o SharedPreferences
//    }
//}
