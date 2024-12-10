import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.splashscreen.data.model.LoginRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "auth_preferences")

class LoginViewModel(private val context: Context) : ViewModel() {
    companion object {
        val ACCESS_TOKEN_KEY = stringPreferencesKey("access_token")
        val ROLE_KEY = stringPreferencesKey("role")
        val TOKEN_TIMESTAMP_KEY = longPreferencesKey("token_timestamp")
    }

    // Existing properties
    var email by mutableStateOf("gasc2004@gmail.com")
    var password by mutableStateOf("123456789")
    var role by mutableStateOf("")

    var isLoading: Boolean = false
    var loginError: String? = null

    // New methods to handle email and password changes
    fun onEmailChanged(newEmail: String) {
        email = newEmail
    }

    fun onPasswordChanged(newPassword: String) {
        password = newPassword
    }

    // Rest of the existing code remains the same...
    fun saveToken(token: String) {
        viewModelScope.launch {
            if (token.isBlank()) {
                Log.e("LoginViewModel", "Attempting to save an empty token")
                return@launch
            }

            context.dataStore.edit { preferences ->
                preferences[ACCESS_TOKEN_KEY] = token
                preferences[ROLE_KEY] = role
                preferences[TOKEN_TIMESTAMP_KEY] = System.currentTimeMillis()
            }
        }
    }

    fun getToken(): Flow<String?> = context.dataStore.data.map { preferences ->
        val token = preferences[ACCESS_TOKEN_KEY]
        val tokenTimestamp = preferences[TOKEN_TIMESTAMP_KEY] ?: 0

        val TOKEN_EXPIRATION = 30 * 24 * 60 * 60 * 1000L
        if (token != null && (System.currentTimeMillis() - tokenTimestamp) < TOKEN_EXPIRATION) {
            token
        } else {
            null
        }
    }

    fun isLoggedIn(): Flow<Boolean> = getToken().map { it != null }

    fun clearToken() {
        viewModelScope.launch {
            context.dataStore.edit { preferences ->
                preferences.clear()
            }
            email = ""
            password = ""
            role = ""
        }
    }

    fun login(
        onLoginSuccess: () -> Unit,
        onLoginFailure: (String) -> Unit
    ) {
        if (email.isBlank() || password.isBlank()) {
            onLoginFailure("Please complete all fields")
            return
        }

        if (role.isBlank()) {
            onLoginFailure("Please select a role")
            return
        }

        isLoading = true
        viewModelScope.launch {
            try {
                val loginRequest = LoginRequest(
                    email = email,
                    password = password,
                    role = role
                )

                val response = RetrofitInstance.apiService.loginUser(loginRequest)

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
}