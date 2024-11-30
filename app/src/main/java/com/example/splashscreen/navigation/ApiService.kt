package com.example.splashscreen.navigation

import Entrepreneurs
import com.example.splashscreen.data.LoginRequest
import com.example.splashscreen.data.LoginResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

//
//interface ApiService {
//    @GET("emprededor")
//    suspend fun getEmprededor(): List<Entrepreneurs>
//
//    companion object {
//        private const val BASE_URL =
//            "http://127.0.0.1:8000/api/Entrepreneurs/" // URL base del servicio
//
//        private var apiService: ApiService? = null
//
//        fun getInstance(): ApiService {
//            if (apiService == null) {
//                apiService = Retrofit.Builder()
//                    .baseUrl(BASE_URL) // Usa la URL base definida
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//                    .create(ApiService::class.java)
//            }
//            return apiService!!
//        }
//    }
//}
//    @GET("LoginUser")
//    suspend fun getEmprededor(): List<LoginUsers>
//
//    companion object {
//        private const val BASE_URL = "http://127.0.0.1:8000/api/Entrepreneurs/" // URL base del servicio
//
//        private var apiService: ApiService? = null
//
//        fun getInstance(): ApiService {
//            if (apiService == null) {
//                apiService = Retrofit.Builder()
//                    .baseUrl(BASE_URL) // Usa la URL base definida
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//                    .create(ApiService::class.java)
//            }
//            return apiService!!
//        }
//    }
//
//}
//
//interface ApiaService {
//    @POST("api/login")
//    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse
//}
//
//class LoginRepository {
//    private val baseUrl = "http://tu-dominio.com/"
//
//    private val retrofit = Retrofit.Builder()
//        .baseUrl(baseUrl)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//    private val apiService = retrofit.create(ApiService::class.java)
//
//    suspend fun login(email: String, password: String): Result<LoginResponse> {
//        return try {
//            val response = apiService.login(LoginRequest(email, password))
//            Result.success(response)
//        } catch (e: Exception) {
//            Result.failure(e)
//        }
//    }
//}
