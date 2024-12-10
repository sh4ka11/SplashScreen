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
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class UserProfileViewModel(private val context: Context
) : ViewModel() {

    // State variables for user profile
    var userProfile by mutableStateOf<UserProfile?>(null)
    var isLoading by mutableStateOf(false)
    var errorMessage by mutableStateOf<String?>(null)

    // Function to fetch user profile
    fun fetchUserProfile() {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null

            try {
                // Get the stored token
                val token = getToken().first()

                if (token.isNullOrBlank()) {
                    errorMessage = "No authentication token found"
                    return@launch
                }

                // Prepare the request body (if required by your API)

                // Make API call to get user profile
                val response = RetrofitInstance.apiService.getUserInfo(
                    token = "Bearer $token"
                )

//                if (response.isSuccessful) {
//                    userProfile = response.body()
//                } else {
//                    errorMessage = "Failed to fetch profile: ${response.code()}"
//                    Log.e("UserProfileViewModel", "Error: ${response.errorBody()?.string()}")
//                }
            } catch (e: Exception) {
                errorMessage = "Network error: ${e.localizedMessage}"
                Log.e("UserProfileViewModel", "Exception in fetchUserProfile", e)
            } finally {
                isLoading = false
            }
        }
    }
    private fun getToken() :
        Flow<String?> = context.dataStore.data.map { preferences ->
        val token = preferences[ACCESS_TOKEN_KEY]
        val tokenTimestamp = preferences[TOKEN_TIMESTAMP_KEY] ?: 0

        val TOKEN_EXPIRATION = 30 * 24 * 60 * 60 * 1000L
        if (token != null && (System.currentTimeMillis() - tokenTimestamp) < TOKEN_EXPIRATION) {
            token
        } else {
            null
        }
        }

    // Optional: Function to refresh profile
    fun refreshProfile() {
        fetchUserProfile()
    }
}