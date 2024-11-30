//package com.example.splashscreen.data
//
//import com.google.gson.GsonBuilder
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.http.Body
//import retrofit2.http.POST
//import java.util.concurrent.TimeUnit
//
//
//
//class UserApi {
//
//    interface AuthApiService {
//        @POST("auth")
//        suspend fun getLogin(@Body loginDto: DataTransfer.LoginDto): retrofit2.Response<DataTransfer.TokenDto>
//    }
//
//    object RetrofitHelper {
//        private val retrofit: Retrofit
//
//        init {
//              val BASE_URL = "https://apiemprendelink-production-9272.up.railway.app/api/auth/register"
//
//            // Configuración del formato de fecha en Gson
//            val gson = GsonBuilder()
//                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
//                .create()
//
//            // Configuración de interceptor para logging
//            val loggingInterceptor = HttpLoggingInterceptor().apply {
//                level = HttpLoggingInterceptor.Level.BODY
//            }
//
//            // Configuración de OkHttpClient
//            val okHttpClient = OkHttpClient.Builder()
//                .addInterceptor(loggingInterceptor)
//                .readTimeout(2, TimeUnit.MINUTES)
//                .writeTimeout(2, TimeUnit.MINUTES)
//                .connectTimeout(1, TimeUnit.MINUTES)
//                .build()
//
//            // Configuración de Retrofit
//            retrofit = Retrofit.Builder()
//                .baseUrl(BASE_URL) // Asegúrate de que `BuildConfig.API_BASE_URL` esté definido
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .client(okHttpClient)
//                .build()
//        }
//
//        // Proveedor del servicio AuthApiService
//        fun getAuthService(): AuthApiService {
//            return retrofit.create(AuthApiService::class.java)
//        }
//    }
//}
