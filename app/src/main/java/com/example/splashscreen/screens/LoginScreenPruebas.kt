import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController


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
            Text(
                text = "Iniciar Sesión",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Email TextField
            TextField(
                value = viewModel.email,
                onValueChange = { viewModel.onEmailChanged(it) },
                label = { Text("Correo Electrónico") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Password TextField
            TextField(
                value = viewModel.password,
                onValueChange = { viewModel.onPasswordChanged(it) },
                label = { Text("Contraseña") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Login Button
            Button(
                onClick = {
                    viewModel.login(
                        onLoginSuccess = {
                            // Navegar a la pantalla principal
                            navController.navigate("HomeUsuario") {
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
                enabled = !viewModel.isLoading
            ) {
                if (viewModel.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                } else {
                    Text("Iniciar Sesión")
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

            // Register Link
            TextButton(
                onClick = {
                    navController.navigate("RegistrationPrueba")
                }
            ) {
                Text("¿No tienes cuenta? Regístrate")
            }
        }
    }
}

