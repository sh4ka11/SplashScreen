package com.example.splashscreen.navigation



sealed class AppScreens(val route: String) {
     object Olvidar3 : AppScreens("Olvidar3")
     object Olvidarcorr : AppScreens("Olvidarcorr")
     object Busquedaemprendeusuario : AppScreens("Busquedaemprendeusuario")
     object WineShopApp :AppScreens("WineShopApp")

     object HomePincipalScreen :AppScreens("HomePincipalScreen")

}
