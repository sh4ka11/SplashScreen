import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.splashscreen.R
import com.example.splashscreen.navigation.NavigationItem
import com.example.splashscreen.screens.UserRegistrationCorreo

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = viewModel()
) {
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo Emprende Link",
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "¡BIENVENIDO!",
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Email TextField
            OutlinedTextField(
                value = viewModel.email,
                onValueChange = { viewModel.onEmailChanged(it) },
                label = { Text("Correo Electrónico") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password TextField
            OutlinedTextField(
                value = viewModel.password,
                onValueChange = { viewModel.onPasswordChanged(it) },
                label = { Text("Contraseña") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "¿Olvidaste tu contraseña?",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Login Button
            Button(
                onClick = {
                    viewModel.login(
                        onLoginSuccess = {
                            // Navegar a la pantalla principal
                            navController.navigate(NavigationItem.HomeUsuarios.route) {
                                popUpTo("LoginPrueba") { inclusive = true }
                            }
                        },
                        onLoginFailure = { errorMessage ->
                            // Mostrar mensaje de error
                            viewModel.loginError = errorMessage
                        }
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = !viewModel.isLoading,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                if (viewModel.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                } else {
                    Text("Iniciar Sesión", color = Color.White)
                }
            }

            // Error Handling
            viewModel.loginError?.let { error ->
                LaunchedEffect(error) {
                    snackbarHostState.showSnackbar(
                        message = error,
                        duration = SnackbarDuration.Short
                    )
                    viewModel.loginError = null
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Register Button
            Button(
                onClick = {
                    navController.navigate("UserRegistrationCorreo")
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Text("Registrarse", color = Color.White)
            }
        }
    }
}