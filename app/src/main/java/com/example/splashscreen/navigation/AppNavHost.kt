import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.splashscreen.R
import com.example.splashscreen.data.Movie
import com.example.splashscreen.navigation.NavigationItem
import com.example.splashscreen.screens.DetailScreen
import com.example.splashscreen.screens.HomePrincipalScreen
import com.example.splashscreen.screens.HomeScreen
import com.example.splashscreen.screens.LoginScreen
import com.example.splashscreen.screens.RegistrationScreen


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier, // El modificador que se aplicará al diseño
    navController: NavHostController, // El navController para este host
    startDestination: String = NavigationItem.HomePrincipal.route // Ruta de inicio
) {
    NavHost( // Proporciona en la jerarquía de Compose un lugar donde puede ocurrir la navegación contenida por sí misma.
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {

        composable( // Este método añade el composable al NavGraphBuilder
            route = NavigationItem.HomePrincipal.route // Ruta para el destino
        ) {
            HomePrincipalScreen(navController) // Composable para el destino
        }

        composable( // Este método añade el composable al NavGraphBuilder
            route = NavigationItem.Login.route // Ruta para el destino
        ) {
            LoginScreen(navController) // Composable para el destino
        }

        composable( // Este método añade el composable al NavGraphBuilder
            route = NavigationItem.Home.route // Ruta para el destino
        ) {
            HomeScreen(navController) // Composable para el destino
        }
        composable(
            route = NavigationItem.Register.route // Ruta para el destino
        ) {
            RegistrationScreen(navController) // Composable para el destino
        }

        composable( // Este método añade el composable al NavGraphBuilder
            route = NavigationItem.Detail.route + "/{movieName}/{movieImage}", // Ruta para el destino que recibe 2 argumentos
            arguments = listOf( // Lista de argumentos pasados por la navegación
                navArgument(name = "movieName") {defaultValue = ""; type = NavType.StringType},
                navArgument(name = "movieImage") {defaultValue = R.drawable.no_image_available; type = NavType.ReferenceType}
            )
        ) {
            val image = it.arguments?.getInt("movieImage", R.drawable.no_image_available) ?: R.drawable.no_image_available // Obtener la imagen por argumento
            val name = it.arguments?.getString("movieName", "") ?: "" // Obtener el nombre por argumento

            // Crear un nuevo objeto de película
            val movie = Movie(image, name)

            DetailScreen(movie = movie, navController) // Composable para el destino, este composable recibe un objeto de película
        }
    }
}

