package com.example.splashscreen.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.splashscreen.R
import com.example.splashscreen.data.Movie

import com.example.splashscreen.screens.HomeScreen
import com.example.splashscreen.screens.LoginScreen
import com.example.splashscreen.screens.PersonalProfileEditScreen
import com.example.splashscreen.screens.ProfileEditScreen
import com.example.splashscreen.screens.UserProfileMainView

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Login.route
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        // Login Screen
        composable(NavigationItem.Login.route) {
            LoginScreen(navController)
        }

//        z

        // User Profile Screens
        composable("userProfileMain") {
            UserProfileMainView(
                navController = navController,
                onMenuClick = { /* acción de menú aquí */ }
            )
        }

        // Personal Profile Edit Screen kevin
        composable("personal_profile_edit") {
            PersonalProfileEditScreen(
                onMenuClick = { /* acción de menú aquí */ },
                onUpdateProfile = {
                    navController.navigateUp()
                }
            )
        }

        // Profile Edit Screen (existing)
        composable("profileEdit") {
            ProfileEditScreen(
                onMenuClick = { /* acción de menú aquí */ },
                onUpdateProfile = {
                    navController.navigateUp()
                }
            )
        }

        composable("Menu de Home") {
            ProfileEditScreen(
                onMenuClick = { /* acción de menú aquí */ },
                onUpdateProfile = {
                    navController.navigateUp()
                }
            )
        }
    }
}


//
//        composable(Screen.Catalog.route) {
//            CatalogScreen(navController = navController)
//        }
//        composable(Screen.Contact.route) {
//            ContactScreen(navController = navController)
//        }
//        composable(Screen.About.route) {
//            AboutScreen(navController = navController)
//        }






