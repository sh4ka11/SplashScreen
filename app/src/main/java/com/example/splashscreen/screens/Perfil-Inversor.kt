package com.example.splashscreen.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.R
import com.example.splashscreen.navigation.AppScreens
import kotlinx.coroutines.launch

data class UserProfile(
    val name: String,
    val birthDate: String,
    val email: String,
    val location: String,
    val phone: String,
    val document: String,
    val experienceFile: String,
    val certification: String
)

data class MenuItem(val texto: String, val icono: ImageVector, val ruta: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavController,
) {
    var userProfile by remember {
        mutableStateOf(
            UserProfile(
                name = "Cristian Sebastian Delgado Calvache",
                birthDate = "05 de septiembre de 2002",
                email = "sdp402@gmail.com",
                location = "POPAYAN-Cauca-Colombia",
                phone = "3214567890",
                document = "19861598659864",
                experienceFile = "CERTIFICADOEXPERIENCIA.DOCX",
                certification = "5678876445436"
            )
        )
    }

    val drawerState = rememberDrawerState(DrawerValue.Closed)
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
                            text = userProfile.name,
                            fontSize = 16.sp
                        )
                        Text(
                            text = userProfile.email,
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    }
                }

                Divider()

                // Drawer menu items with navigation
                val menuItems = listOf(
                    MenuItem("Mi Perfil", Icons.Default.Person, "my_perfil_Inver"),
                    MenuItem("Inicio", Icons.Default.Home, "HomeInver"),
                    MenuItem("Búsqueda por categoría", Icons.Default.Search, "busquedaInver"),
                    MenuItem("Lista de emprendimientos", Icons.Default.List, "Lista_de_emprendimientosInver"),
                    MenuItem("Notificaciones", Icons.Default.Notifications, "notificacionesInver"),
                    MenuItem("Cerrar Sesión", Icons.Default.ExitToApp, "cerrar_cesion"),
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
        val scrollState = rememberScrollState()

        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text("Perfil", color = Color.White) },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
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
                                    onClick = {
                                        navController.navigate(AppScreens.ProfileEditScreen.route)
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFF2C2C2C)
                                    )
                                ) {
                                    Text("Editar perfil")
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
}

@Composable
private fun ProfileField(label: String, value: String) {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
        Text(text = label, fontSize = 14.sp, color = Color.Gray)
        Text(text = value, fontSize = 16.sp, fontWeight = FontWeight.Normal, modifier = Modifier.padding(4.dp))
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ProfileScreenPreview() {
//    val navController = rememberNavController()
//    ProfileScreen(navController = navController)
//}
