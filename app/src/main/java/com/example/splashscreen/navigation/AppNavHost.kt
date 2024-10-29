package com.example.splashscreen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.screens.BusquedaemprendeinverScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "HomePrincipal") {
        composable("HomePrincipal") {
            // Pantalla HomePrincipal
        }
        composable("registroUsuarioTelefono") {
            // Pantalla de registro por teléfono
        }
        composable("registroUsuarioCorreo") {
            // Pantalla de registro por correo
        }
        composable("registroUsuarioCorreo") {

        }

        composable("PublicarEmprendimientoView") {

        }
    }
}
