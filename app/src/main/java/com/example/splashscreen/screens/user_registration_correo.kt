package com.example.splashscreen.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.R
import com.example.splashscreen.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserRegistrationCorreo(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        // Imagen de fondo
        Image(
            painter = painterResource(id = R.drawable.image4_751131),
            contentDescription = "Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color.White.copy(alpha = 0.3f), // Reducido el alpha para más transparencia
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 30.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                // Logo Box
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.image7_751144),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .padding(top = 25.dp)
                            .size(216.dp, 89.dp)
                    )
                }

                // Registration Form
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = Color(0xFFF5F5F3),
                            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                        )
                        .padding(24.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 23.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Correo",
                            color = Color(0xB2000000),
                            fontSize = 20.sp,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                    }

                    // Custom TextField function
                    @Composable
                    fun CustomTextField(
                        value: String,
                        onValueChange: (String) -> Unit,
                        label: String,
                        keyboardType: KeyboardType = KeyboardType.Text,
                        visualTransformation: VisualTransformation = VisualTransformation.None
                    ) {
                        OutlinedTextField(
                            value = value,
                            onValueChange = onValueChange,
                            label = { Text(label) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            shape = RoundedCornerShape(20.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                containerColor = Color(0xFFFCFCFC),
                                unfocusedBorderColor = Color(0xFF000000)
                            ),
                            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
                            visualTransformation = visualTransformation,
                            singleLine = true
                        )
                    }

                    CustomTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = "Nombre"
                    )

                    CustomTextField(
                        value = lastName,
                        onValueChange = { lastName = it },
                        label = "Apellidos"
                    )

                    CustomTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = "Correo electrónico",
                        keyboardType = KeyboardType.Email
                    )

                    CustomTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = "Contraseña",
                        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation()
                    )

                    CustomTextField(
                        value = confirmPassword,
                        onValueChange = { confirmPassword = it },
                        label = "Confirmar contraseña",
                        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Register Button
                    Button(
                        onClick = {
                            navController.navigate(AppScreens.user_registration_codeve_correo.route)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF38352E)
                        ),
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(68.dp)
                            .padding(vertical = 15.dp)
                    ) {
                        Text(
                            text = "Registrarse",
                            color = Color.White,
                            fontSize = 18.sp
                        )
                    }

                    // Help Button
                    TextButton(
                        onClick = { /* Implementation */ },
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Text(
                            text = "¿Necesitas Ayuda?",
                            color = Color(0xFF000000),
                            fontSize = 20.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserRegistrationCorreoPreview() {
    UserRegistrationCorreo(rememberNavController())
}