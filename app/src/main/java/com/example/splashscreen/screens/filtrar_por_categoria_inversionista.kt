package com.example.splashscreen.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.splashscreen.R
import kotlinx.coroutines.launch

data class Categorias(
    val nombre: String,
    val icono: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BusquedaFilinver() {
    var searchText by remember { mutableStateOf("") }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    // Lista de categorías
    val categorias = remember {
        listOf(
            Categorias("Articulos deportivos", R.drawable.deportes),
            Categorias("Articulos para el hogar", R.drawable.hogar),
            Categorias("Electronica", R.drawable.electronica),
            Categorias("Indumentaria", R.drawable.indumentaria),
            Categorias("Instrumentos musicales", R.drawable.musica),
            Categorias("Productos para mascotas", R.drawable.mascotas),
            Categorias("Suministros de oficina", R.drawable.oficina),
            Categorias("Artesanias", R.drawable.artesanias),
            Categorias("Herramientas de trabajo", R.drawable.herramientas),
            Categorias("Educacion", R.drawable.educacion),
            Categorias("Alimentacion", R.drawable.alimentacion),
            Categorias("Vehiculos", R.drawable.vehiculos)
        )
    }

    // Filtrar categorías basado en el texto de búsqueda
    val categoriasFiltradas = remember(searchText) {
        if (searchText.isEmpty()) {
            categorias
        } else {
            categorias.filter {
                it.nombre.lowercase().contains(searchText.lowercase())
            }
        }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(300.dp)
            ) {
                Column(
                    modifier = Modifier.padding(vertical = 16.dp),
                    horizontalAlignment = Alignment.Start // Alinea el contenido a la izquierda
                ) {
                    // Imagen del perfil con margen a la izquierda
                    Image(
                        painter = painterResource(id = R.drawable.imagenrealdesebas),
                        contentDescription = "Perfil",
                        modifier = Modifier
                            .width(100.dp) // Ajusta el ancho según lo que desees
                            .height(100.dp) // Mantiene la altura
                            .padding(start = 8.dp) // Aplica un pequeño margen a la izquierda
                    )

                    // Nombre de usuario
                    Text(
                        text = "Inversionista",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 16.dp, top = 8.dp)
                    )

                    // Correo electrónico
                    Text(
                        text = "usuario@example.com",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
                    )

                    // Línea divisoria
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        color = Color.LightGray
                    )
                }

                // Elementos del menú
                val items = listOf(
                    Pair(Icons.Default.Person, "Mi Perfil"),
                    Pair(Icons.Default.Home, "Inicio"),
                    Pair(Icons.Default.Search, "Busqueda por categoria"),
                    Pair(Icons.Default.Share, "Consultar redes"),
                    Pair(Icons.Default.List, "Lista de emprendimientos"),
                    Pair(Icons.Default.Notifications, "Notificaciones"),
                    Pair(Icons.Default.Email, "Chat"),
                    Pair(Icons.Default.ExitToApp, "Cerrar Sesión") // Nueva opción de cerrar sesión
                )

                // Usar LazyColumn para hacer que el menú sea desplazable
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(items) { (icon, label) ->
                        NavigationDrawerItem(
                            icon = { Icon(icon, contentDescription = label) },
                            label = { Text(label) },
                            selected = false,
                            onClick = {
                                scope.launch {
                                    if (label == "Cerrar Sesión") {
                                        // Aquí puedes agregar la lógica para cerrar sesión
                                        // Por ejemplo: logoutUser()
                                    }
                                    drawerState.close()
                                }
                            }
                        )
                    }

                    item {
                        Spacer(modifier = Modifier.weight(1f)) // Empuja "Ayuda" hacia abajo
                    }

                    item {
                        Spacer(modifier = Modifier.height(120.dp)) // Ajusta la altura según lo que desees
                    }

                    item {
                        NavigationDrawerItem(
                            icon = { Icon(Icons.Default.Info, contentDescription = "Ayuda") },
                            label = { Text("Ayuda") },
                            selected = false,
                            onClick = {
                                scope.launch { drawerState.close() }
                            }
                        )
                    }
                }
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xffd9d9d9))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // Header con menú y logo
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
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
                            tint = Color.Black
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.sinfondo),
                        contentDescription = "Logo",
                        modifier = Modifier.size(212.dp, 82.dp)
                    )
                    Spacer(modifier = Modifier.width(35.dp))
                }

                // Campo de búsqueda
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    TextField(
                        value = searchText,
                        onValueChange = { searchText = it },
                        placeholder = { Text("Buscar...") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White, RoundedCornerShape(30.dp)),
                        trailingIcon = {
                            Image(
                                painter = painterResource(id = R.drawable.lupa),
                                contentDescription = "Buscar",
                                modifier = Modifier.size(24.dp)
                            )
                        },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            disabledContainerColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(30.dp)
                    )
                }

                Text(
                    text = "Sugerencias para ti",
                    modifier = Modifier.padding(vertical = 16.dp),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal
                )

                // Lista de categorías filtradas
                if (categoriasFiltradas.isNotEmpty()) {
                    LazyColumn {
                        items(categoriasFiltradas) { categoria ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = categoria.icono),
                                    contentDescription = categoria.nombre,
                                    modifier = Modifier.size(33.dp, 30.dp)
                                )
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(
                                    text = categoria.nombre,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Normal,
                                    modifier = Modifier.weight(1f)
                                )
                            }
                        }
                    }
                } else {
                    // Mensaje de no resultados
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.telescopio),
                                contentDescription = "No se encontraron resultados",
                                modifier = Modifier.size(187.dp)
                            )
                            Text(
                                text = "No se encontraron resultados",
                                fontSize = 15.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusquedaFilinverPreview() {
    MaterialTheme {
        BusquedaFilinver()
    }
}
