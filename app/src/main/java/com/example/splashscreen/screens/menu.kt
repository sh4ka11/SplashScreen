//import androidx.compose.animation.*
//import androidx.compose.foundation.*
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.*
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.draw.shadow
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.SpanStyle
//import androidx.compose.ui.text.buildAnnotatedString
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.text.withStyle
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import kotlinx.coroutines.launch
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.foundation.gestures.Orientation
//import androidx.compose.foundation.gestures.scrollable
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.navigation.compose.currentBackStackEntryAsState
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun WineShopMenuApp(navController: NavController) {
//    var showContactInfo by remember { mutableStateOf(true) }
//    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
//    val scope = rememberCoroutineScope()
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    val currentRoute = navBackStackEntry?.destination?.route
//
//    ModalNavigationDrawer(
//        drawerState = drawerState,
//        drawerContent = {
//            ModalDrawerSheet {
//                Spacer(modifier = Modifier.height(16.dp))
//                Text(
//                    "Menú",
//                    modifier = Modifier.padding(16.dp),
//                    style = MaterialTheme.typography.titleLarge
//                )
//                Divider()
//                NavigationDrawerItem(
//                    label = { Text("Inicio") },
//                    selected = currentRoute == Screen.Home.route,
//                    onClick = {
//                        scope.launch {
//                            drawerState.close()
//                            navController.navigate(Screen.Home.route) {
//                                popUpTo(Screen.Home.route) { inclusive = true }
//                            }
//                        }
//                    },
//                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
//                )
//                NavigationDrawerItem(
//                    label = { Text("Catálogo") },
//                    selected = currentRoute == Screen.Catalog.route,
//                    onClick = {
//                        scope.launch {
//                            drawerState.close()
//                            navController.navigate(Screen.Catalog.route)
//                        }
//                    },
//                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
//                )
//                NavigationDrawerItem(
//                    label = { Text("Contacto") },
//                    selected = currentRoute == Screen.Contact.route,
//                    onClick = {
//                        scope.launch {
//                            drawerState.close()
//                            navController.navigate(Screen.Contact.route)
//                        }
//                    },
//                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
//                )
//                NavigationDrawerItem(
//                    label = { Text("Acerca de") },
//                    selected = currentRoute == Screen.About.route,
//                    onClick = {
//                        scope.launch {
//                            drawerState.close()
//                            navController.navigate(Screen.About.route)
//                        }
//                    },
//                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
//                )
//            }
//        }
//    ) {
//        Scaffold(
//            topBar = {
//                CenterAlignedTopAppBar(
//                    title = { Text("Emprede Link", fontWeight = FontWeight.Bold, color = Color.White) },
//                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
//                        containerColor = Color.Black
//                    ),
//                    navigationIcon = {
//                        IconButton(
//                            onClick = {
//                                scope.launch {
//                                    drawerState.open()
//                                }
//                            }
//                        ) {
//                            Icon(
//                                imageVector = Icons.Default.Menu,
//                                contentDescription = "Menu",
//                                tint = Color.White
//                            )
//                        }
//                    },
//                    actions = {
//                        IconButton(onClick = { showContactInfo = !showContactInfo }) {
//                            Icon(
//                                imageVector = if (showContactInfo) Icons.Filled.Person else Icons.Filled.Warning,
//                                contentDescription = "Toggle Contact Info",
//                                tint = Color.White
//                            )
//                        }
//                    },
//                    modifier = Modifier.shadow(4.dp)
//                )
//            }
//        ) { padding ->
//            LazyColumn(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color(0xFFF5F5F5))
//                    .padding(padding)
//            ) {
//                // Mantén el contenido existente de tu LazyColumn aquí
//                // ...
//            }
//        }
//    }
//}
//
//
//@Composable
//fun CatalogScreen(navController: NavController) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        Text(
//            text = "Catálogo de Vinos",
//            style = MaterialTheme.typography.headlineMedium,
//            modifier = Modifier.padding(bottom = 16.dp)
//        )
//        // Aquí puedes agregar el contenido de tu catálogo
//    }
//}
//
//@Composable
//fun ContactScreen(navController: NavController) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        Text(
//            text = "Contacto",
//            style = MaterialTheme.typography.headlineMedium,
//            modifier = Modifier.padding(bottom = 16.dp)
//        )
//        // Aquí puedes agregar el contenido de la página de contacto
//    }
//}
//
//@Composable
//fun AboutScreen(navController: NavController) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        Text(
//            text = "Acerca de Nosotros",
//            style = MaterialTheme.typography.headlineMedium,
//            modifier = Modifier.padding(bottom = 16.dp)
//        )
//        // Aquí puedes agregar el contenido de la página "Acerca de"
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewMenuApp() {
//    WineShopMenuApp(navController = rememberNavController())
//}
