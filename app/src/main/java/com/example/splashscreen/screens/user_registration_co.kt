package com.example.splashscreen.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserRegistrationScreen(
    navController: NavController,
    onRegisterClick: (email: String, password: String) -> Unit = { _, _ -> }
) {
    val scrollState = rememberScrollState()
    var selectedTab by remember { mutableStateOf(0) }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .background(Color(0xFFFFFFFF))
            .fillMaxSize()
            .clipToBounds(),
    ) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.image4_751131),
            contentDescription = "Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = (-8).dp, y = (-73).dp)
                .size(438.dp, 644.dp),
        )

        // Logo
        Image(
            painter = painterResource(id = R.drawable.image7_751144),
            contentDescription = "Logo",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 14.dp, y = 42.dp)
                .size(216.dp, 89.dp),
        )

        // White background container with scroll
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 0.dp, y = 328.dp)
                .background(Color(0xFFF5F5F3), RoundedCornerShape(20.dp))
                .size(430.dp, 632.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(horizontal = 24.dp)
                    .padding(top = 42.dp)
            ) {
                Text(
                    text = "Registrarse en Emprede link",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF000000),
                    modifier = Modifier.padding(bottom = 24.dp)
                )

                // Tabs
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp)
                ) {
                    TabButton(
                        text = "Correo",
                        isSelected = selectedTab == 0,
                        onClick = {
                            selectedTab = 0
                        },
                        modifier = Modifier.weight(1f)
                    )
                    TabButton(
                        text = "Telefono",
                        isSelected = selectedTab == 1,
                        onClick = {
                            selectedTab = 1
                            navController.navigate("phone_registration_screen")
                        },
                        modifier = Modifier.weight(1f)
                    )
                }

                // Email registration form - Only show when email tab is selected
                if (selectedTab == 0) {
                    // Email field
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Correo electrónico") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color(0xFFFCFCFC),
                            unfocusedBorderColor = Color(0xFF000000)
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Next
                        )
                    )

                    // Password field
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Crear contraseña") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 24.dp),
                        shape = RoundedCornerShape(20.dp),
                        visualTransformation = PasswordVisualTransformation(),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color(0xFFFCFCFC),
                            unfocusedBorderColor = Color(0xFF000000)
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        )
                    )

                    // Register button
                    Button(
                        onClick = { onRegisterClick(email, password) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(37.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF38352E)
                        )
                    ) {
                        Text(
                            text = "Siguiente",
                            color = Color(0xFFF9F7F3),
                            fontSize = 20.sp
                        )
                    }

                    // Terms text
                    Text(
                        text = "Al proporcionar su número de teléfono a Emprede link, usted acepta recibir mensajes SMS con notificaciones relacionadas con su cuenta. Es posible que se apliquen mensajes estándar",
                        color = Color(0xB2000000),
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(vertical = 24.dp)
                    )

                    // Login link
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "¿Ya tienes una cuenta?",
                            color = Color(0xB2000000),
                            fontSize = 15.sp
                        )
                        Text(
                            text = " Iniciar sesión",
                            color = Color(0xFF000000),
                            fontSize = 15.sp,
                            modifier = Modifier.clickable {
                                navController.navigate("login_screen")
                            }
                        )
                    }

                    // Add extra padding at the bottom for scrolling
                    Spacer(modifier = Modifier.height(32.dp))
                }
            }
        }
    }
}

@Composable
private fun TabButton(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            fontSize = 20.sp,
            color = if (isSelected) Color(0xFF000000) else Color(0xB2000000)
        )
        Box(
            modifier = Modifier
                .padding(top = 8.dp)
                .height(1.dp)
                .width(if (isSelected) 161.dp else 348.dp)
                .background(if (isSelected) Color(0xFF000000) else Color(0xFFCEC7C7))
        )
    }
}

// Nueva pantalla para registro por teléfono
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneRegistrationScreen(
    navController: NavController
) {
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(24.dp)
        ) {
            // Add back button
            IconButton(
                onClick = { navController.navigateUp() },
                modifier = Modifier.align(Alignment.Start)
            ) {
                // You'll need to add an icon here
                Text("←", fontSize = 24.sp)
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Registro por Teléfono",
                fontSize = 25.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = { Text("Número de teléfono") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next
                )
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Crear contraseña") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                )
            )

            Button(
                onClick = { /* Handle phone registration */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(37.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF38352E)
                )
            ) {
                Text(
                    text = "Registrarse",
                    color = Color(0xFFF9F7F3),
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserRegistrationPreview() {
    UserRegistrationScreen(rememberNavController())
}

@Preview(showBackground = true)
@Composable
fun PhoneRegistrationPreview() {
    PhoneRegistrationScreen(rememberNavController())
}