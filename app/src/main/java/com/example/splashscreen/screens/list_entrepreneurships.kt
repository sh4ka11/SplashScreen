import androidx.compose.foundation.BorderStroke
import com.example.splashscreen.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.navigation.AppScreens
import kotlinx.coroutines.launch

data class BusinessItem(
    val name: String,
    val description: String,
    val backgroundImageRes: Int,
    val logoImageRes: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BusinessListView(
    navController: NavController,
    modifier: Modifier = Modifier,
    onVisitClick: (BusinessItem) -> Unit = {}
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val businesses = listOf(
        BusinessItem(
            name = "VINO EL ÉXTASIS",
            description = "AQUEL QUE VINO AL MUNDO Y NO TOMÓ VINO, ¿ENTONCES A QUÉ VINO?",
            backgroundImageRes = R.drawable.fondovino,
            logoImageRes = R.drawable.logovino
        ),
        BusinessItem(
            name = "AREPA PURO MAIZ",
            description = "Somos un emprendimiento enfocado en el procesamiento y comercialización de arepas de todo tipo.",
            backgroundImageRes = R.drawable.fondovino,
            logoImageRes = R.drawable.arepas
        ),
        BusinessItem(
            name = "CARNES LA BUENA VACA",
            description = "Somos un emprendimiento enfocado en el procesamiento de carnes rojas.",
            backgroundImageRes = R.drawable.fondovino,
            logoImageRes = R.drawable.arepas
        ),
        BusinessItem(
            name = "RESTAURANTE DON MIGUEL",
            description = "Restaurante familiar enfocado en darle la mayor atención al cliente para que se sienta satisfecho con nuestros productos.",
            backgroundImageRes = R.drawable.fondovino,
            logoImageRes = R.drawable.arepas
        )
    )

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(300.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                // Sección de perfil en el drawer
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

                listOf(
                    Triple("Mi Perfil", Icons.Default.Person, "user_profile_main_view"),
                    Triple("Inicio", Icons.Default.Home, "HomePrincipal"),
                    Triple("Búsqueda por categoría", Icons.Default.Search, "busqueda"),
                    Triple("Lista de emprendimientos", Icons.Default.List, "Lista de emprendimientos"),
                    Triple("Notificaciones", Icons.Default.Notifications, "NotificacionesUsu"),
                    Triple("Cerrar Sesión", Icons.Default.ExitToApp, "cerrar cesion"),
                    Triple("Ayuda", Icons.Default.Info, "ayuda")
                ).forEach { (texto, icono, route) ->
                    NavigationDrawerItem(
                        icon = { Icon(icono, contentDescription = texto) },
                        label = { Text(texto) },
                        selected = false,
                        onClick = {
                            scope.launch {
                                navController.navigate(route)
                                drawerState.close()
                            }
                        }
                    )
                }
            }
        }
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            // Top App Bar
            CenterAlignedTopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Profile Image
                        Image(
                            painter = painterResource(id = R.drawable.image3_647598),
                            contentDescription = "Profile picture",
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        // User Info
                        Column {
                            Text(
                                text = "Usuario",
                                color = Color.Black,
                                fontSize = 16.sp
                            )
                            Text(
                                text = "usuario@email.com",
                                color = Color.Gray,
                                fontSize = 12.sp
                            )
                        }
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

            // Title
            Text(
                text = "EMPRENDIMIENTOS",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF5F5F5))
                    .padding(vertical = 12.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF333333)
                )
            )

            // Business List
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(businesses) { business ->
                    BusinessCard(
                        business = business,
                        navController = navController,
                        onVisitClick = { onVisitClick(business) }
                    )
                }
            }
        }
    }
}

@Composable
private fun BusinessCard(
    business: BusinessItem,
    navController: NavController,
    onVisitClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box {
            Column {
                // Background Image
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                ) {
                    Image(
                        painter = painterResource(id = business.backgroundImageRes),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Transparent,
                                        Color.Black.copy(alpha = 0.3f)
                                    )
                                )
                            )
                    )
                }

                Spacer(modifier = Modifier.height(40.dp))

                // Business Name
                Text(
                    text = business.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    textAlign = TextAlign.Center
                )

                // Description
                Text(
                    text = business.description,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    color = Color.Gray
                )

                // Visit Button
                Button(
                    onClick = {navController.navigate(AppScreens.WineShopApp.route)},
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(vertical = 16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black
                    ),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(
                        text = "Visitar",
                        modifier = Modifier.padding(horizontal = 24.dp),
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }

            // Logo
            Surface(
                modifier = Modifier
                    .size(70.dp)
                    .align(Alignment.TopCenter)
                    .offset(y = 145.dp),
                shape = CircleShape,
                border = BorderStroke(2.dp, Color.White),
                color = Color.White
            ) {
                Image(
                    painter = painterResource(id = business.logoImageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxSize(),
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewBusinessListView() {
//    val navController = rememberNavController()
//    BusinessListView(navController = navController)
//}