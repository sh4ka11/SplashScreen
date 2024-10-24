package com.example.splashscreen.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    onMenuClick: () -> Unit = {}
) {
    var userProfile by remember { mutableStateOf(
        UserProfile(
            name = "Cristian Sebastian Delgado Calvache",
            birthDate = "Nacido(a) el 05 de septiembre de 2002",
            email = "sdp402@gmail.com",
            location = "POPAYAN-Cauca-Colombia",
            phone = "3214567890",
            document = "19861598659864",
            experienceFile = "CERTIFICADOEXPERIENCIA.DOCX",
            certification = "5678876445436"
        )
    ) }

    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = onMenuClick) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF1C1B1F)
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF1C1B1F))
                .padding(paddingValues)
                .verticalScroll(scrollState) // Agregado el scroll vertical
        ) {
            // Profile Header
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = android.R.drawable.ic_menu_gallery),
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )

                    Column(
                        modifier = Modifier
                            .padding(start = 16.dp)
                    ) {
                        Text(
                            text = "Nombre:",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                        Text(
                            text = userProfile.name,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Row(
                            modifier = Modifier.padding(top = 8.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Button(
                                onClick = { "ProfileEditScreen" },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF2C2C2C)
                                )
                            ) {
                                Text("Editar perfil")
                            }

                            Button(
                                onClick = { /* Compartir perfil action */ },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF2C2C2C)
                                )
                            ) {
                                Text("Compartir perfil")
                            }
                        }
                    }
                }
            }

            // Profile Details
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    ProfileField("Nombre", userProfile.name)
                    ProfileField("Fecha nacimiento", userProfile.birthDate)
                    ProfileField("Correo", userProfile.email)
                    ProfileField("Ubicacion", userProfile.location)
                    ProfileField("Celular", userProfile.phone)
                    ProfileField("Documento", userProfile.document)
                    ProfileField("Experiencia", userProfile.experienceFile)
                    ProfileField("Certificacion", userProfile.certification)
                }
            }

            // Añadir espacio al final para mejor scroll
            Spacer(modifier = Modifier.height(16.dp))
        }
    }


}

@Composable
private fun ProfileField(label: String, value: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = label,
            fontSize = 14.sp,
            color = Color.Gray
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
        ) {
            Text(
                text = value,
                modifier = Modifier.padding(12.dp),
                fontSize = 16.sp
            )
        }
    }
}




sealed class NavigationItem(val route: String) {
    object Login : NavigationItem("login")
    object Home : NavigationItem("home")
    object Detail : NavigationItem("detail")
    object Profile : NavigationItem("profile")
    object ProfileEdit : NavigationItem("profile_edit")
}


@Preview(showBackground = true, widthDp = 430, heightDp = 894)
@Composable
fun PreviewCodia1MainView() {
    ProfileScreen()
}

