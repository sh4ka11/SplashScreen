import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.splashscreen.data.model.UserProfile
import com.example.splashscreen.data.model.UserProfileRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response

class UserProfilaeViewModel : ViewModel() {
//    private val _user = MutableStateFlow<UserProfile?>(null)
//    val user: StateFlow<UserProfile?> = _user
//
//    private val _isLoading = MutableStateFlow(false)
//    val isLoading: StateFlow<Boolean> = _isLoading
//
//    private val _error = MutableStateFlow<String?>(null)
//    val error: StateFlow<String?> = _error
//
//    fun loadUserProfile(context: Context) {
//        viewModelScope.launch {
//            _isLoading.value = true
//            _error.value = null
//
//            // Obtener token de SharedPreferences
//            val token = context.getSharedPreferences("auth_prefs", Context.MODE_PRIVATE)
//                .getString("token", null)
//
//            if (token.isNullOrEmpty()) {
//                _error.value = "Token no encontrado"
//                _isLoading.value = false
//                return@launch
//            }
//
//            try {
//                // Preparar el cuerpo de la solicitud
//                val requestBody = UserProfileRequest(userId = "12345") // Ajusta según lo esperado por la API
//
//                // Llamada a la API
//                val response: Response<UserProfile> = RetrofitInstance.apiService.getUserProfile(
//                    token = "Bearer $token",
//                    requestBody = requestBody
//                )
//
//                if (response.isSuccessful) {
//                    _user.value = response.body()
//                } else {
//                    _error.value = "Error: ${response.errorBody()?.string() ?: "Error desconocido"} (${response.code()})"
//                }
//            } catch (e: Exception) {
//                _error.value = "Error: ${e.localizedMessage}"
//            } finally {
//                _isLoading.value = false
//            }
//        }
//    }
}
