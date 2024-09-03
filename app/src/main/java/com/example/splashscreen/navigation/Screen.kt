package com.example.splashscreen.navigation

enum class Screen { // Names to identify the screens
    LOGIN,
    HOME,
    DETAIL,
    REGISTER
}

// Objects to identify where navigate
sealed class NavigationItem(val route: String) {
    object Login: NavigationItem(Screen.LOGIN.name)
    object Home: NavigationItem(Screen.HOME.name)
    object Register: NavigationItem(Screen.REGISTER.name)
    object Detail: NavigationItem(Screen.DETAIL.name)
}