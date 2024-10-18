package com.example.splashscreen.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.splashscreen.R
import com.example.splashscreen.ui.theme.SplashScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreenTheme {
                UserProfileScreen()
            }
        }
    }
}

@Composable
fun UserProfileScreen() {
    var name by remember { mutableStateOf("Cristian sebastian delgado calvache") }
    var birthdate by remember { mutableStateOf("Nacido(a) el 05 de septiembre de 2002") }
    var email by remember { mutableStateOf("sdp402@gmail.com") }
    var location by remember { mutableStateOf("POPAYAN-Cauca-Colombia") }
    var phone by remember { mutableStateOf("3214567890") }
    var gender by remember { mutableStateOf("MASCULINO") }
    var stage by remember { mutableStateOf("Primera fase: la idea de negocio") }
    var document by remember { mutableStateOf("19861598659864") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.fondo_logo), // Reemplazar con tu imagen de fondo
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // Profile Picture
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.Gray),
                contentAlignment = Alignment.BottomEnd
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logocir), // Reemplazar con tu imagen de perfil
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                )
                // Edit Icon
                IconButton(
                    onClick = { /* Acción para editar imagen */ },
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.linkedin), // Icono de editar
                        contentDescription = "Edit",
                        tint = Color.Black
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // User Info Form
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFFF0F0F0))
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                UserInfoItem("Nombre", name)
                UserInfoItem("Fecha de nacimiento", birthdate)
                UserInfoItem("Correo", email)
                UserInfoItem("Ubicacion", location)
                UserInfoItem("Celular", phone)
                UserInfoItem("Genero", gender)
                UserInfoItem("Etapa", stage)
                UserInfoItem("Documento", document)

                Spacer(modifier = Modifier.height(16.dp))

                // Update Button
                Button(
                    onClick = { /* Acción para actualizar información */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(text = "Actualizar", color = Color.White, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun UserInfoItem(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = value,
            fontSize = 14.sp,
            modifier = Modifier.weight(2f)
        )
        Spacer(modifier = Modifier.width(8.dp))
        IconButton(onClick = { /* Acción para editar el campo */ }) {
            Icon(
                painter = painterResource(id = R.drawable.linkedin), // Icono de editar
                contentDescription = "Edit",
                tint = Color.Black
            )
        }
    }
}
