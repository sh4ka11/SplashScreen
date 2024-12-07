import com.example.splashscreen.data.model.LoginRequest
import com.example.splashscreen.data.model.LoginResponse
import com.example.splashscreen.data.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    // Duplicate interface nested inside

//    @POST("login")  // One login method
//        suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("/api/auth/login")  // Another login method
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("/api/auth/register")
    suspend fun registerUser(@Body user: User): Response<Void>



}