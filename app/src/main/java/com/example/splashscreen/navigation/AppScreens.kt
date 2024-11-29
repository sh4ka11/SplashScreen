package com.example.splashscreen.navigation



sealed class AppScreens(val route: String) {

     object WineShopApp :AppScreens("WineShopApp")
     object Busquedaemprendeusuario :AppScreens("Busquedaemprendeusuario")

     object Olvidar3 :AppScreens("Olvidar3")
     object Olvidarcorr :AppScreens("Olvidarcorr")




     object Busquedaemprendeinver :AppScreens("Busquedaemprendeinver")
     object VinotecaEcstasyApp :AppScreens("VinotecaEcstasyApp")



     object HomePincipalScreen :AppScreens("HomePincipalScreen")

}
