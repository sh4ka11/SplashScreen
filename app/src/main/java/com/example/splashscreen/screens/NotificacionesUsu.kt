package com.example.splashscreen.screens

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

data class Notificacion(
    val titulo: String,
    val mensaje: String,
    val hora: String,
    val imageResourceId: Int = R.drawable.image3_647598
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificacionesUsu(
    navController: NavController,
    onNavigateToScreen: (String) -> Unit = {}
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val notificaciones = remember {
        listOf(
            Notificacion(
                "\"Usuario\" te envió una solicitud de conexión",
                "\"Usuario\" a solicitado unirte con tu emprendimiento, acepta la solicitud para poder crecer juntos",
                "2:15 P.M.",
                R.drawable.image3_647598
            ),
            Notificacion(
                "FANTA",
                "A career in website design can involve the design, creation, and coding of a range of website types. Other tasks will typically...",
                "3:15 P.M.",
                R.drawable.image238
            ),
            Notificacion(
                "Sprite",
                "A career in website design can involve the design, creation, and coding of a range of website types. Other tasks will typically...",
                "4:15 P.M.",
                R.drawable.image241
            ),
            Notificacion(
                "Sena",
                "A career in website design can involve the design, creation, and coding of a range of website types. Other tasks will typically...",
                "5:15 P.M.",
                R.drawable.image240
            ),
            Notificacion(
                "Sony",
                "A career in website design can involve the design, creation, and coding of a range of website types. Other tasks will typically...",
                "6:15 P.M.",
                R.drawable.image239
            )
        )
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(300.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                // Perfil y otros items de navegación...
            }
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            // Imagen de fondo
            Image(
                painter = painterResource(id = R.drawable.fondo),
                contentDescription = "Fondo",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )

            // Contenido principal
            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        title = { Text("Notificaciones", color = Color.White) },
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
                                    tint = Color.White
                                )
                            }
                        },
                        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                            containerColor = Color(0xFF1C1B1F)
                        )
                    )
                },
                containerColor = Color.Transparent
            ) { paddingValues ->
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    items(notificaciones) { notificacion ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                                .clickable {
                                    onNavigateToScreen("notificaciones_screen")
                                },
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.Top
                                ) {
                                    Image(
                                        painter = painterResource(id = notificacion.imageResourceId),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(40.dp)
                                            .clip(CircleShape)
                                            .background(Color.LightGray),
                                        contentScale = ContentScale.Crop
                                    )
                                    Spacer(modifier = Modifier.width(16.dp))
                                    Column(modifier = Modifier.weight(1f)) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.Top
                                        ) {
                                            Text(
                                                text = notificacion.titulo,
                                                fontSize = 16.sp,
                                                color = Color.Black,
                                                modifier = Modifier.weight(1f)
                                            )
                                            Text(
                                                text = notificacion.hora,
                                                fontSize = 12.sp,
                                                color = Color.Gray
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(4.dp))
                                        Text(
                                            text = notificacion.mensaje,
                                            fontSize = 14.sp,
                                            color = Color.Gray,
                                            maxLines = 2,
                                            overflow = TextOverflow.Ellipsis
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(8.dp))
                                // Botón para navegar
                                Button(
                                    onClick = { navController.navigate("notificacionesusu") },
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

@Preview(showBackground = true, widthDp = 430, heightDp = 894)
@Composable
fun NotificacionesUsuPreview() {
    NotificacionesUsu(navController = rememberNavController())
}
