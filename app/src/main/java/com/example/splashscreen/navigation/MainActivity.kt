import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
<<<<<<< HEAD
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
=======
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
>>>>>>> def3438a81f11240284257d0a4f8886be23952a6
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.R
import com.example.splashscreen.ui.theme.SplashScreenTheme
import com.example.splashscreen.screens.DetailScreen
import com.example.splashscreen.data.Movie
import com.example.splashscreen.screens.CodiaMainView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreenTheme {
                // Contenedor de superficie utilizando el color de fondo del tema
                Surface(
                    modifier = Modifier.fillMaxSize(),

                ) {
<<<<<<< HEAD
                    // Inicializa el NavController
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "codiaMain" // Pantalla inicial
                    ) {
                        composable("codiaMain") {
                            // Asegúrate de que CodiaMainView reciba el navController si es necesario

                        }
                        composable("detalles") {
                            DetailScreen(
                                movie = Movie(name = "Deadpool 3", drawable = R.drawable.deadpool3),
                                navController = navController
                            )
                        }
                    }
=======

                    // Crear un NavHostController y pasar a AppNavHost
                    AppNavHost(navController = rememberNavController())
>>>>>>> def3438a81f11240284257d0a4f8886be23952a6
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
            // Aquí puedes hacer una vista previa de tu CodiaMainView

        }
    }
}
