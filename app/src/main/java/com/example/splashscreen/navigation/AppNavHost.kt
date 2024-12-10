package com.example.splashscreen.navigation

import BusinessListView
import LoginScreen
import UserProfileScreen
import UserRegistrationScreen
//import WineEditAppApp
//import WineShopApp
import ai.codia.x.composeui.demo.HomePincipalScreen
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.screens.Busquedaemprendeinver
import com.example.splashscreen.screens.Busquedaemprendeusuario

import com.example.splashscreen.screens.EmprendeInversorMainView
//import com.example.splashscreen.screens.ConfirmationCodeScreen
import com.example.splashscreen.screens.HomeInversorScreen
import com.example.splashscreen.screens.HomeScreen
import com.example.splashscreen.screens.InformacionCredencialScreen
import com.example.splashscreen.screens.InformacionObligatoriaScreen
import com.example.splashscreen.screens.ListaEmprendimientosInver
import com.example.splashscreen.screens.LoginInversor
//import com.example.splashscreen.screens.LoginScreen
//import com.example.splashscreen.screens.LoginUser
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
import com.example.splashscreen.screens.UserAdditionalInfoScreen
import com.example.splashscreen.screens.UserProfileMainView
import com.example.splashscreen.screens.UserRegistrationCorreo
import com.example.splashscreen.screens.VinotecaEcstasyApp
import com.example.splashscreen.screens.user_registration_codeve_correo
import com.example.splashsreen.screens.Contactanosh
import com.example.splasscreen.screens.ConfirmationCodeScreen
//import com.example.splashsreen.screens.Busquedaemprendeusuario
import com.example.splashsreen.screens.Contactanosinver

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavHost() {
//Lago

//    Screen.LoginPrueba.name


    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HOMEPRINCIPAL.name) {

        composable("LoginPrueba") {
            LoginScreen(
                navController = navController,
                context = LocalContext.current  // Agrega esta línea
            )
        }

        composable("RegistrationPrueba") {
            UserRegistrationScreen(navController = navController)
        }
        composable("registroPrueba") {
            UserRegistrationScreen(navController = navController)
        }

        composable("userPerfil") {
            UserProfileScreen(navController = navController)
        }

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

        composable("cerrar cesion") {
            HomePincipalScreen(navController = navController)
        }
        composable("ayuda") {
            Contactanosh(navController = navController)
        }


        //inversor menu

        composable("my_perfil_Inver") {
            ProfileScreen(navController = navController)
        }
        composable("HomeInver") {
            HomeInversorScreen(navController = navController)
        }
        composable("busquedaInver") {
            Busquedaemprendeinver(navController = navController)
        }
        composable("Lista_de_emprendimientosInver") {
            ListaEmprendimientosInver(navController = navController)
        }
        composable("NotificacionesInver") {
            NotificacionesInver(navController = navController)
        }

        composable("cerrar_cesion") {
            HomePincipalScreen(navController = navController)
        }
        composable("ayudaInver") {
            Contactanosinver(navController = navController)
        }

        // rutas k



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
        //eror miguel
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
        composable(AppScreens.UserRegistrationCorreo.route) {
            UserRegistrationCorreo(navController)
        }
        composable(AppScreens.user_registration_codeve_correo.route) {
            user_registration_codeve_correo(navController)
        }
        composable(AppScreens.UserAdditionalInfoScreen.route) {
            UserAdditionalInfoScreen(navController)
        }







        composable(AppScreens.BusinessListView.route) {
            BusinessListView(navController)
        }
//        composable(AppScreens.WineShopApp.route) {
//            WineShopApp(navController)
//        }

//        composable(AppScreens.verificarcorreo.route) {
//            verificarcorreo(navController)
//        }
        composable(AppScreens.ListaEmprendimientosInver.route) {
            ListaEmprendimientosInver(navController)
        }


        composable(AppScreens.ListaEmprendimientosInver.route) {
            ListaEmprendimientosInver(navController)
        }
        composable(AppScreens.VinotecaEcstasyApp.route) {
            VinotecaEcstasyApp(navController)
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

//        composable("registroUsuarioTelefono") {
//            UserRegistrationScreen(navController = navController)
//        }
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
//            LoginUser(navController = navController)
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

