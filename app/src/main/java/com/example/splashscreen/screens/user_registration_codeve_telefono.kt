package com.example.splashscreen.screens

import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun VerificationCodeScreen(navController: NavController) {
    var code by remember { mutableStateOf(List(6) { "" }) }
    var resendEnabled by remember { mutableStateOf(true) }
    var countdown by remember { mutableStateOf(60) }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo
        Image(
            painter = painterResource(id = R.drawable.image7_751144),
            contentDescription = "Logo",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .padding(top = 42.dp)
                .width(216.dp)
                .height(89.dp)
        )

        // Background Image
        Image(
            painter = painterResource(id = R.drawable.image4_751131),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        // Content Card
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F3))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Código de confirmación",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Le enviamos un código de confirmación a tu número 312 6659859.",
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Verification Code Input
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    code.forEachIndexed { index, digit ->
                        OutlinedTextField(
                            value = digit,
                            onValueChange = { newValue ->
                                if (newValue.length <= 1) {
                                    val newCode = code.toMutableList()
                                    newCode[index] = newValue
                                    code = newCode
                                }
                            },
                            modifier = Modifier
                                .weight(1f)
                                .height(84.dp),
                            textStyle = LocalTextStyle.current.copy(
                                textAlign = TextAlign.Center,
                                fontSize = 24.sp
                            ),
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(0xFF38352E),
                                unfocusedBorderColor = Color.Gray
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Next Button
                Button(
                    onClick = { /* Handle verification */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(57.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF38352E))
                ) {
                    Text("Siguiente", fontSize = 20.sp)
                }

                Spacer(modifier = Modifier.height(32.dp))

                Divider(color = Color.Gray, thickness = 1.dp)

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "¿No recibiste un código de confirmación?",
                    fontSize = 18.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Resend Button
                Button(
                    onClick = {
                        if (resendEnabled) {
                            resendEnabled = false
                            scope.launch {
                                while (countdown > 0) {
                                    delay(1000)
                                    countdown--
                                }
                                resendEnabled = true
                                countdown = 60
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(57.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF38352E),
                        disabledContainerColor = Color.Gray
                    ),
                    enabled = resendEnabled
                ) {
                    Text(
                        if (resendEnabled) "Reenviar código"
                        else "Reenviar código ($countdown s)",
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun usercodevteViewPreview() {
    val navController = rememberNavController() // Create a NavController for preview
    VerificationCodeScreen(navController = navController) // Pass it to HomeScreen
}


