    package com.example.splashscreen.screens
    
    import androidx.compose.foundation.Image
    import androidx.compose.foundation.layout.*
    import androidx.compose.foundation.shape.CircleShape
    import androidx.compose.foundation.shape.RoundedCornerShape
    import androidx.compose.material3.*
    import androidx.compose.runtime.*
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.draw.clip
    import androidx.compose.ui.layout.ContentScale
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.text.style.TextAlign
    import androidx.compose.ui.text.style.TextOverflow
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import androidx.navigation.compose.rememberNavController
    import com.example.splashscreen.R
    import androidx.compose.ui.draw.clipToBounds
    import androidx.compose.foundation.background
    import androidx.compose.foundation.clickable
    import androidx.compose.foundation.rememberScrollState
    import androidx.compose.foundation.verticalScroll
    import androidx.compose.material.icons.Icons
    import androidx.compose.material.icons.filled.*
    import androidx.compose.runtime.rememberCoroutineScope
    import androidx.navigation.NavHostController
    import com.example.splashscreen.navigation.AppScreens
    import kotlinx.coroutines.launch


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun HomeScreen(navController: NavHostController) {
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
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
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
    
                // Main content
                EmprendeMainView(navController)
            }
        }
    }
    
    @Composable
    fun EmprendeMainView(navController: NavHostController) {
        Box(
            contentAlignment = Alignment.TopStart,
            modifier = Modifier
                .background(Color(0xff000000))
                .size(430.dp, 2536.dp)
                .clipToBounds(),
        ) {
            // Image-751:115
            Image(
                painter = painterResource(id = R.drawable.image1_751115),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .size(438.dp, 633.dp),
            )
    
            // Empty boxes
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .size(430.dp, 960.dp),
            )
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .size(430.dp, 960.dp),
            )
    
            // Rectangle 738
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 0.dp, y = 176.dp)
                    .background(Color(0xfff5f5f3))
                    .size(430.dp, 451.dp),
            )
    
            // Main title text
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 16.dp, y = 241.dp)
                    .size(417.dp, 82.dp),
                text = "¡El enlace de emprendedores\n con  inversionistas!",
                color = Color(0xff000000),
                fontSize = 25.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
            )
    
            // Description text
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 23.dp, y = 338.dp)
                    .size(393.dp, 144.dp),
                text = "Emprende Link busca facilitar la colaboración y el crecimiento empresarial al conectar de manera  eficiente a emprendedores con grandes empresas, creando oportunidades para el desarrollo  conjunto de soluciones innovadoras.",
                color = Color(0xb2000000),
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
    
            // Button background
            Button(
                onClick = { navController.navigate(AppScreens.PublicarEmprendimientoView.route) },                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 94.dp, y = 545.dp)
                    .size(222.dp, 46.dp)
                    .background(Color(0xff38352e), RoundedCornerShape(10.dp)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff38352e), // Fondo del botón
                    contentColor = Color(0xffffffff)    // Color del texto
                ),
                shape = RoundedCornerShape(10.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "Crea tu emprendimiento",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis
                )
            }


            // Ready to start text
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 105.dp, y = 497.dp)
                    .size(223.dp, 33.dp),
                text = "¿Listo para comenzar?",
                color = Color(0xb2000000),
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
    
            // Black rectangle
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = -5.dp, y = 627.dp)
                    .background(Color(0xff000000))
                    .size(435.dp, 171.dp),
            )
    
            // Create your venture text
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 104.dp, y = 670.dp)
                    .size(263.dp, 105.dp),
                text = "Crea tu propio emprendimiento",
                color = Color(0xffffffff),
                fontSize = 30.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
    
            // Logo
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 69.dp, y = 14.dp)
                    .size(361.dp, 155.dp),
            )
    
            // Gray rectangle
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 0.dp, y = 798.dp)
                    .background(Color(0xffd9d9d9), RoundedCornerShape(20.dp))
                    .size(430.dp, 211.dp),
            )
    
            // Various images
            Image(
                painter = painterResource(id = R.drawable.image3_751130),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 0.dp, y = 798.dp)
                    .size(430.dp, 211.dp),
            )
    
            Image(
                painter = painterResource(id = R.drawable.image4_751131),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 1.dp, y = 2323.dp)
                    .size(430.dp, 915.dp),
            )
    
            // Emprende text
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 138.dp, y = 891.dp)
                    .size(263.dp, 105.dp),
                text = "Emprende",
                color = Color(0xffffffff),
                fontSize = 30.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
    
            // More images
            Image(
                painter = painterResource(id = R.drawable.image5_751133),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 0.dp, y = 1014.dp)
                    .size(430.dp, 211.dp),
            )
    
            // Invierte text
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 158.dp, y = 1088.dp)
                    .size(263.dp, 105.dp),
                text = "Invierte",
                color = Color(0xff000000),
                fontSize = 30.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
    
            // More images and content
            Image(
                painter = painterResource(id = R.drawable.image6_751135),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 0.dp, y = 1230.dp)
                    .size(434.dp, 211.dp),
            )
    
            // Create contacts text
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 97.dp, y = 1320.dp)
                    .size(263.dp, 105.dp),
                text = "Crear contactos",
                color = Color(0xffffffff),
                fontSize = 30.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
    
            // Description text
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 25.dp, y = 1465.dp)
                    .size(392.dp, 205.dp),
                text = "Emprende Link busca facilitar la colaboración y el crecimiento empresarial al conectar de manera  eficiente a emprendedores con grandes empresas, creando oportunidades para el desarrollo  conjunto de soluciones innovadoras.",
                color = Color(0xffffffff),
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
            )
            // Empty-751:138-Rectangle 749
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 0.dp, y = 1908.dp)
                    .background(Color(0xffffffff))
                    .size(430.dp, 415.dp),
            )
            // Empty-751:139-Rectangle 750
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 133.dp, y = 2205.dp)
                    .background(Color(0xff38352e), RoundedCornerShape(10.dp))
                    .size(167.dp, 41.dp)
                    .clickable { navController.navigate(AppScreens.UserProfileMainView.route) } // Acción onClick
            ) {
                // Text-751:140-Crear un perfil
                Text(
                    modifier = Modifier
                        .align(Alignment.Center) // Centrar el texto dentro del Box
                        .padding(start = 8.dp, end = 8.dp), // Ajustar el padding si es necesario
                    text = "Crear un perfil",
                    color = Color(0xffffffff),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center, // Centrar el texto horizontalmente
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Text-751:141-Sube de nivel tu negocio uniendote
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 60.dp, y = 1968.dp)
                    .size(323.dp, 88.dp),
                text = "Sube de nivel tu negocio \nuniendote",
                color = Color(0xff000000),
                fontSize = 25.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
            )
            // Text-751:142-Asociese con mas emprededores para poder hacer progresar a tu negocio,o encuentra provedores de difenrentes productos
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 40.dp, y = 2037.dp)
                    .size(340.dp, 168.dp),
                text = "Asociese con mas emprededores para poder hacer progresar a tu negocio,o encuentra provedores de difenrentes productos",
                color = Color(0xb2000000),
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
            )
    // Text-751:143-chat de emprendedores
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 87.dp, y = 1943.dp)
                    .size(269.dp, 25.dp),
                text = "chat de emprendedores",
                color = Color(0xb2000000),
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
            )
    // logo
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 40.dp, y = 2335.dp)
                    .size(374.dp, 132.dp),
            )
    // Text-751:145-2024 Emprende Link l Acerca de l politaca de privaciadad
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 66.dp, y = 2471.dp)
                    .size(311.dp, 45.dp),
                text = " 2024 Emprende Link l Acerca de l politaca de privaciadad",
                color = Color(0xff000000),
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
            )
    // Image-751:146-image 415
            Image(
                painter = painterResource(id = R.drawable.image8_751146),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 0.dp, y = 1656.dp)
                    .size(430.dp, 256.dp),
            )
    // Image-751:147-588a6507d06f6719692a2d15 3
    
        }
    }
    
    
    
    @Preview(showBackground = true)
    @Composable
    fun HomeScreenPreview() {
        val navController = rememberNavController() // Create a NavController for preview
        HomeScreen(navController = navController) // Pass it to HomeScreen
    }