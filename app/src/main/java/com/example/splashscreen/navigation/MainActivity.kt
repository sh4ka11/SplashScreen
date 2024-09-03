package com.example.splashscreen.navigation

import AppNavHost
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.ui.theme.SplashScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Invocar el splash screen antes de configurar el contenido
        installSplashScreen()
        setContent {
            SplashScreenTheme {
                // Un contenedor Surface utilizando el color 'background' del tema
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Crear un NavHostController y pasar a AppNavHost
                    AppNavHost(navController = rememberNavController())
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MoviesAppPreview() {
    SplashScreenTheme {
        // Crear un NavHostController para la vista previa
        AppNavHost(navController = rememberNavController())
    }
}
