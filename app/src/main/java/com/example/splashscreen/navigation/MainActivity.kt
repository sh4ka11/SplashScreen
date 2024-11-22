package com.example.splashscreen.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.screens.UserProfileMainView
import com.example.splashscreen.screens.ProfileEditScreen
import com.example.splashscreen.ui.theme.SplashScreenTheme
import com.example.splashscreen.data.UserProfile
import com.example.splashscreen.home.HomeScreennk
import com.example.splashscreen.navigation.AppNavHost
import com.example.splashscreen.navigation.TopBar
import androidx.compose.material3.TopAppBarState
import androidx.compose.material3.rememberTopAppBarState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreenTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {

                    AppNavHost()

//                    val scaffoldState = rememberScaffoldState()
//                    Scaffold (
//                        scaffoldState = scaffoldState,
//                        topBar={
//                            TopBar {
//                                scaffoldState.drawerState.open()
//                            }
//                        }
//                    ){
//
//                    }
//                    HomeScreennk()
//
//

                }
            }
        }
    }
}