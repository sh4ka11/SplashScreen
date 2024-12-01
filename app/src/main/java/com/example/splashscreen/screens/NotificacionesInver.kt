package com.example.splashscreen.screens

import MenuItem
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.R
import kotlinx.coroutines.launch
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.input.key.Key
import com.example.splashscreen.navigation.AppScreens

data class NotificacionInver(
    val tituloInver: String,
    val mensajeInver: String,
    val horaInver: String,
    val imageResourceIdInver: Int = R.drawable.image3_647598
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificacionesInver(
    navController: NavController,
    onNavigateToScreenInver: (String) -> Unit = {}
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    var searchInverQuery by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    val notificacionesInver = remember {
        listOf(
            NotificacionInver(
                "\"Usuario\" te envió una solicitud de conexión",
                "\"Usuario\" ha solicitado unirte con tu emprendimiento, acepta la solicitud para poder crecer juntos",
                "2:15 P.M.",
                R.drawable.image3_647598
            ),
            NotificacionInver(
                "FANTA",
                "A career in website design can involve the design, creation, and coding of a range of website types. Other tasks will typically...",
                "3:15 P.M.",
                R.drawable.image238
            ),
            NotificacionInver(
                "Sprite",
                "A career in website design can involve the design, creation, and coding of a range of website types. Other tasks will typically...",
                "4:15 P.M.",
                R.drawable.image241
            ),
            NotificacionInver(
                "Sena",
                "A career in website design can involve the design, creation, and coding of a range of website types. Other tasks will typically...",
                "5:15 P.M.",
                R.drawable.image240
            ),
            NotificacionInver(
                "Sony",
                "A career in website design can involve the design, creation, and coding of a range of website types. Other tasks will typically...",
                "6:15 P.M.",
                R.drawable.image239
            )
        )
    }
    val filteredNotificaciones = notificacionesInver.filter {
        it.tituloInver.contains(searchInverQuery, ignoreCase = true) ||
                it.mensajeInver.contains(searchInverQuery, ignoreCase = true)
    }
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
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.fondo),
                contentDescription = "Fondo",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )

            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        title = {
                            Text(
                                text = "Notificaciones Inver",
                                color = Color.Black,
                                fontSize = 18.sp
                            )
                        },
                        navigationIcon = {
                            IconButton(
                                onClick = {
                                    coroutineScope.launch {
                                        if (drawerState.isClosed) drawerState.open()
                                        else drawerState.close()
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = "Menú",
                                    tint = Color.Black
                                )
                            }
                        },
                        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                            containerColor = Color.White
                        )
                    )
                },
                containerColor = Color.Transparent
            ) { paddingValuesInver ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValuesInver)
                ) {
                    TextField(
                        value = searchInverQuery,
                        onValueChange = { searchInverQuery = it },
                        placeholder = { Text("Buscar notificaciones") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Buscar") }
                    )

                    if (filteredNotificaciones.isEmpty()) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "No se encontraron notificaciones",
                                color = Color.Gray,
                                fontSize = 16.sp
                            )
                        }
                    } else {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            items(filteredNotificaciones) { notificacionInver ->
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 16.dp, vertical = 8.dp)
                                        .clickable { /* Optional: Add notification tap action */ },
                                    shape = RoundedCornerShape(12.dp),
                                    colors = CardDefaults.cardColors(containerColor = Color.White),
                                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(16.dp),
                                        verticalAlignment = Alignment.Top
                                    ) {
                                        Image(
                                            painter = painterResource(id = notificacionInver.imageResourceIdInver),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(40.dp)
                                                .clip(CircleShape)
                                                .background(Color.LightGray),
                                            contentScale = ContentScale.Crop
                                        )

                                        Spacer(modifier = Modifier.width(16.dp))

                                        Column(
                                            modifier = Modifier.weight(1f)
                                        ) {
                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween,
                                                verticalAlignment = Alignment.Top
                                            ) {
                                                Text(
                                                    text = notificacionInver.tituloInver,
                                                    fontSize = 16.sp,
                                                    color = Color.Black,
                                                    fontWeight = FontWeight.Bold,
                                                    modifier = Modifier
                                                        .weight(1f)
                                                        .padding(end = 8.dp)
                                                )
                                                Text(
                                                    text = notificacionInver.horaInver,
                                                    fontSize = 12.sp,
                                                    color = Color.Gray
                                                )
                                            }

                                            Spacer(modifier = Modifier.height(4.dp))

                                            Text(
                                                text = notificacionInver.mensajeInver,
                                                fontSize = 14.sp,
                                                color = Color.Gray,
                                                maxLines = 2,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                            Spacer(modifier = Modifier.height(8.dp))
                                            // Added "Ver más" button
                                            Button(
                                                onClick = { navController.navigate(AppScreens.Notificaciones2Inver.route) },
                                                modifier = Modifier
                                                    .align(Alignment.End)
                                                    .padding(top = 8.dp),
                                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1C1B1F))
                                            ) {
                                                Text(text = "Ver más", color = Color.White)
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 430, heightDp = 894)
@Composable
fun NotificacionesInverPreview() {
    val navController = rememberNavController()
    NotificacionesInver(navController = navController)
}
