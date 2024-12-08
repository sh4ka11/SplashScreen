import android.net.Uri
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserRegistrationScreen(

    navController: NavController,
    viewModel: UserRegistrationViewModel = viewModel()
) {
    val snackbarHostState = remember { SnackbarHostState() }
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState(initialDisplayMode = DisplayMode.Picker)

    val selectedDate = datePickerState.selectedDateMillis?.let {
        LocalDate.ofEpochDay(it / 86400000)
    }

    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(onClick = {
                    selectedDate?.let { viewModel.birthDate = it.toString() }
                    showDatePicker = false
                }) { Text("Aceptar") }
            },
            dismissButton = {
                TextButton(onClick = { showDatePicker = false }) { Text("Cancelar") }
            }
        ) {
            DatePicker(state = datePickerState, title = { Text("Selecciona tu fecha de nacimiento") })
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Title
            Text("Registro de Usuario", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            // Input Fields
            RegistrationTextField(
                value = viewModel.name,
                onValueChange = { viewModel.name = it },
                label = "Nombre",
                icon = Icons.Filled.Person
            )

            RegistrationTextField(
                value = viewModel.lastname,
                onValueChange = { viewModel.lastname = it },
                label = "Apellido",
                icon = Icons.Filled.Person
            )

            RegistrationTextField(
                value = viewModel.email,
                onValueChange = { viewModel.email = it },
                label = "Correo Electrónico",
                icon = Icons.Filled.Email,
                keyboardType = KeyboardType.Email
            )

            RegistrationTextField(
                value = viewModel.phone,
                onValueChange = { viewModel.phone = it },
                label = "Teléfono",
                icon = Icons.Filled.Phone,
                keyboardType = KeyboardType.Phone
            )

            OutlinedTextField(
                value = viewModel.birthDate,
                onValueChange = { },
                label = { Text("Fecha de Nacimiento") },
                leadingIcon = {
                    IconButton(onClick = { showDatePicker = true }) {
                        Icon(Icons.Filled.DateRange, contentDescription = "Seleccionar Fecha")
                    }
                },
                trailingIcon = {
                    IconButton(onClick = { showDatePicker = true }) {
                        Icon(Icons.Filled.Edit, contentDescription = "Editar Fecha")
                    }
                },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )

            RegistrationTextField(
                value = viewModel.location,
                onValueChange = { viewModel.location = it },
                label = "Ubicación",
                icon = Icons.Filled.LocationOn
            )

            RegistrationTextField(
                value = viewModel.password,
                onValueChange = { viewModel.password = it },
                label = "Contraseña",
                icon = Icons.Filled.Lock,
                isPassword = true
            )

            RegistrationTextField(
                value = viewModel.password_confirmation,
                onValueChange = { viewModel.password_confirmation = it },
                label = "Confirmar Contraseña",
                icon = Icons.Filled.Lock,
                isPassword = true
            )

            Dropdown(
                selectedOption = viewModel.role,
                onOptionSelected = { viewModel.role = it },
                options = viewModel.roleOptions
            )

            // Profile Image Picker
            ProfileImagePicker(
                imageUri = viewModel.image,
                onImageSelected = { uri -> viewModel.setSelectedImage(uri) }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Error Display
            viewModel.registrationError?.let { error ->
                Text(error, color = MaterialTheme.colorScheme.error)
                Spacer(modifier = Modifier.height(8.dp))
            }

            // Register Button
            Button(
                onClick = {
                    viewModel.registerUser {
                        navController.navigate("LoginPrueba") {
                            popUpTo("registroPrueba") { inclusive = true }
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                enabled = !viewModel.isLoading
            ) {
                if (viewModel.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp),
                        color = Color.White
                    )
                } else {
                    Text("Registrarse", color = Color.White)
                }
            }

            TextButton(onClick = { navController.navigate("LoginPrueba") }) {
                Text("¿Ya tienes una cuenta? Inicia Sesión")
            }
        }
    }
}


@Composable
fun RegistrationTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    icon: ImageVector,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPassword: Boolean = false
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        leadingIcon = { Icon(icon, contentDescription = label) },
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = ImeAction.Next
        ),
        modifier = Modifier.fillMaxWidth(),
        singleLine = true
    )
}

@Composable
fun ProfileImagePicker(imageUri: String, onImageSelected: (Uri) -> Unit) {
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri: Uri? ->
            uri?.let { onImageSelected(it) }
        }
    )

    Box(
        modifier = Modifier
            .size(120.dp)
            .clip(CircleShape)
            .clickable { launcher.launch("image/*") }, // Permitir seleccionar solo imágenes
        contentAlignment = Alignment.Center
    ) {
        if (imageUri.isNotEmpty()) {
            Image(
                painter = rememberAsyncImagePainter(imageUri),
                contentDescription = "Imagen de perfil",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
            )
        } else {
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = "Seleccionar imagen",
                modifier = Modifier.size(50.dp),
                tint = Color.Gray
            )
        }
    }

    Text("Seleccionar imagen de perfil", style = MaterialTheme.typography.bodySmall)
}

@Composable
fun Dropdown(
    selectedOption: String,
    onOptionSelected: (String) -> Unit,
    options: List<String>
) {
    var expanded by remember { mutableStateOf(false) } // Controla si el menú está desplegado

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        OutlinedTextField(
            value = selectedOption,
            onValueChange = { },
            label = { Text("Rol") },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = "Abrir menú desplegable",
                    modifier = Modifier.clickable { expanded = true }
                )
            },
            readOnly = true, // No editable manualmente
            modifier = Modifier.fillMaxWidth()
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onOptionSelected(option) // Actualiza la selección
                        expanded = false // Cierra el menú
                    }
                )
            }
        }
    }
}
