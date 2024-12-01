package com.example.splashscreen.navigation



sealed class AppScreens(val route: String) {

    object WineShopApp : AppScreens("WineShopApp")
    object Busquedaemprendeusuario : AppScreens("Busquedaemprendeusuario")

    object Olvidar3 : AppScreens("Olvidar3")
    object Olvidarcorr : AppScreens("Olvidarcorr")

    object Busquedaemprendeinver : AppScreens("Busquedaemprendeinver")
    object VinotecaEcstasyApp : AppScreens("VinotecaEcstasyApp")


    object HomePincipalScreen : AppScreens("HomePincipalScreen")

    // k
    object ChatScreen : AppScreens("ChatScreen")
    object ChatUsu2 : AppScreens("ChatUsu2")

    object NotificacionesUsu : AppScreens("NotificacionesUsu")
    object Notificaciones2Usu : AppScreens("Notificaciones2Usu")

    object ConfirmationCodeScreen : AppScreens("ConfirmationCodeScreen")
    object HomeInversorScreen : AppScreens("HomeInversorScreen")


    object NotificacionesInver : AppScreens("NotificacionesInver")
    object Notificaciones2Inver : AppScreens("Notificaciones2Inver")

    object HomeScreen : AppScreens("HomeScreen")
    object PublicarEmprendimientoView : AppScreens("PublicarEmprendimientoView")

    object UserProfileMainView : AppScreens("UserProfileMainView")
    object PersonalProfileEditScreen : AppScreens("PersonalProfileEditScreen")

    object InformacionObligatoriaScreen : AppScreens("informacionobligatoriascreen")


     object EmprendeInversorMainView :AppScreens("EmprendeInversorMainView")
     object ProfileScreen :AppScreens("ProfileScreen")

     object ProfileEditScreen :AppScreens("ProfileEditScreen")
//
//     object ConfirmationCodeScreen :AppScreens("ConfirmationCodeScreen")
//     object HomeInversorScreen :AppScreens("HomeInversorScreen")
//
//     object ConfirmationCodeScreen :AppScreens("ConfirmationCodeScreen")
//     object HomeInversorScreen :AppScreens("HomeInversorScreen")



//     object NotificacionesInver :AppScreens("NotificacionesInver")
//     object Notificaciones2Inver :AppScreens("Notificaciones2Inver")
//
//     object NotificacionesInver :AppScreens("NotificacionesInver")
//     object Notificaciones2Inver :AppScreens("Notificaciones2Inver")
//
//     object NotificacionesInver :AppScreens("NotificacionesInver")
//     object Notificaciones2Inver :AppScreens("Notificaciones2Inver")



     object BusinessListView :AppScreens("BusinessListView")
     //object WineShopApp :AppScreens("WineShopApp")

//     object HomeInversorScreen :AppScreens("HomeInversorScreen")
     object ListaEmprendimientosInver :AppScreens("ListaEmprendimientosInver")


//     object ListaEmprendimientosInver :AppScreens("ListaEmprendimientosInver")
//     object VinotecaEcstasyApp :AppScreens("VinotecaEcstasyApp")



}
