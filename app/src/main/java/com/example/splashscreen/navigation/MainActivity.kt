package com.example.splashscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.screens.UserProfileMainView
import com.example.splashscreen.screens.ProfileEditScreen
import com.example.splashscreen.ui.theme.SplashScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreenTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "userProfileMain"
                    ) {
                        composable("userProfileMain") {
                            UserProfileMainView(
                                navController = navController,
                                onMenuClick = { /* Manejo del menú */ }
                            )
                        }

                        composable("profileEdit") {
                            ProfileEditScreen(
                                onMenuClick = { /* Manejo del menú */ },
                                onUpdateProfile = {
                                    // Aquí puedes agregar la lógica para actualizar el perfil
                                    navController.navigateUp() // Regresa a la pantalla anterior
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}