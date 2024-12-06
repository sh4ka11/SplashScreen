import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.splashscreen.viewmodel.RegistrationViewModel
//
//@Composable
//fun RegistrationScreenPrueba(
//    navController: NavController,
//    viewModel: RegistrationViewModel = viewModel()
//) {
//    val snackbarHostState = remember { SnackbarHostState() }
//
//    Scaffold(
//        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
//    ) { paddingValues ->
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(paddingValues)
//                .padding(16.dp)
//                .verticalScroll(rememberScrollState()),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(
//                text = "Registro de Usuario",
//                style = MaterialTheme.typography.headlineMedium,
//                modifier = Modifier.padding(bottom = 16.dp)
//            )
//
//            // Nombre
//            TextField(
//                value = viewModel.name,
//                onValueChange = { viewModel.onNameChanged(it) },
//                label = { Text("Nombre") },
//                modifier = Modifier.fillMaxWidth(),
//                singleLine = true
//            )
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            // Apellido
//            TextField(
//                value = viewModel.lastname,
//                onValueChange = { viewModel.onLastnameChanged(it) },
//                label = { Text("Apellido") },
//                modifier = Modifier.fillMaxWidth(),
//                singleLine = true
//            )
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            // Email
//            TextField(
//                value = viewModel.email,
//                onValueChange = { viewModel.onEmailChanged(it) },
//                label = { Text("Correo Electrónico") },
//                modifier = Modifier.fillMaxWidth(),
//                singleLine = true
//            )
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            // Contraseña
//            TextField(
//                value = viewModel.password,
//                onValueChange = { viewModel.onPasswordChanged(it) },
//                label = { Text("Contraseña") },
//                visualTransformation = PasswordVisualTransformation(),
//                modifier = Modifier.fillMaxWidth(),
//                singleLine = true
//            )
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            // Teléfono
//            TextField(
//                value = viewModel.phone,
//                onValueChange = { viewModel.onPhoneChanged(it) },
//                label = { Text("Teléfono") },
//                modifier = Modifier.fillMaxWidth(),
//                singleLine = true
//            )
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            // Fecha de Nacimiento
//            TextField(
//                value = viewModel.birthDate,
//                onValueChange = { viewModel.onBirthDateChanged(it) },
//                label = { Text("Fecha de Nacimiento (YYYY-MM-DD)") },
//                modifier = Modifier.fillMaxWidth(),
//                singleLine = true
//            )
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            // Ubicación
//            TextField(
//                value = viewModel.location,
//                onValueChange = { viewModel.onLocationChanged(it) },
//                label = { Text("Ubicación") },
//                modifier = Modifier.fillMaxWidth(),
//                singleLine = true
//            )
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            // Número
//            TextField(
//                value = viewModel.number,
//                onValueChange = { viewModel.onNumberChanged(it) },
//                label = { Text("Número") },
//                modifier = Modifier.fillMaxWidth(),
//                singleLine = true
//            )
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            // Botón de Registro
//            Button(
//                onClick = {
//                    viewModel.register(
//                        onRegistrationSuccess = {
//                            // Navegar a la pantalla principal
//                            navController.navigate("HomeUsuario") {
//                                popUpTo("LoginPrueba") { inclusive = true }
//                            }
//                        },
//                        onRegistrationFailure = { errorMessage ->
//                            // Mostrar mensaje de error
//                            viewModel.registrationError = errorMessage
//                        }
//                    )
//                },
//                modifier = Modifier.fillMaxWidth(),
//                enabled = !viewModel.isLoading
//            ) {
//                if (viewModel.isLoading) {
//                    CircularProgressIndicator(
//                        modifier = Modifier.size(24.dp),
//                        color = MaterialTheme.colorScheme.onPrimary
//                    )
//                } else {
//                    Text("Registrarse")
//                }
//            }
//        }
//    }
//}
// Error Handling