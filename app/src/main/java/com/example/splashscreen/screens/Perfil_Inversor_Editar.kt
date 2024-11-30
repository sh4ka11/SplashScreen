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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import com.example.splashscreen.R

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

data class MenuItem(
    val texto: String,
    val icono: androidx.compose.ui.graphics.vector.ImageVector,
    val ruta: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileEditScreen(
    navController: NavController,
    onUpdateProfile: () -> Unit = {}
) {
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }

    var userProfile by remember {
        mutableStateOf(
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
        )
    }

    val scrollState = rememberScrollState()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(300.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                // Profile section in drawer
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.image3_647598),
                            contentDescription = "Foto de perfil",
                            modifier = Modifier
                                .size(64.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Usuario",
                            fontSize = 16.sp
                        )
                        Text(
                            text = "usuario@email.com",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    }
                }

                Divider()

                // Drawer menu items with navigation
                val menuItems = listOf(
                    MenuItem("Mi Perfil", Icons.Default.Person, "user_profile_main_viewInver"),
                    MenuItem("Inicio", Icons.Default.Home, "HomeUsuarioInver"),
                    MenuItem("Búsqueda por categoría", Icons.Default.Search, "busquedaInver"),
                    MenuItem("Lista de emprendimientos", Icons.Default.List, "emprendimientosInver"),
                    MenuItem("Notificaciones", Icons.Default.Notifications, "notificacionesInver"),
                    MenuItem("Chat", Icons.Default.Email, "chatInver"),
                    MenuItem("Cerrar Sesión", Icons.Default.ExitToApp, "cerrar-sesion"),
                    MenuItem("Ayuda", Icons.Default.Info, "ayudaInver")
                )

                menuItems.forEach { menuItem ->
                    NavigationDrawerItem(
                        icon = { Icon(menuItem.icono, contentDescription = menuItem.texto) },
                        label = { Text(menuItem.texto) },
                        selected = false,
                        onClick = {
                            scope.launch {
                                drawerState.close()
                                // Manejo especial para cerrar sesión
                                if (menuItem.ruta == "cerrar-sesion") {
                                    navController.navigate("login") {
                                        popUpTo(navController.graph.startDestinationId) {
                                            inclusive = true
                                        }
                                    }
                                } else {
                                    navController.navigate(menuItem.ruta)
                                }
                            }
                        }
                    )
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    if (drawerState.isClosed) drawerState.open()
                                    else drawerState.close()
                                }
                            }
                        ) {
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
                        painter = painterResource(id = R.drawable.image3_647598),
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

@Preview(showBackground = true, widthDp = 430, heightDp = 894)
@Composable
fun PreviewProfileEditScreen() {
    val navController = rememberNavController()
    ProfileEditScreen(navController = navController)
}