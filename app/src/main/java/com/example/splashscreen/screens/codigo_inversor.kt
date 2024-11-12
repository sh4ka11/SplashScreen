package com.example.splashscreen.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
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
fun ConfirmationCodeScreen(navController: NavController) {
    var code by remember { mutableStateOf(arrayOf("", "", "", "", "", "")) }

    val configuration = LocalConfiguration.current
    val isPortrait = configuration.orientation == Configuration.ORIENTATION_PORTRAIT

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF1C1B1F)
                )
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            if (isPortrait) {
                Image(
                    painter = painterResource(id = R.drawable.hom),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .offset(y = (-73).dp)
                        .size(800.dp, 600.dp)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = if (isPortrait) 200.dp else 0.dp)
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    shape = RoundedCornerShape(
                        topStart = if (isPortrait) 20.dp else 0.dp,
                        topEnd = if (isPortrait) 35.dp else 0.dp
                    ),
                    color = Color(0xFFF5F5F3)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(24.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Código de confirmación",
                                style = MaterialTheme.typography.titleLarge.copy(
                                    fontSize = 25.sp
                                ),
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )

                            Spacer(modifier = Modifier.height(30.dp))

                            Text(
                                text = "Le enviamos un correo electrónico con el código de confirmación a gustavo@gmail.com",
                                style = MaterialTheme.typography.bodyMedium,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )

                            Spacer(modifier = Modifier.height(50.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                for (i in code.indices) {
                                    TextField(
                                        value = code[i],
                                        onValueChange = { newValue ->
                                            val newCode = code.toMutableList()
                                            newCode[i] = newValue
                                            code = newCode.toTypedArray()
                                        },
                                        modifier = Modifier
                                            .width(40.dp)
                                            .height(70.dp)
                                            .border(1.dp, Color.Black, RoundedCornerShape(8.dp)),
                                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                        singleLine = true,
                                        textStyle = MaterialTheme.typography.titleLarge.copy(
                                            fontSize = 18.sp
                                        )
                                    )
                                    if (i < code.lastIndex) {
                                        Spacer(modifier = Modifier.width(8.dp))
                                    }
                                }
                            }
                        }

                        // Aquí está el cambio para centrar el botón
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Bottom // Asegura que el contenido esté en la parte inferior
                        ) {
                            Button(
                                onClick = { navController.navigate("informacion_obligatoria") }, // Cambia "informacion_obligatoria" a la ruta que hayas definido para tu pantalla de información obligatoria
                                modifier = Modifier
                                    .width(300.dp) // Cambia esto al ancho que desees
                                    .height(50.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF38352E)
                                ),
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Text(
                                    text = "Siguiente", // Asegúrate de corregir "Siguente" a "Siguiente"
                                    fontSize = 18.sp // Cambia este valor al tamaño de letra que desees
                                )
                            }


                            Spacer(modifier = Modifier.height(16.dp)) // Espaciado opcional entre el botón y el texto

                            Text(
                                text = "No recibiste un código?",
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color(0xB2000000)
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Button(
                                onClick = { /*TODO: Handle resend code*/ },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(40.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF38352E)
                                ),
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Text("Enviar")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CoodigoInversorPreview() {
    val navController = rememberNavController() // Crea un NavController simulado
    MaterialTheme {
        ConfirmationCodeScreen(navController) // Pasa el NavController a la pantalla
    }
}

