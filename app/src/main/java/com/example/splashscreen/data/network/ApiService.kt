import com.example.splashscreen.data.model.LoginRequest
import com.example.splashscreen.data.model.LoginResponse
import com.example.splashscreen.data.model.User
import com.example.splashscreen.data.model.UserProfile
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT

interface ApiService {
    // Duplicate interface nested inside

//    @POST("login")  // One login method
//        suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("/api/auth/login")  // Another login method
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("/api/auth/register")
    suspend fun registerUser(@Body user: User): Response<Void>

//    @POST("/api/auth/me")
//    suspend fun getUserrProfile(
//        @Header("Authorization") token: String,
//        @Body requestBody: UserProfileRequest
//    ): Response<UserProfile>




        @POST("api/auth/me")
        suspend fun getUserInfo(
            @Header("Authorization") token: String
        ): UserProfile

        @PUT("/update/") // Ajusta la ruta según tu API
        suspend fun updateUserProfile(
            @Header("Authorization") token: String,
            @Body userProfile: UserProfile
        ): UserProfile


}