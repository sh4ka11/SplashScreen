package com.example.splashscreen.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import com.example.splashscreen.R

data class Emprendimiento(
    val nombre: String,
    val descripcion: String,
    val imagen: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Busquedaemprendeinver(navController: NavHostController) {
    var searchText by remember { mutableStateOf("") }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val emprendimientos = listOf(
        Emprendimiento("Vinos el éxtasis", "Empresa procesadora de vino con productos artesanales de calidad", R.drawable.vino),
        Emprendimiento("Arepas", "Empresa de arepas frescas y caseras que trae el sabor auténtico de Colombia", R.drawable.arepas),
        Emprendimiento("Escritorios", "Fabricante de escritorios ergonómicos para espacios de trabajo cómodos", R.drawable.escritorios),
        Emprendimiento("Artesanías", "Venta de artesanías locales hechas a mano con materiales sostenibles", R.drawable.artesanias)
    )

    val filteredEmprendimientos = emprendimientos.filter {
        it.nombre.contains(searchText, ignoreCase = true)
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(modifier = Modifier.width(300.dp)) {
                Column(modifier = Modifier.padding(vertical = 16.dp), horizontalAlignment = Alignment.Start) {
                    // Imagen del perfil
                    Image(
                        painter = painterResource(id = R.drawable.imagenrealdesebas),
                        contentDescription = "Perfil",
                        modifier = Modifier.fillMaxWidth().height(100.dp)
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
                    Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp), color = Color.LightGray)
                }
                // Opciones del menú
                val menuItems = listOf(
                    Pair(Icons.Default.Person, "Mi Perfil"),
                    Pair(Icons.Default.Home, "Inicio"),
                    Pair(Icons.Default.Search, "Busqueda por categoria"),
                    Pair(Icons.Default.Share, "Consultar redes"),
                    Pair(Icons.Default.List, "Lista de emprendimientos"),
                    Pair(Icons.Default.Notifications, "Notificaciones"),
                    Pair(Icons.Default.Email, "Chat"),
                    Pair(Icons.Default.ExitToApp, "Cerrar Sesión")
                )

                LazyColumn {
                    items(menuItems) { (icon, label) ->
                        NavigationDrawerItem(
                            icon = { Icon(icon, contentDescription = label) },
                            label = { Text(label) },
                            selected = false,
                            onClick = { scope.launch { drawerState.close() } }
                        )
                    }

                    // Espaciador para empujar "Ayuda" hacia abajo
                    item { Spacer(modifier = Modifier.weight(1f)) }

                    // Espaciador adicional para ajustar la altura
                    item { Spacer(modifier = Modifier.height(120.dp)) }

                    // Opción "Ayuda"
                    item {
                        NavigationDrawerItem(
                            icon = { Icon(Icons.Default.Info, contentDescription = "Ayuda") },
                            label = { Text("Ayuda") },
                            selected = false,
                            onClick = { scope.launch { drawerState.close() } }
                        )
                    }
                }
            }
        }
    ) {
        Column(modifier = Modifier.fillMaxSize().background(Color(0xFFD9D9D9)).padding(16.dp)) {
            // Header con menú y logo
            Row(modifier = Modifier.fillMaxWidth().height(70.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
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
                modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp).background(Color.White)
            )

            // Lista de cards agrupadas en filas
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(filteredEmprendimientos.chunked(2)) { rowItems ->
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        rowItems.forEach { emprendimiento ->
                            EmprendimientosCard(emprendimiento, navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun EmprendimientosCard(emprendimiento: Emprendimiento, navController: NavHostController) {
    var isExpanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.width(180.dp).height(250.dp).padding(8.dp).border(1.dp, Color.Black),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = emprendimiento.imagen),
                contentDescription = emprendimiento.nombre,
                modifier = Modifier.fillMaxWidth().height(100.dp)
            )
            Text(
                text = emprendimiento.nombre,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 4.dp)
            )

            Column(modifier = Modifier.fillMaxWidth()) {
                val description = if (isExpanded) emprendimiento.descripcion else emprendimiento.descripcion.take(40) + if (emprendimiento.descripcion.length > 40) "..." else ""
                Text(
                    text = description,
                    fontSize = 12.sp,
                    maxLines = if (isExpanded) Int.MAX_VALUE else 2,
                    overflow = TextOverflow.Ellipsis
                )
                if (emprendimiento.descripcion.length > 40) {
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

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Button(
                    onClick = { navController.navigate("visitarEmprendimientoVino") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black, contentColor = Color.White),
                    modifier = Modifier
                        .padding(4.dp)
                        .width(90.dp)
                        .height(30.dp)
                ) {
                    Text("Visitar", fontSize = 12.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBusquedaEmprendimientos() {
    // Aquí puedes agregar un NavHostController si lo necesitas para pruebas.
    Busquedaemprendeinver(navController = rememberNavController())
}
