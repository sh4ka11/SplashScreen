package com.example.splashscreen.navigation


import BusinessListView

import ai.codia.x.composeui.demo.HomePincipalScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.screens.Busquedaemprendeusuario
import com.example.splashscreen.screens.ChatScreen
import com.example.splashscreen.screens.HomeInversorScreen
import com.example.splashscreen.screens.HomeScreen
import com.example.splashscreen.screens.InformacionCredencialScreen
import com.example.splashscreen.screens.InformacionObligatoriaScreen
import com.example.splashscreen.screens.LoginInversor
import com.example.splashscreen.screens.LoginUser
import com.example.splashscreen.screens.NotificacionesUsu
import com.example.splashscreen.screens.RegisterInversor
import com.example.splashscreen.screens.UserAdditionalInfoScreen
import com.example.splashscreen.screens.UserProfileMainView
import com.example.splashscreen.screens.UserRegistrationCorreo
import com.example.splashscreen.screens.UserRegistrationScreen
import com.example.splashsreen.screens.Contactanosh
import com.example.splasscreen.screens.ConfirmationCodeScreen


@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = AppScreens.HomePincipalScreen.route
    ) {

        composable(route = AppScreens.Olvidar3.route) {
            Olvidar3(navController)
        }

        composable(route = AppScreens.Olvidarcorr.route) {
            Olvidarcorr(navController)
        }

        composable(route = AppScreens.Busquedaemprendeusuario.route) {
            Busquedaemprendeusuario(navController)
        }

        composable(route = AppScreens.WineShopApp.route) {
            WineShopApp(navController)
        }

        composable(route = AppScreens.HomePincipalScreen.route) {
            HomePincipalScreen(navController)
        }


        composable("HomePrincipal") {
            HomePincipalScreen(navController = navController)
        }
        composable("user_profile_main_view") {
            UserProfileMainView(navController = navController)
        }
        composable("busqueda") {
            Busquedaemprendeusuario(navController = navController)
        }
        composable("Lista de emprendimientos") {
            BusinessListView(navController = navController)
        }
        composable("NotificacionesUsu") {
            NotificacionesUsu(navController = navController)
        }
        composable("chatUsu") {
            ChatScreen(navController = navController)
        }
        composable("cerrar cesion") {
            HomePincipalScreen(navController = navController)
        }
        composable("ayuda") {
            Contactanosh(navController = navController)
        }


        // Añadir rutas dummy para evitar errores al navegar a rutas inexistentes
        composable("redes_route") {
            // Pantalla para "Consultar redes" o mensaje de "En construcción"
        }
        composable("notificacionesUsu") {
            // Pantalla para "Notificaciones" o mensaje de "En construcción"
        }
        composable("chat_route") {
            // Pantalla para "Chat" o mensaje de "En construcción"
        }
        composable("cerrar_sesion_route") {
            // Implementación de cierre de sesión
        }
        composable("ayuda_route") {
            // Pantalla de ayuda o mensaje de "En construcción"
        }

        // Resto de tus rutas
        composable("HomeUsuario") {
            HomeScreen(navController = navController)
        }
        composable("HomeInversionista") {
            HomeInversorScreen(navController = navController)
        }

        composable("registroUsuarioTelefono") {
            UserRegistrationScreen(navController = navController)
        }
        composable("registroUsuarioCorreo") {
            UserRegistrationCorreo(navController = navController)
        }
        composable("RegistroDatosUsuario") {
            UserAdditionalInfoScreen(navController = navController)
        }
        composable("EditarEmpredimientoUsuario") {
            WineEditAppApp(navController = navController)
        }

        composable("loginUsuario") {
            LoginUser(navController = navController)
        }
        composable("loginInversinista") {
            UserRegistrationCorreo(navController = navController)
        }
        composable("login_inversor") {
            LoginInversor(navController = navController)
        }
        composable("register_inversor") {
            RegisterInversor(navController = navController)
        }

        composable("confirmation_code") {
            ConfirmationCodeScreen(navController = navController)
        }
        composable("informacion_obligatoria") {
            InformacionObligatoriaScreen(navController = navController)
        }
        composable("informacion_credencial") {
            InformacionCredencialScreen(navController = navController)
        }
        composable("informacion_credencial") { InformacionCredencialScreen(navController = navController) }

        //rutas ensayo
        composable(Screen.HOMEPRINCIPAL.name) {
            HomePincipalScreen(navController)
        }

        composable(Screen.NOTIFICATIONS.name) {
            NotificacionesUsu(navController)
        }

    }
}

