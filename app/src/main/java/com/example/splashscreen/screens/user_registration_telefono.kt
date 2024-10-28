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
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.R

object NavigationRoutes {
    const val PHONE_REGISTRATION = "phone_registration"
    const val EMAIL_REGISTRATION = "email_registration"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserRegistrationScreen(navController: NavController) {
    var phoneNumber by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            PhoneRegistrationView(
                navController = navController,
                phoneNumber = phoneNumber,
                onPhoneNumberChange = { newNumber ->
                    // Validar que solo se ingresen números y limitar a 10 dígitos
                    if (newNumber.length <= 10 && newNumber.all { it.isDigit() }) {
                        phoneNumber = newNumber
                    }
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneRegistrationView(
    navController: NavController,
    phoneNumber: String,
    onPhoneNumberChange: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(960.dp)
    ) {
        // Imagen de fondo
        Image(
            painter = painterResource(id = R.drawable.image4_751131),
            contentDescription = "Fondo",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = (-5).dp, y = (-6).dp)
                .size(435.dp, 722.dp),
        )

        // Panel blanco inferior
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 0.dp, y = 527.dp)
                .background(Color(0xFFF5F5F3), RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                .fillMaxWidth()
                .height(487.dp),
        )

        // Logo superior
        Image(
            painter = painterResource(id = R.drawable.image7_751144),
            contentDescription = "Logo",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 5.dp, y = 25.dp)
                .size(216.dp, 89.dp),
        )

        // Contenido del formulario
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .offset(y = 556.dp)
        ) {
            // Título
            Text(
                text = "Registrarse en Emprende link",
                fontSize = 25.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(horizontal = 29.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Pestañas de navegación
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 23.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextButton(
                    onClick = { navController.navigate("registroUsuarioCorreo") }
                ) {
                    Text(
                        text = "Correo",
                        color = Color(0xB2000000),
                        fontSize = 20.sp
                    )
                }

                TextButton(
                    onClick = { /* Ya estamos en teléfono */ }
                ) {
                    Text(
                        text = "Teléfono",
                        color = Color(0xFF000000),
                        fontSize = 20.sp
                    )
                }
            }

            // Líneas divisorias
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 23.dp)
                    .height(1.dp)
                    .background(Color(0xFFCEC7C7))
            )

            Box(
                modifier = Modifier
                    .offset(x = 187.dp)
                    .width(161.dp)
                    .height(1.dp)
                    .background(Color(0xFF000000))
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Campo de teléfono mejorado
            Box(
                modifier = Modifier
                    .padding(horizontal = 29.dp)
                    .fillMaxWidth()
                    .height(54.dp)
                    .background(Color(0xFFFCFCFC), RoundedCornerShape(20.dp))
                    .border(1.dp, Color(0xFF000000), RoundedCornerShape(20.dp))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Bandera y código de país
                    Image(
                        painter = painterResource(id = R.drawable.banderagriga),
                        contentDescription = "Bandera",
                        modifier = Modifier.size(33.dp)
                    )
                    Text(
                        text = "+1",
                        modifier = Modifier.padding(horizontal = 8.dp),
                        fontSize = 20.sp
                    )

                    // Separador vertical
                    Box(
                        modifier = Modifier
                            .width(1.dp)
                            .height(33.dp)
                            .background(Color(0x4C000000))
                    )

                    // Campo de entrada del número
                    TextField(
                        value = phoneNumber,
                        onValueChange = onPhoneNumberChange,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        placeholder = { Text("Ingresa tu número") },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        singleLine = true
                    )
                }
            }

            Spacer(modifier = Modifier.height(38.dp))

            // Botón Siguiente
            Button(
                onClick = {
                    // Aquí puedes validar que el número tenga 10 dígitos antes de continuar
                    if (phoneNumber.length == 10) {
                        // Implementar lógica de registro
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (phoneNumber.length == 10) Color(0xFF38352E) else Color.Gray
                ),
                enabled = phoneNumber.length == 10,
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .padding(horizontal = 29.dp)
                    .fillMaxWidth()
                    .height(43.dp)
            ) {
                Text(
                    text = "Siguiente",
                    color = Color(0xFFF9F7F3),
                    fontSize = 20.sp
                )
            }

            Spacer(modifier = Modifier.height(28.dp))

            // Botón de ayuda
            TextButton(
                onClick = { /* Implementar ayuda */ },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 16.dp)
            ) {
                Text(
                    text = "¿Necesitas Ayuda?",
                    color = Color(0xFF000000),
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PhoneRegistrationnPreview() {
    val navController = rememberNavController()
    UserRegistrationScreen(navController = navController)
}