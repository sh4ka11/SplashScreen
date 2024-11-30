package com.example.splashscreen.navigation

import BusinessListView
//import WineEditAppApp
//import WineShopApp
import ai.codia.x.composeui.demo.HomePincipalScreen
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
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
import com.example.splashscreen.screens.Busquedaemprendeinver
import com.example.splashscreen.screens.Busquedaemprendeusuario
import com.example.splashscreen.screens.Busquedaemprendeusuario
import com.example.splashscreen.screens.ChatInverScreen
import com.example.splashscreen.screens.ChatScreen
import com.example.splashscreen.screens.ChatUsu2
import com.example.splashscreen.screens.EmprendeInversorMainView
//import com.example.splashscreen.screens.ConfirmationCodeScreen
import com.example.splashscreen.screens.HomeInversorScreen
import com.example.splashscreen.screens.HomeScreen
import com.example.splashscreen.screens.InformacionCredencialScreen
import com.example.splashscreen.screens.InformacionObligatoriaScreen
import com.example.splashscreen.screens.ListaEmprendimientosInver
import com.example.splashscreen.screens.LoginInversor
import com.example.splashscreen.screens.LoginScreen
import com.example.splashscreen.screens.LoginUser
import com.example.splashscreen.screens.NavigationRoutes
import com.example.splashscreen.screens.Notificaciones2Inver
import com.example.splashscreen.screens.Notificaciones2Usu
import com.example.splashscreen.screens.NotificacionesInver
//import com.example.splashscreen.screens.PersonalProfileEditScreen
import com.example.splashscreen.screens.NotificacionesUsu
import com.example.splashscreen.screens.PersonalProfileEditScreen
//import com.example.splashscreen.screens.PersonalProfileEditScreen
import com.example.splashscreen.screens.ProfileEditScreen
import com.example.splashscreen.screens.ProfileScreen
import com.example.splashscreen.screens.PublicarEmprendimientoView
import com.example.splashscreen.screens.RegisterInversor
import com.example.splashscreen.screens.RegisterPhoneView
import com.example.splashscreen.screens.UserAdditionalInfoScreen
import com.example.splashscreen.screens.UserProfileMainView
import com.example.splashscreen.screens.UserRegistrationCorreo
import com.example.splashscreen.screens.UserRegistrationScreen
import com.example.splashscreen.screens.VinotecaEcstasyApp
import com.example.splashsreen.screens.Contactanosh
import com.example.splasscreen.screens.ConfirmationCodeScreen
//import com.example.splashsreen.screens.Busquedaemprendeusuario
import com.example.splashsreen.screens.Contactanosh
import com.example.splashsreen.screens.Contactanosinver
import com.example.splasscreen.screens.ConfirmationCodeScreen
import com.example.splasscreen.screens.verificarcorreo

@Composable
fun AppNavHost() {
//Lago



    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HOMEPRINCIPAL.name) {

        //emprendedor menu

        composable("user_profile_main_view") {
            UserProfileMainView(navController = navController)
        }
        composable("HomePrincipal") {
            HomeScreen(navController = navController)
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


        //inversor menu
        composable("HomePrincipalInver") {
            HomeInversorScreen(navController = navController)
        }
        composable("user_profile_main_viewInver") {
            ProfileScreen(navController = navController)
        }
        composable("busquedaInver") {
            Busquedaemprendeinver(navController = navController)
        }
        composable("Lista de emprendimientosInver") {
            ListaEmprendimientosInver(navController = navController)
        }
        composable("NotificacionesInver") {
            NotificacionesInver(navController = navController)
        }
        composable("chatInver") {
            ChatInverScreen(navController = navController)
        }
        composable("cerrar cesion") {
            HomePincipalScreen(navController = navController)
        }
        composable("ayudaInver") {
            Contactanosinver(navController = navController)
        }

        // rutas k
        composable(AppScreens.ChatScreen.route) {
            ChatScreen(navController)
        }
        composable(AppScreens.ChatUsu2.route) {
            ChatUsu2(navController)
        }

        composable(AppScreens.NotificacionesUsu.route) {
            NotificacionesUsu(navController)
        }
        composable(AppScreens.Notificaciones2Usu.route) {
            Notificaciones2Usu(navController)
        }

        composable(AppScreens.ConfirmationCodeScreen.route) {
            ConfirmationCodeScreen(navController)
        }
        composable(AppScreens.HomeInversorScreen.route) {
            HomeInversorScreen(navController)
        }

        composable(AppScreens.NotificacionesInver.route) {
            NotificacionesInver(navController)
        }
        composable(AppScreens.Notificaciones2Inver.route) {
            Notificaciones2Inver(navController)
        }
        ////WineShopApp PublicarEmprendimientoView
        composable(AppScreens.HomeScreen.route) {
            HomeScreen(navController)
        }

        composable(AppScreens.PublicarEmprendimientoView.route) {
            PublicarEmprendimientoView(navController)
        }
        composable(AppScreens.WineShopApp.route) {
            WineShopApp(navController)
        }
        composable(AppScreens.HomeScreen.route) {
            HomeScreen(navController)
        }

        composable(AppScreens.UserProfileMainView.route) {
            UserProfileMainView(navController)
        }

        composable(AppScreens.PersonalProfileEditScreen.route) {
            PersonalProfileEditScreen(navController)
        }

        composable(AppScreens.ConfirmationCodeScreen.route) {
            ConfirmationCodeScreen(navController)
        }
        composable(AppScreens.InformacionObligatoriaScreen.route) {
            InformacionObligatoriaScreen(navController)
        }

        composable(AppScreens.EmprendeInversorMainView.route) {
            EmprendeInversorMainView(navController)
        }
        composable(AppScreens.ProfileScreen.route) {
            ProfileScreen(navController)
        }
        composable(AppScreens.ProfileEditScreen.route) {
            ProfileEditScreen(navController)
        }



        //Rutas Sebas coecciones

        composable(AppScreens.Olvidarcorr.route) {
            Olvidarcorr(navController)
        }

        composable(AppScreens.Olvidar3.route) {
            Olvidar3(navController)
        }




        composable(AppScreens.Busquedaemprendeusuario.route){
            Busquedaemprendeusuario(navController)
        }
        composable(AppScreens.WineShopApp.route){
            WineShopApp(navController)
        }


        composable(AppScreens.Busquedaemprendeinver.route) {
            Busquedaemprendeinver(navController)
        }

        composable(AppScreens.VinotecaEcstasyApp.route) {
            VinotecaEcstasyApp(navController)
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



            composable("visitar_emprendimiento_inversionista") {
                VinotecaEcstasyApp(navController = navController)
            }

            composable("ingrese_correo_usuario") {
                Olvidarcorr(navController = navController)
            }
        // Add this if not already defined



//        composable("profileEdit") { PersonalProfileEditScreen() } // Aquí navegas a la vista de edición
//
//            composable("Mi Perfil") { HomeInversorScreen(navController) }
//           composable("UserProfileMainView") { UserProfileMainView(navController) }
//            composable("busquedadeEmpredimientos") { Busquedaemprendeusuario(navController) }
//           composable(" Miemprendimientos") { WineShopApp(navController) }
//        composable("publicarempredimiento") { PublicarEmprendimientoView(navController = navController) }
//        composable("notificaciones") { NotificacionesUsu(navController) }
//           composable("chat") { ChatScreen(navController) }
            //  composable("ayuda") { Contactanosh(navController) }


//        composable("notificacionesusu") {
//            Notificaciones2Usu(navController = navController)
//        }

        }

    }


