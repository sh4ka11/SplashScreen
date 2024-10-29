package com.example.splashscreen.navigation

import WineEditAppApp
import WineShopApp
import ai.codia.x.composeui.demo.HomePincipalScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.splashscreen.R
import com.example.splashscreen.data.Movie
import com.example.splashscreen.screens.ConfirmationCodeScreen
import com.example.splashscreen.screens.HomeScreen
import com.example.splashscreen.screens.InformacionCredencialScreen
import com.example.splashscreen.screens.InformacionObligatoriaScreen
import com.example.splashscreen.screens.LoginInversor
import com.example.splashscreen.screens.LoginScreen
import com.example.splashscreen.screens.LoginUser
import com.example.splashscreen.screens.NavigationRoutes
import com.example.splashscreen.screens.Notificaciones2Usu
//import com.example.splashscreen.screens.PersonalProfileEditScreen
import com.example.splashscreen.screens.NotificacionesUsu
import com.example.splashscreen.screens.PersonalProfileEditScreen
//import com.example.splashscreen.screens.PersonalProfileEditScreen
import com.example.splashscreen.screens.ProfileEditScreen
import com.example.splashscreen.screens.RegisterInversor
import com.example.splashscreen.screens.RegisterPhoneView
import com.example.splashscreen.screens.UserAdditionalInfoScreen
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
        composable("HomeUsuario"){
            HomeScreen(navController = navController)
        }


        composable("registroUsuarioTelefono"){
            UserRegistrationScreen(navController = navController)
        }
        composable("registroUsuarioCorreo"){
            UserRegistrationCorreo(navController = navController)
        }
        composable("RegistroDatosUsuario"){
            UserAdditionalInfoScreen(navController = navController)
        }


        composable("MirarEmpredimientoUsuario"){
            WineShopApp(navController = navController)
        }
        composable("EditarEmpredimientoUsuario"){
            WineEditAppApp(navController = navController)
        }


        composable("loginUsuario"){
            LoginUser(navController = navController)
        }
        composable("loginInversinista"){
            UserRegistrationCorreo(navController = navController)
        }
        composable("login_inversor") {
            LoginInversor() // Esta es la vista de destino
        }
        composable("register_inversor") {
            RegisterInversor(navController = navController)
        }
        composable("register_phone") {
            RegisterPhoneView(navController = navController)
        }
        composable("confirmation_code") {
            ConfirmationCodeScreen(navController = navController) // Asegúrate de que esta es tu pantalla
        }
        composable("informacion_obligatoria") {
            InformacionObligatoriaScreen(navController = navController) // Asegúrate de que esta es tu pantalla
        }
        composable("informacion_credencial") { InformacionCredencialScreen() }


        composable("profileEdit") { PersonalProfileEditScreen() } // Aquí navegas a la vista de edición








        composable("notificacionesusu") {
            Notificaciones2Usu(navController = navController)
        }
    }
}