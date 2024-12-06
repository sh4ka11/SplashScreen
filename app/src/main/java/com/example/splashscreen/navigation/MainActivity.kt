package com.example.splashscreen.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
//import com.example.splashscreen.data.AuthViewModel
//import com.example.splashscreen.EmprendedorScreen
//import com.example.splashscreen.EmprendedorViewModel
import com.example.splashscreen.ui.theme.SplashScreenTheme
import com.example.splashscreen.navigation.AppNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            val viewModel = AuthViewModel()

            // Puedes alternar entre LoginScreen y RegisterScreen para probar
            AppNavHost()
            // O
            // RegisterScreen(viewModel = viewModel)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    SplashScreenTheme {
        AppNavHost()
    }
}