package com.example.myapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.splashscreen.R

@Composable
fun Olvidarcorr(
    onNavigateToEmail: () -> Unit = {} // Función para navegación al correo
) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var showVerificationMessage by remember { mutableStateOf(false) }
    var showErrorMessage by remember { mutableStateOf(false) }

    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .background(Color(0xffffffff))
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .clipToBounds(),
    ) {
        // Imagen de fondo
        Image(
            painter = painterResource(id = R.drawable.fondoolvidar),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = -5.dp, y = -6.dp)
                .size(435.dp, 722.dp),
        )

        // Segunda caja
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 0.dp, y = 503.dp)
                .background(Color(0xfff5f5f3), RoundedCornerShape(20.dp))
                .size(900.dp, 1000.dp),
        )

        // Texto "Ingrese su correo"
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentHeight()
                .offset(x = 98.dp, y = 556.dp)
                .width(373.dp),
            text = "Ingrese su correo",
            color = Color(0xff000000),
            fontSize = 25.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )

        // Logo
        Image(
            painter = painterResource(id = R.drawable.sinfondo),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 14.dp, y = 42.dp)
                .size(216.dp, 89.dp),
        )

        // Botón "Siguiente"
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 45.dp, y = 861.dp)
                .background(Color(0xff38352e), RoundedCornerShape(10.dp))
                .size(334.dp, 43.dp)
        ) {
            Button(
                onClick = {
                    if (email.text.contains("@")) {
                        showVerificationMessage = true
                        showErrorMessage = false
                    } else {
                        showErrorMessage = true
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Siguiente",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }

        // Campo para ingresar correo
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                showErrorMessage = false // Ocultar el mensaje de error al escribir
            },
            label = { Text("Ingrese su correo") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Black,
                unfocusedIndicatorColor = Color.Black,
                cursorColor = Color.Black,
                focusedTextColor = Color.Black
            ),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 44.dp, y = 769.dp)
                .height(70.dp) // Aumenta la altura para acomodar el texto
                .width(342.dp) // Establece un ancho específico
        )

        // Mensaje de error
        if (showErrorMessage) {
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 44.dp, y = 844.dp),
                text = "Ingrese un correo electronico valido",
                color = Color.Red,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left
            )
        }

        // Líneas decorativas
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 39.dp, y = 661.dp)
                .size(348.dp, 1.dp)
                .border(1.dp, Color(0xffcec7c7)),
        )

        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 44.dp, y = 661.dp) // Ajusté el offset hacia la izquierda
                .size(161.dp, 1.dp)
                .border(1.dp, Color(0xff000000)),
        )

        // Texto "Correo" clickeable
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentSize()
                .offset(x = 93.dp, y = 612.dp)
                .clickable { onNavigateToEmail() },
            text = "Correo",
            color = Color(0xb2000000),
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )

        // Texto "Teléfono" a la derecha de "Correo"
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentSize()
                .offset(x = 270.dp, y = 612.dp) // Ajusté el offset hacia la izquierda
                .clickable { /* Accion para el teléfono */ },
            text = "Teléfono",
            color = Color(0xb2000000),
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )


        // Mensaje de instrucciones
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 43.dp, y = 684.dp)
                .size(341.dp, 50.dp),
            text = "Ingrese su correo para poder enviar un código de confirmación",
            color = Color(0xb2000000),
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
        )

        // Mensaje de verificación
        if (showVerificationMessage) {
            Card(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(16.dp)
                    .width(342.dp)
                    .wrapContentHeight(),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Se ha enviado un código de verificación al correo ${email.text}",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Button(
                        onClick = { showVerificationMessage = false },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
                    ) {
                        Text("Aceptar")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Olvidarcorreo() {
    MaterialTheme {
        Olvidarcorr()
    }
}
