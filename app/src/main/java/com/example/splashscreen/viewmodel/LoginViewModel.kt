import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.example.splashscreen.data.model.LoginRequest
import kotlinx.coroutines.launch

class LoginViewModel(private val context: Context) : ViewModel() {
    var email by mutableStateOf("gasc2004@gmail.com")
    var password by mutableStateOf("123456789")
    var role by mutableStateOf("")

    var isLoading: Boolean = false
    var loginError: String? = null

    // Create an encrypted SharedPreferences instance
    private val sharedPreferences by lazy {
        val masterKeyAlias = MasterKey.DEFAULT_MASTER_KEY_ALIAS
        val masterKey = MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        EncryptedSharedPreferences.create(
            context,
            "secure_auth_prefs",
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

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
        if (email.isBlank() || password.isBlank()) {
            onLoginFailure("Por favor, complete todos los campos")
            return
        }

        if (role.isBlank()) {
            onLoginFailure("Por favor, seleccione un rol")
            return
        }

        isLoading = true
        viewModelScope.launch {
            try {
                println("Sending login: Email=$email, Role=$role")

                val loginRequest = LoginRequest(
                    email = email,
                    password = password,
                    role = role
                )

                val response = RetrofitInstance.apiService.loginUser(loginRequest)

                println("Response code: ${response.code()}")
                println("Response body: ${response.body()}")
                println("Error body: ${response.errorBody()?.string()}")

                if (response.isSuccessful) {
                    response.body()?.let { loginResponse ->
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

    fun saveToken(token: String) {
        // Validar que el token no esté vacío
        if (token.isBlank()) {
            Log.e("LoginViewModel", "Intentando guardar un token vacío")
            return
        }

        sharedPreferences.edit()
            .putString("access_token", token)
            .putString("role", role)
            .putLong("token_timestamp", System.currentTimeMillis())
            .apply()
    }

    fun getToken(): String? {
        // Opcional: Agregar lógica para verificar la validez del token
        val token = sharedPreferences.getString("access_token", null)
        val tokenTimestamp = sharedPreferences.getLong("token_timestamp", 0)

        // Ejemplo: Invalidar token después de 30 días
        val tokenAge = System.currentTimeMillis() - tokenTimestamp
        val TOKEN_EXPIRATION = 30 * 24 * 60 * 60 * 1000L // 30 días en milisegundos

        return if (token != null && tokenAge < TOKEN_EXPIRATION) token else null
    }

    fun isLoggedIn(): Boolean {
        return !getToken().isNullOrBlank()
    }

    fun clearToken() {
        sharedPreferences.edit().clear().apply()
        // Opcional: Reiniciar otros estados de la aplicación
        email = ""
        password = ""
        role = ""
    }
}