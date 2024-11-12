package com.example.splashscreen.screens

import android.content.res.Configuration
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.splashscreen.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginInversor(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val configuration = LocalConfiguration.current
    val isPortrait = configuration.orientation == Configuration.ORIENTATION_PORTRAIT

    var offsetY by remember { mutableStateOf(0f) }
    val animatedOffset by animateFloatAsState(
        targetValue = offsetY,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

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
                    .padding(top = if (isPortrait) 180.dp else 0.dp)
            ) {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .offset(y = animatedOffset.dp)
                        .pointerInput(Unit) {
                            detectDragGestures(
                                onDragStart = { },
                                onDragEnd = {
                                    offsetY = 0f
                                },
                                onDrag = { change, dragAmount ->
                                    change.consume()
                                    val newOffset = (offsetY + dragAmount.y).coerceIn(0f, 50f)
                                    if (dragAmount.y > 0 || offsetY > 0) {
                                        offsetY = newOffset
                                    }
                                }
                            )
                        },
                    shape = RoundedCornerShape(
                        topStart = if (isPortrait) 20.dp else 0.dp,
                        topEnd = if (isPortrait) 35.dp else 0.dp
                    ),
                    color = Color(0xFFF5F5F3)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .padding(24.dp)
                    ) {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Iniciar sesión en EmprendeLink",
                                modifier = Modifier
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.titleLarge.copy(
                                    fontSize = 25.sp
                                )
                            )
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = "Correo",
                            modifier = Modifier.fillMaxWidth(),
                            style = MaterialTheme.typography.titleMedium,
                            textAlign = TextAlign.Center
                        )

                        Divider(
                            modifier = Modifier.padding(vertical = 8.dp),
                            color = Color.Black
                        )

                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            label = { Text("Correo electronico") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            shape = RoundedCornerShape(20.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color.Black,
                                unfocusedBorderColor = Color.Black
                            )
                        )

                        OutlinedTextField(
                            value = password,
                            onValueChange = { password = it },
                            label = { Text("Contraseña") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            shape = RoundedCornerShape(20.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color.Black,
                                unfocusedBorderColor = Color.Black
                            )
                        )

                        Text(
                            text = "¿Has olvidado tu contraseña?",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            style = MaterialTheme.typography.bodyLarge,
                            textAlign = TextAlign.Center,
                            color = Color(0xB2000000)
                        )

                        Button(
                            onClick = {  navController.navigate("HomeInversionista")},
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF38352E)
                            ),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text("Iniciar sesion")
                        }

                        Text(
                            text = "Continuar con",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp),
                            style = MaterialTheme.typography.titleMedium,
                            textAlign = TextAlign.Center,
                            color = Color(0xB2000000)
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 32.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .background(Color.White, RoundedCornerShape(180.dp))
                                    .border(1.dp, Color.Black, RoundedCornerShape(180.dp))
                                    .padding(horizontal = 16.dp, vertical = 8.dp)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.google),
                                        contentDescription = "Google Logo",
                                        modifier = Modifier.size(44.dp)
                                    )
                                    Text(
                                        text = "Google",
                                        style = MaterialTheme.typography.titleMedium
                                    )
                                }
                            }
                        }

                        Divider(
                            modifier = Modifier.padding(vertical = 16.dp),
                            color = Color(0xFFCEC7C7)
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "¿Ya tienes una cuenta?",
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color(0xB2000000)
                            )
                            Text(
                                text = " Iniciar sesión",
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginInversorPreview() {
    MaterialTheme {
        //LoginInversor()
    }
}