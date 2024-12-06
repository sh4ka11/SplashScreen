import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.splashscreen.data.model.LoginRequest
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var isLoading: Boolean = false
    var loginError: String? = null

    fun onEmailChanged(newEmail: String) {
        email = newEmail
    }

    fun onPasswordChanged(newPassword: String) {
        password = newPassword
    }

    fun login(
        onLoginSuccess: () -> Unit,
        onLoginFailure: (String) -> Unit
    ) {
        // Basic validation
        if (email.isBlank() || password.isBlank()) {
            onLoginFailure("Por favor, complete todos los campos")
            return
        }

        isLoading = true
        viewModelScope.launch {
            try {
                // Logging for debugging (consider removing in production)
                println("Sending login: Email=$email")

                val loginRequest = LoginRequest(
                    email = email,
                    password = password,
                    role = "entrepreneur" // Consider how role is determined
                )

                val response = RetrofitInstance.apiService.loginUser(loginRequest)


                // Detailed logging (remove in production)
                println("Response code: ${response.code()}")
                println("Response body: ${response.body()}")
                println("Error body: ${response.errorBody()?.string()}")

                if (response.isSuccessful) {
                    response.body()?.let { loginResponse ->
                        // Implement token saving logic
                        saveToken(loginResponse.access_token)
                        onLoginSuccess()
                    } ?: run {
                        onLoginFailure("Empty server response")
                    }
                } else {
                    val errorBody = response.errorBody()?.string()
                    val errorMessage = when (response.code()) {
                        400 -> "Bad Request"
                        401 -> "Invalid Credentials"
                        404 -> "Resource Not Found"
                        500 -> "Internal Server Error"
                        else -> "Unknown Error"
                    }
                    onLoginFailure("$errorMessage: $errorBody")
                }
            } catch (e: Exception) {
                e.printStackTrace()
                onLoginFailure("Network Error: ${e.localizedMessage ?: "Unknown error"}")
            } finally {
                isLoading = false
            }
        }
    }

    private fun saveToken(token: String) {
        // Implement token saving logic
        // For example, using SharedPreferences or a secure token storage method
    }
}