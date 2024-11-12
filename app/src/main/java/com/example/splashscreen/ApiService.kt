package com.example.splashscreen

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// Define la interfaz del servicio API
interface ApiService {
    @GET("emprededor")
    suspend fun getEmprededor(): List<Entrepreneurs>

    companion object {
        private const val BASE_URL = "http://127.0.0.1:8000/api/Entrepreneurs/" // URL base del servicio

        private var apiService: ApiService? = null

        fun getInstance(): ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL) // Usa la URL base definida
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}
