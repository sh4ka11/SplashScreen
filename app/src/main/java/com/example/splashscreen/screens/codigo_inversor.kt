package com.example.splasscreen.screens

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
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ConfirmationCodeScreen(navController: NavController? = null) {
    var showDialog by remember { mutableStateOf(false) }
    val code = remember { List(6) { mutableStateOf("") } }
    val focusRequesters = remember { List(6) { FocusRequester() } }
    val keyboardController = LocalSoftwareKeyboardController.current
    val scope = rememberCoroutineScope()

    // Estado de desplazamiento
    val scrollState = rememberScrollState()

    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .background(Color(0xffffffff))
            .fillMaxSize()
            .clipToBounds(),
    ) {
        // Imagen de fondo existente
        Image(
            painter = painterResource(id = R.drawable.fondoolvidar),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = -5.dp, y = 0.dp)
                .size(500.dp, 700.dp),
        )

        // Caja blanca de fondo
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 0.dp, y = 250.dp)
                .background(Color(0xfff5f5f3), RoundedCornerShape(20.dp))
                .fillMaxSize(),
        ) {
            // Columna con contenido desplazable
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState) // Permite el desplazamiento vertical
                    .padding(16.dp) // Añade un poco de padding
            ) {
                // Título
                Text(
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(start = 30.dp, top = 10.dp), // Aquí agregamos padding a la izquierda
                    text = "Código de confirmación",
                    color = Color(0xff000000),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Left,
                    overflow = TextOverflow.Ellipsis,
                )

                // Texto de instrucciones
                Text(
                    modifier = Modifier
                        .size(387.dp, 92.dp)
                        .padding(top = 12.dp), // Añadir padding arriba para separar
                    text = "Le enviamos un correo electrónico con el código de confirmación al número ingresado",
                    color = Color(0xb2000000),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                )

                // Cajas de entrada del código
                Row(
                    horizontalArrangement = Arrangement.spacedBy(9.dp)
                ) {
                    code.forEachIndexed { index, state ->
                        TextField(
                            value = state.value,
                            onValueChange = { newValue ->
                                if (newValue.length <= 1 && newValue.all { it.isDigit() }) {
                                    state.value = newValue
                                    if (newValue.isNotEmpty() && index < 5) {
                                        scope.launch {
                                            focusRequesters[index + 1].requestFocus()
                                        }
                                    }
                                }
                            },
                            modifier = Modifier
                                .size(54.dp, 84.dp)
                                .focusRequester(focusRequesters[index])
                                .border(1.dp, Color(0xff000000), RoundedCornerShape(20.dp)),
                            textStyle = androidx.compose.ui.text.TextStyle(
                                textAlign = TextAlign.Center,
                                fontSize = 24.sp
                            ),
                            colors = TextFieldDefaults.colors(
                                unfocusedContainerColor = Color(0xfffcfcfc),
                                focusedContainerColor = Color(0xfffcfcfc),
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent
                            ),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            singleLine = true
                        )
                    }
                }

                // Botón Siguiente
                Button(
                    onClick = {
                        if (code.all { it.value.isNotEmpty() }) {
                            showDialog = true
                        }
                    },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 40.dp) // Ajustar el padding hacia arriba
                        .size(300.dp, 50.dp), // Ajustar el tamaño del botón
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
                ) {
                    Text(
                        text = "Siguiente",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal,
                    )
                }

                // Espacio entre el botón y la línea separadora
                Spacer(modifier = Modifier.height(40.dp)) // Espacio adicional

                // Nueva línea separadora
                Image(
                    painter = painterResource(id = R.drawable.fondo),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(365.dp, 2.dp)
                        .border(1.dp, Color(0xffcec7c7))
                        .padding(vertical = 10.dp)
                        .align(Alignment.CenterHorizontally) // Alinear al centro
                )

                // Añadir más espacio antes del texto "¿No recibiste un correo?"
                Spacer(modifier = Modifier.height(30.dp)) // Espacio adicional

                // Texto "No recibiste un correo"
                Text(
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(start = 40.dp, top = 20.dp), // Agrega padding en el lado izquierdo
                    text = "¿No recibiste un correo electrónico?",
                    color = Color(0xb2000000),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                )

                // Botón de Reenviar código
                Button(
                    onClick = { /* Acción del botón */ },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 10.dp)
                        .size(300.dp, 50.dp), // Mantener el mismo tamaño que el botón "Siguiente"
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
                ) {
                    Text(
                        text = "Reenviar código",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal,
                    )
                }
            }
        }

        // Mover la imagen sin fondo a la parte superior izquierda
        Image(
            painter = painterResource(id = R.drawable.sinfondo),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart) // Alinear en la parte superior izquierda
                .size(170.dp, 95.dp)
                .padding(16.dp) // Añadir padding si es necesario
        )

        // Diálogo de verificación
        if (showDialog) {
            Dialog(onDismissRequest = { showDialog = false }) {
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Se verificó correctamente",
                            modifier = Modifier.padding(bottom = 16.dp),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Button(
                            onClick = {
                                showDialog = false
                                // Aquí puedes agregar la navegación a la siguiente vista
                                // navigator.navigate("siguiente_ruta")
                            },
                            modifier = Modifier.size(300.dp, 50.dp), // Igualar tamaño al resto de los botones
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
                        ) {
                            Text("Aceptar", color = Color.White)
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun codigoPreviewInversor() {
    val navController = rememberNavController() // Crear un navController de prueba
    MaterialTheme {
        ConfirmationCodeScreen(navController = navController)
    }
}