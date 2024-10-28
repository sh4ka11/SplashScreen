package com.example.splashscreen.navigation

import WineEditAppApp
import ai.codia.x.composeui.demo.HomePincipalScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.splashscreen.R
import com.example.splashscreen.data.Movie
import com.example.splashscreen.screens.HomeScreen
import com.example.splashscreen.screens.LoginScreen
import com.example.splashscreen.screens.NavigationRoutes
//import com.example.splashscreen.screens.PersonalProfileEditScreen
import com.example.splashscreen.screens.NotificacionesUsu
//import com.example.splashscreen.screens.PersonalProfileEditScreen
import com.example.splashscreen.screens.ProfileEditScreen
import com.example.splashscreen.screens.UserProfileMainView
import com.example.splashscreen.screens.UserRegistrationCorreo
import com.example.splashscreen.screens.UserRegistrationScreen

@Composable
fun AppNavHost(

) {
//Lago
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "HomePrincipal") {

        composable("HomePrincipal"){
            HomePincipalScreen(navController = navController)
        }
        composable("registroUsuarioTelefono"){
            UserRegistrationScreen(navController = navController)
        }
        composable("registroUsuarioCorreo"){
            UserRegistrationCorreo(navController = navController)
        }



    }
}