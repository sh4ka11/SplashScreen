package com.example.splashscreen.screens

import UserProfileViewModel
import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.splashscreen.data.model.UserProfile

@Composable
fun UserProfileMainView(
    navController: NavController,
    viewModel: UserProfileViewModel = viewModel()
) {
    val context = LocalContext.current
    val user by viewModel.user.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    // Cargar el perfil del usuario cuando se inicializa la vista
    LaunchedEffect(Unit) {
        viewModel.loadUserProfile(context)
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        when {
            isLoading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            error != null -> {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = error ?: "Error desconocido",
                        color = Color.Red,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = { navController.navigate("login") }) {
                        Text("Volver al inicio de sesión")
                    }
                }
            }
            user != null -> {
                UserProfileContent(user = user!!, navController = navController)
            }
        }
    }
}

@Composable
fun UserProfileContent(
    user: UserProfile,
    navController: NavController
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagen de perfil
        AsyncImage(
            model = user.image,
            contentDescription = "Foto de perfil",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Información del usuario
        Text(
            text = user.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        ProfileInfoItem("Correo", user.email)
        ProfileInfoItem("Teléfono", user.phone)
        ProfileInfoItem("Ubicación", user.location)
        ProfileInfoItem("Fecha de nacimiento", user.birthDate)

        Spacer(modifier = Modifier.height(24.dp))

        // Botón Editar Perfil
        Button(
            onClick = { navController.navigate("editProfile") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        ) {
            Text("Editar Perfil")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón Cerrar Sesión
        OutlinedButton(
            onClick = {
                context.getSharedPreferences("auth_prefs", Context.MODE_PRIVATE)
                    .edit()
                    .remove("token")
                    .apply()
                navController.navigate("login") {
                    popUpTo(0) {
                        inclusive = true
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        ) {
            Text("Cerrar Sesión")
        }
    }
}

@Composable
private fun ProfileInfoItem(
    label: String,
    value: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = label,
            fontSize = 14.sp,
            color = Color.Gray
        )
        Text(
            text = value,
            fontSize = 16.sp
        )
    }
}