//
//package com.example.splashscreen.screens
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextOverflow
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//<<<<<<< HEAD
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.rememberNavController
//=======
//import androidx.navigation.NavController
//>>>>>>> 7b54d1c27d0e3a71a44c9feb644c033b74df8ddf
//import com.example.splashscreen.R
//
//data class Emprendimientos(
//    val nombre: String,
//    val descripcion: String,
//    val imagen: Int
//)
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//<<<<<<< HEAD
//fun BusquedaemprendeinverScreen(navController: NavHostController) {
//    ====== =
//    fun Busquedaemprendeusuario(navController: NavController) {
//        >>>>>>> 7b54d1c27d0e3a71a44c9feb644c033b74df8ddf
//        var searchText by remember { mutableStateOf("") }
//        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
//        val scope = rememberCoroutineScope()
//
//        val emprendimientos = listOf(
//            Emprendimiento(
//                "Vinos el éxtasis",
//                "Empresa procesadora de vino con productos artesanales de calidad",
//                R.drawable.vino
//            ),
//            Emprendimiento(
//                "Arepas",
//                "Empresa de arepas frescas y caseras que trae el sabor auténtico de Colombia",
//                R.drawable.arepas
//            ),
//            Emprendimiento(
//                "Escritorios",
//                "Fabricante de escritorios ergonómicos para espacios de trabajo cómodos",
//                R.drawable.escritorios
//            ),
//            Emprendimiento(
//                "Artesanías",
//                "Venta de artesanías locales hechas a mano con materiales sostenibles",
//                R.drawable.artesanias
//            )
//        )
//
//        val filteredEmprendimientos = emprendimientos.filter {
//            it.nombre.contains(searchText, ignoreCase = true)
//        }
//
//        ModalNavigationDrawer(
//            drawerState = drawerState,
//            drawerContent = {
//                // Código del Drawer Content
//            }
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color(0xFFD9D9D9))
//                    .padding(16.dp)
//            ) {
//                // Código del Header y Cuadro de Búsqueda
//
//                LazyColumn(
//                    modifier = Modifier.fillMaxWidth()
//                ) {
//                    items(filteredEmprendimientos.chunked(2)) { rowItems ->
//                        Row(
//                            modifier = Modifier.fillMaxWidth(),
//                            horizontalArrangement = Arrangement.SpaceBetween
//                        ) {
//                            rowItems.forEach { emprendimiento ->
//                                EmprendimientoCard(emprendimiento, navController)
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    @Composable
//    fun EmprendimientoCard(emprendimiento: Emprendimiento, navController: NavHostController) {
//        var isExpanded by remember { mutableStateOf(false) }
//
//        Card(
//            modifier = Modifier
//                .width(180.dp)
//                .height(250.dp)
//                .padding(8.dp)
//                .border(1.dp, Color.Black),
//            shape = RoundedCornerShape(10.dp),
//            colors = CardDefaults.cardColors(
//                containerColor = Color.White
//            )
//        ) {
//            Column(
//                modifier = Modifier.padding(8.dp),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Image(
//                    painter = painterResource(id = emprendimiento.imagen),
//                    contentDescription = emprendimiento.nombre,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(100.dp)
//                )
//                Text(
//                    text = emprendimiento.nombre,
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight.Bold,
//                    modifier = Modifier.padding(top = 4.dp)
//                )
//
//                Column(modifier = Modifier.fillMaxWidth()) {
//                    val description =
//                        if (isExpanded) emprendimiento.descripcion else emprendimiento.descripcion.take(
//                            40
//                        ) + if (emprendimiento.descripcion.length > 40) "..." else ""
//                    Text(
//                        text = description,
//                        fontSize = 12.sp,
//                        maxLines = if (isExpanded) Int.MAX_VALUE else 2,
//                        overflow = TextOverflow.Ellipsis
//                    )
//                    if (emprendimiento.descripcion.length > 40) {
//                        Text(
//                            text = if (isExpanded) "Ver menos" else "Ver más",
//                            color = Color.Black,
//                            fontSize = 12.sp,
//                            modifier = Modifier
//                                .clickable { isExpanded = !isExpanded }
//                                .padding(top = 4.dp)
//                        )
//                    }
//                }
//
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(top = 4.dp),
//                    horizontalArrangement = Arrangement.Start
//                ) {
//                    Button(
//                        onClick = {
//                            // Navegar a la ruta "visitarEmprendimientoVino"
//                            navController.navigate("PublicarEmprendimientoView")
//                        },
//                        colors = ButtonDefaults.buttonColors(
//                            containerColor = Color.Black,
//                            contentColor = Color.White
//                        ),
//                        modifier = Modifier
//                            .padding(4.dp)
//                            .width(90.dp)
//                            .height(30.dp)
//                    ) {
//                        Text("Visitar", fontSize = 12.sp)
//                    }
//                }
//            }
//        }
//    }
//
//
//    @Preview(showBackground = true)
//    @Composable
//
//    fun BuscarinverPreview() {
//        val navController = rememberNavController()
//        Busquedaemprendeinver(navController)
//    }
//
//    fun BuscarusuarioPreview() {
//        //Busquedaemprendeusuario()
//    }
//}
//
//
