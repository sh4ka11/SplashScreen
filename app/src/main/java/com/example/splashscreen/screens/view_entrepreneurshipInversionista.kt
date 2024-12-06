package com.example.splashscreen.screens



import MenuItem
import androidx.compose.animation.*
import androidx.compose.foundation.*
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.R
import com.example.splashscreen.navigation.NavigationItem
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VinotecaEcstasyApp(navController: NavController) {
    var mostrarInfoContacto by remember { mutableStateOf(true) }
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
    )
         {

            EmprendeInversorMainView(navController)
        }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Profile Image


                        Spacer(modifier = Modifier.width(12.dp))


                    }
                },
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
                            contentDescription = "Menú",
                            tint = Color.Black
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.White
                )
            )
        }


    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
                .padding(padding)
        ) {
            item {
                AnimatedVisibility(
                    visible = mostrarInfoContacto,
                    enter = expandVertically() + fadeIn(),
                    exit = shrinkVertically() + fadeOut()
                ) {
                    TarjetaContacto()
                }
            }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Descripción",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Text(
                        text = "Experimenta la magia del vino: Un viaje sensorial único...",
                        fontSize = 14.sp,
                        color = Color.DarkGray,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }

            item {
                TarjetaProducto(
                    titulo = "Vino tinto Malbec argentino",
                    descripcion = "Sumérgete en un torbellino de sensaciones con este vino tinto Malbec argentino, una oda a la intensidad y la expresión.",
                    imagenRecurso = R.drawable.vino1,
                    precio = "$29.99"
                )
            }

            item {
                TarjetaProducto(
                    titulo = "Vino rosado Pinot Noir de Francia",
                    descripcion = "Deléitate con la delicadeza y el encanto de este vino rosado Pinot Noir francés...",
                    imagenRecurso = R.drawable.vino2,
                    precio = "$25.99"
                )
            }

            item {
                TarjetaProducto(
                    titulo = "Vino blanco Chardonnay de California",
                    descripcion = "Disfruta de la frescura y la elegancia de este vino blanco Chardonnay californiano...",
                    imagenRecurso = R.drawable.vino3,
                    precio = "$32.99"
                )
            }

            item {
                TarjetaProducto(
                    titulo = "Vino espumoso Prosecco italiano",
                    descripcion = "Celebra con cada burbuja de este Prosecco italiano, ideal para acompañar momentos especiales.",
                    imagenRecurso = R.drawable.vino4,
                    precio = "$38.99"
                )
            }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .background(Color(0xFFEFEFEF))
                        .border(2.dp, Color.Black, shape = RoundedCornerShape(8.dp))
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Experimenta la magia del vino: Un viaje sensorial único",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.DarkGray,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.DarkGray)) {
                                append("Más que una bebida, una pasión: ")
                            }
                            append("Embárcate en un viaje sensorial sin igual donde cada gota te invita a descubrir un universo de sabores, aromas y tradición.\n\n")

                            withStyle(style = SpanStyle(color = Color.DarkGray)) {
                                append("Un legado familiar: ")
                            }
                            append("Sumérgete en la historia que cada botella cuenta, un relato de tradición familiar, innovación y dedicación inquebrantable.\n\n")

                            withStyle(style = SpanStyle(color = Color.DarkGray)) {
                                append("Explora un mundo fascinante: ")
                            }
                            append("Descubre la complejidad de sabores y aromas que cada cepa ofrece y déjate cautivar por la magia del vino.\n\n")

                            withStyle(style = SpanStyle(color = Color.DarkGray)) {
                                append("Más que un producto, una experiencia: ")
                            }
                            append("Únete a nuestra comunidad, participa en vendimias, degusta nuestros vinos y descubre por qué somos más que un simple líquido.\n\n")

                            withStyle(style = SpanStyle(color = Color.DarkGray)) {
                                append("Forma parte de la experiencia: ")
                            }
                            append("Disfruta de eventos exclusivos, talleres de cata y momentos inolvidables en torno a una copa de vino.")
                        },
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun TarjetaContacto() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .shadow(8.dp, RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.imagenrealdesebas),
                    contentDescription = "Imagen de Perfil",
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color(0xFF2B0000), CircleShape)
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(
                        text = "CRISTIAN SEBASTIAN DELGADO",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2B0000)
                    )
                    Text(
                        text = "Fundador & Sommelier",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Divider(color = Color(0xFFEEEEEE), thickness = 1.dp)
            Spacer(modifier = Modifier.height(16.dp))

            FilaInfoContacto(
                icono = Icons.Filled.Email,
                texto = "Cristiansdp@gmail.com",
                onClick = { }
            )
            FilaInfoContacto(
                icono = Icons.Filled.Phone,
                texto = "320-898-7646",
                onClick = { }
            )
            FilaInfoContacto(
                icono = Icons.Filled.LocationOn,
                texto = "Subida Lucía, 40 - Jersey City, Gal / 86551",
                onClick = { }
            )
            FilaInfoContacto(
                icono = Icons.Filled.Place,
                texto = "POPAYÁN",
                onClick = { }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                BotonRedSocial(icono = Icons.Filled.Favorite)
                BotonRedSocial(icono = Icons.Filled.Send)
                BotonRedSocial(icono = Icons.Filled.Person)
                BotonRedSocial(icono = Icons.Filled.Email)
            }
        }
    }
}

@Composable
fun FilaInfoContacto(icono: ImageVector, texto: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icono,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = Color(0xFF2B0000)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = texto,
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun BotonRedSocial(icono: ImageVector) {
    IconButton(onClick = { }) {
        Icon(
            imageVector = icono,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = Color(0xFF2B0000)
        )
    }
}

@Composable
fun TarjetaProducto(titulo: String, descripcion: String, imagenRecurso: Int, precio: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .shadow(4.dp, RoundedCornerShape(8.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = imagenRecurso),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = titulo, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = descripcion, fontSize = 14.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = precio, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color(0xFF2B0000))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VistaPreviewVinotecaApp() {
    VinotecaEcstasyApp(navController = rememberNavController())
}