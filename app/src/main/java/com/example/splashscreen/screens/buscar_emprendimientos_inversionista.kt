package com.example.splashscreen.screens

import MenuItem
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import com.example.splashscreen.R
import com.example.splashscreen.navigation.AppScreens

data class Emprendimiento(
    val nombre: String,
    val descripcion: String,
    val imagen: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Busquedaemprendeinver(navController: NavController) {
    var searchText by remember { mutableStateOf("") }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val emprendimientos = listOf(
        Emprendimientos("Vinos el éxtasis", "Empresa procesadora de vino con productos artesanales de calidad", R.drawable.vino),
        Emprendimientos("Arepas", "Empresa de arepas frescas y caseras que trae el sabor auténtico de Colombia", R.drawable.arepas),
        Emprendimientos("Escritorios", "Fabricante de escritorios ergonómicos para espacios de trabajo cómodos", R.drawable.escritorios),
        Emprendimientos("Artesanías", "Venta de artesanías locales hechas a mano con materiales sostenibles", R.drawable.artesanias)
    )

    val filteredEmprendimientos = emprendimientos.filter {
        it.nombre.contains(searchText, ignoreCase = true)
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

            }}
        }
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD9D9D9))
            .padding(16.dp)) {
            // Header con menú y logo
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(70.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { scope.launch { if (drawerState.isClosed) drawerState.open() else drawerState.close() } }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu", tint = Color.Black)
                }

                Image(painter = painterResource(id = R.drawable.sinfondo), contentDescription = "Logo", modifier = Modifier.height(70.dp))
                Spacer(modifier = Modifier.width(48.dp))
            }

            // Cuadro de búsqueda
            OutlinedTextField(
                value = searchText,
                onValueChange = { searchText = it },
                placeholder = { Text("Buscar...") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .background(Color.White)
            )

            // Lista de Cards
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(filteredEmprendimientos) { emprendimiento ->
                    EmprendimientoCards(emprendimiento, navController)
                }
            }
        }
    }
}
@Composable
fun EmprendimientoCards(emprendimiento: Emprendimientos, navController: NavController) {
    var isExpanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth() // Se adapta al ancho completo de la pantalla
            .height(300.dp) // Ajusta la altura para hacerlo más grande
            .padding(8.dp)
            .border(1.dp, Color.Black),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        // Usamos un Box para permitir la colocación flexible de los elementos
        Box(modifier = Modifier.fillMaxSize()) {
            // Contenedor de imagen y texto
            Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = emprendimiento.imagen),
                    contentDescription = emprendimiento.nombre,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp) // Aumenta el tamaño de la imagen
                )

                Text(
                    text = emprendimiento.nombre,
                    fontSize = 20.sp, // Aumenta el tamaño de la fuente
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp)
                )

                Column(modifier = Modifier.fillMaxWidth()) {
                    val description = if (isExpanded) emprendimiento.descripcion else emprendimiento.descripcion.take(60) + if (emprendimiento.descripcion.length > 60) "..." else ""
                    Text(
                        text = description,
                        fontSize = 14.sp, // Ajuste de tamaño de texto
                        maxLines = if (isExpanded) Int.MAX_VALUE else 3,
                        overflow = TextOverflow.Ellipsis
                    )
                    if (emprendimiento.descripcion.length > 60) {
                        Text(
                            text = if (isExpanded) "Ver menos" else "Ver más",
                            color = Color.Black,
                            fontSize = 12.sp,
                            modifier = Modifier
                                .clickable { isExpanded = !isExpanded }
                                .padding(top = 4.dp)
                        )
                    }
                }
            }

            // Aquí colocamos el botón en la parte inferior derecha
            Row(
                modifier = Modifier
                    .align(Alignment.BottomEnd) // Alineación en la parte inferior derecha
                    .padding(16.dp) // Espaciado para no estar pegado al borde
            ) {
                Button(
                    onClick = {navController.navigate(AppScreens.WineShopApp.route)}, // Navegación
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .height(40.dp) // Ajusta la altura del botón
                        .width(120.dp) // Ajusta el ancho del botón
                ) {
                    Text("Visitar", fontSize = 14.sp) // Texto del botón
                }
            }
        }
    }
}