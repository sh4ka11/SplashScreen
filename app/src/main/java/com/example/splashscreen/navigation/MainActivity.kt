import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.screens.UserProfileMainView
import com.example.splashscreen.screens.ProfileEditScreen
import com.example.splashscreen.ui.theme.SplashScreenTheme
import com.example.splashscreen.screens.DetailScreen
import com.example.splashscreen.data.Movie
import com.example.splashscreen.screens.CodiaMainView
import com.example.splashscreen.screens.ProfileEditScreen1
import com.example.splashscreen.screens.UserProfileMainView // Cambié CodiaMainView a UserProfileMainView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreenTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {

                    // Inicializa el NavController
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "userProfileMain"
                    ) {
                        composable("userProfileMain") {
                            UserProfileMainView(
                                navController = navController,
                                onMenuClick = { /* Manejo del menú */ }
                            )
                        }

                        composable("profileEdit") {
                            ProfileEditScreen(
                                onMenuClick = { /* Manejo del menú */ },
                                onUpdateProfile = {
                                    // Aquí puedes agregar la lógica para actualizar el perfil
                                    navController.navigateUp() // Regresa a la pantalla anterior
                                }
                            )
                        }
                    }
                }
            }
                    }


                    // Crear un NavHostController y pasar a AppNavHost
                    AppNavHost(navController = rememberNavController())



                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SplashScreenTheme {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            // Aquí puedes hacer una vista previa de UserProfileMainView
            UserProfileMainView()  // Cambié CodiaMainView a UserProfileMainView
        }
    }
}


