package com.example.splashscreen.navigation
enum class Screen {
    LOGIN,
    HOMEUSUARIO,
    DETAIL,
    REGISTER,
    HOMEPRINCIPAL,
    MYPROFILE,
    SEARCHFORENTREPRENEURSHIP,
    ABOUT,
    MYENTREPRENEURSHIP,
    NOTIFICATIONS,
    CHAT,
    LOGOUT,
    EDITAREMPREDIMIENTO,
    USERPROFILE
}

// NavigationItem.kt
sealed class NavigationItem(val route: String) {
    object Login: NavigationItem(Screen.LOGIN.name)
    object HomeUsuarios: NavigationItem(Screen.HOMEUSUARIO.name)
    object Register: NavigationItem(Screen.REGISTER.name)
    object Detail: NavigationItem(Screen.DETAIL.name)
    object HomePrincipal: NavigationItem(Screen.HOMEPRINCIPAL.name)
    object EditarEmpredimiento: NavigationItem(Screen.EDITAREMPREDIMIENTO.name)
    object MyProfile: NavigationItem(Screen.MYPROFILE.name)
    object SearchForEntrepreneurship: NavigationItem(Screen.SEARCHFORENTREPRENEURSHIP.name)
    object About: NavigationItem(Screen.ABOUT.name)
    object MyEntrepreneurship: NavigationItem(Screen.MYENTREPRENEURSHIP.name)
    object Notifications: NavigationItem(Screen.NOTIFICATIONS.name)
    object Chat: NavigationItem(Screen.CHAT.name)
    object Logout: NavigationItem(Screen.LOGOUT.name)
}