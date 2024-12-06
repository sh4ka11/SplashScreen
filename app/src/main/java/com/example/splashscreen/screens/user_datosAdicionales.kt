package com.example.splashscreen.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserAdditionalInfoScreen(navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    var fechaNacimiento by remember { mutableStateOf("") }
    var genero by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Imagen de fondo
        Image(
            painter = painterResource(id = R.drawable.image4_751131),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        // Contenido principal
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            // Logo
            Image(
                painter = painterResource(id = R.drawable.image7_751144),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp)
                    .size(216.dp, 89.dp)
            )

            // Card con el formulario
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F3))
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "Información adicional",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black,
                        modifier = Modifier.padding(vertical = 16.dp)
                    )

                    Divider(color = Color.Black)

                    Text(
                        text = "Completaremos tu perfil de Emprende link por usted. " +
                                "Puede agregar tus datos ahora o puedes darle siguiente y después los puedes ingresar.",
                        fontSize = 18.sp,
                        color = Color.Black,  // Cambiado a negro
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )

                    // Campos del formulario
                    CustomTextField(
                        value = nombre,
                        onValueChange = { nombre = it },
                        label = "Nombre",
                        placeholder = "Ingrese su nombre"
                    )

                    CustomTextField(
                        value = fechaNacimiento,
                        onValueChange = { fechaNacimiento = it },
                        label = "Fecha de nacimiento",
                        placeholder = "DD/MM/AAAA"
                    )

                    CustomTextField(
                        value = "POPAYAN-Cauca-Colombia",
                        onValueChange = { },
                        label = "Ubicación",
                        enabled = false
                    )

                    CustomTextField(
                        value = genero,
                        onValueChange = { genero = it },
                        label = "Género",
                        placeholder = "Seleccione su género"
                    )

                    // Botón Siguiente (mantiene su color original)
                    Button(
                        onClick = { navController.navigate("LoginPrueba") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(vertical = 8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF38352E)
                        )
                    ) {
                        Text(
                            text = "Siguiente",
                            fontSize = 20.sp,
                            color = Color(0xFFF9F7F3)  // Mantiene el color original
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String = "",
    enabled: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    Column {
        Text(
            text = label,
            fontSize = 12.sp,
            color = Color.Black,  // Cambiado a negro
            modifier = Modifier.padding(bottom = 4.dp)
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color(0xFFEDEDED),
                unfocusedBorderColor = Color.Black
             //textColor = Color.Black,   Cambiado a negro
               // placeholderColor = Color.Black.copy(alpha = 0.6f)  // Placeholder en negro con transparencia
            ),
            placeholder = { Text(placeholder) },
            enabled = enabled,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            singleLine = true
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UserAdditionalInfoPreview() {
    UserAdditionalInfoScreen(navController = rememberNavController())
}