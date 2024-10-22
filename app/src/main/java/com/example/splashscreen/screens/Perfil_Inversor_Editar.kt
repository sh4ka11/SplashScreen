package com.example.splashscreen.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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
import coil.compose.rememberAsyncImagePainter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    onMenuClick: () -> Unit = {},
    onEditClick: () -> Unit = {}
) {
    // ... código existente ...

    Button(
        onClick = onEditClick,  // Modificado para usar onEditClick
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF2C2C2C)
        )
    ) {
        Text("Editar perfil")
    }

    // ... resto del código ...
}

// ProfileEditScreen.kt - Añadir selector de imagen
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileEditScreen(
    onMenuClick: () -> Unit = {},
    onUpdateProfile: () -> Unit = {}
) {
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }
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
                .verticalScroll(scrollState)
        ) {
            // Profile Image
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = if (imageUri != null) {
                        rememberAsyncImagePainter(imageUri)
                    } else {
                        painterResource(id = android.R.drawable.ic_menu_gallery)
                    },
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .clickable { launcher.launch("image/*") },
                    contentScale = ContentScale.Crop
                )
            }

            // Profile Fields Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    EditableField("Nombre", userProfile.name)
                    EditableField("Fecha de nacimiento", userProfile.birthDate)
                    EditableField("Correo", userProfile.email)
                    EditableField("Ubicacion", userProfile.location)
                    EditableField("Celular", userProfile.phone)
                    EditableField("Documento", userProfile.document)
                    EditableField("Experiencia", userProfile.experienceFile)
                    EditableField("Certificacion", userProfile.certification)

                    // Actualizar Button
                    Button(
                        onClick = onUpdateProfile,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF2C2C2C)
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            "Actualizar",
                            modifier = Modifier.padding(vertical = 8.dp),
                            fontSize = 16.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun EditableField(label: String, value: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = label,
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = value,
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    fontSize = 16.sp
                )

                Row(
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    IconButton(
                        onClick = { /* Edit action */ },
                    ) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Editar",
                            tint = Color.Gray
                        )
                    }

                    IconButton(
                        onClick = { /* Delete action */ },
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Eliminar",
                            tint = Color.Gray
                        )
                    }
                }
            }
        }
    }
}

data class UserProfile1(
    val name: String,
    val birthDate: String,
    val email: String,
    val location: String,
    val phone: String,
    val document: String,
    val experienceFile: String,
    val certification: String
)

@Preview(showBackground = true, widthDp = 430, heightDp = 894)
@Composable
fun ProfileEditScreen1() {
    ProfileEditScreen()
}
