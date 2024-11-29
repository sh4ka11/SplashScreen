package com.example.splashscreen.screens

import MenuItem
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.splashscreen.R
import kotlinx.coroutines.launch

data class PersonalProfiles(
    val name: String = "",
    val birthDate: String = "",
    val email: String = "",
    val location: String = "",
    val phone: String = "",
    val document: String = "",
    val gender: String = "",
    val stage: String = ""
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Editinfoinver(navController: NavController,
    onMenuClick: () -> Unit = {},
    onUpdateProfile: () -> Unit = {}
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var showImageMenu by remember { mutableStateOf(false) }
    var showUpdateDialog by remember { mutableStateOf(false) }
    val context = LocalContext.current

    var personalProfile by remember {
        mutableStateOf(
            PersonalProfiles(
                name = "Cristian Sebastian Delgado Calvache",
                birthDate = "Nacido(a) el 05 de septiembre de 2002",
                email = "sdp402@gmail.com",
                location = "POPAYAN-Cauca-Colombia",
                phone = "3214567890",
                document = "19861598659864",
                gender = "MASCULINO",
                stage = "Primera fase: la idea de negocio"
            )
        )
    }

    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }

    val cameraLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.TakePicturePreview()
    ) { bitmap ->
        // Handle camera image here
    }

    val scrollState = rememberScrollState()

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
                                    // Aquí puedes agregar la lógica para cerrar sesión
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
                // Profile Image with Edit Button
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Box(contentAlignment = Alignment.BottomEnd) {
                        Image(
                            painter = if (imageUri != null) {
                                rememberAsyncImagePainter(imageUri)
                            } else {
                                painterResource(id = android.R.drawable.ic_menu_gallery)
                            },
                            contentDescription = "Profile Picture",
                            modifier = Modifier
                                .size(120.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )

                        IconButton(
                            onClick = { showImageMenu = true },
                            modifier = Modifier
                                .size(36.dp)
                                .clip(CircleShape)
                                .background(Color.White)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = "Edit Image",
                                tint = Color.Black
                            )
                        }
                    }

                    DropdownMenu(
                        expanded = showImageMenu,
                        onDismissRequest = { showImageMenu = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("Tomar Foto") },
                            onClick = {
                                cameraLauncher.launch(null)
                                showImageMenu = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Subir Foto") },
                            onClick = {
                                galleryLauncher.launch("image/*")
                                showImageMenu = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Eliminar Foto") },
                            onClick = {
                                imageUri = null
                                showImageMenu = false
                            }
                        )
                    }
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
                        EditableField("Nombre", personalProfile.name) { personalProfile = personalProfile.copy(name = it) }
                        EditableField("Fecha de nacimiento", personalProfile.birthDate) { personalProfile = personalProfile.copy(birthDate = it) }
                        EditableField("Correo", personalProfile.email) { personalProfile = personalProfile.copy(email = it) }
                        EditableField("Ubicacion", personalProfile.location) { personalProfile = personalProfile.copy(location = it) }
                        EditableField("Celular", personalProfile.phone) { personalProfile = personalProfile.copy(phone = it) }
                        EditableField("Documento", personalProfile.document) { personalProfile = personalProfile.copy(document = it) }
                        EditableField("Experiencia", personalProfile.gender) { personalProfile = personalProfile.copy(gender = it) }
                        EditableField("Certificado", personalProfile.stage) { personalProfile = personalProfile.copy(stage = it) }

                        Button(
                            onClick = { showUpdateDialog = true },
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
            }
        }

        if (showUpdateDialog) {
            AlertDialog(
                onDismissRequest = { showUpdateDialog = false },
                title = { Text("Confirmación") },
                text = { Text("¿Está seguro de guardar los cambios?") },
                confirmButton = {
                    Button(
                        onClick = {
                            onUpdateProfile()
                            showUpdateDialog = false
                            Toast.makeText(context, "Cambios guardados", Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Text("Aceptar")
                    }
                },
                dismissButton = {
                    Button(onClick = { showUpdateDialog = false }) {
                        Text("Cancelar")
                    }
                }
            )
        }
    }
}

@Composable
private fun EditableField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    var isEditing by remember { mutableStateOf(false) }
    var currentValue by remember { mutableStateOf(value) }

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

        if (isEditing) {
            TextField(
                value = currentValue,
                onValueChange = {
                    currentValue = it
                    onValueChange(it)
                },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                )
            )
        } else {
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
                        text = currentValue,
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 12.dp, vertical = 8.dp),
                        fontSize = 16.sp
                    )

                    Row(
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        IconButton(
                            onClick = { isEditing = true }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = "Editar",
                                tint = Color.Gray
                            )
                        }

                        IconButton(
                            onClick = {
                                currentValue = ""
                                onValueChange("")
                            }
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
}
@Preview(showBackground = true, widthDp = 430, heightDp = 894)
@Composable
fun infoinverPreview() {
    val navController = rememberNavController()
    Editinfoinver(navController = navController)
}