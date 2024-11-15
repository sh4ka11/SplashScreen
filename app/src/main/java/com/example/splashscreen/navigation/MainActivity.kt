package com.example.splashscreen.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.splashscreen.ui.theme.SplashScreenTheme
import com.example.splashscreen.navigation.AppNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val viewModel: EmprendedorViewModel by viewModels   ()
        setContent {
            SplashScreenTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {

                    AppNavHost()
//                EmprendedorScreen(viewModel)

                }
            }
        }
    }
}