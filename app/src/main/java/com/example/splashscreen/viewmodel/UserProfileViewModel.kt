import LoginViewModel.Companion.ACCESS_TOKEN_KEY
import LoginViewModel.Companion.TOKEN_TIMESTAMP_KEY
import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.splashscreen.data.model.UserProfile
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class UserProfileViewModel(
    private val context: Context
) : ViewModel() {

    // Estados para manejar el perfil del usuario
    var userProfile by mutableStateOf<UserProfile?>(null)
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    init {
        fetchUserProfile()
    }

    fun fetchUserProfile() {
        viewModelScope.launch {
            try {
                isLoading = true
                errorMessage = null

                // Obtener el token usando el mismo método que LoginViewModel
                val token = context.dataStore.data.map { preferences ->
                    val token = preferences[ACCESS_TOKEN_KEY]
                    val tokenTimestamp = preferences[TOKEN_TIMESTAMP_KEY] ?: 0

                    val TOKEN_EXPIRATION = 30 * 24 * 60 * 60 * 1000L
                    if (token != null && (System.currentTimeMillis() - tokenTimestamp) < TOKEN_EXPIRATION) {
                        token
                    } else {
                        null
                    }
                }.first()

                if (token == null) {
                    errorMessage = "No se encontró el token de autenticación"
                    return@launch
                }

                try {
                    // Hacer la llamada a la API
                    val response = RetrofitInstance.apiService.getUserInfo("Bearer $token")
                    userProfile = response
                    errorMessage = null

                } catch (e: Exception) {
                    errorMessage = "Error al obtener el perfil: ${e.message}"
                    Log.e("UserProfileViewModel", "Error getting profile", e)
                }

            } catch (e: Exception) {
                errorMessage = "Error de red: ${e.message}"
                userProfile = null
            } finally {
                isLoading = false
            }
        }
    }

    // Función para refrescar el perfil
    fun refreshProfile() {
        fetchUserProfile()
    }
}