package com.example.splashscreen.screens

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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

// Cambiado a NotificacionModel para evitar conflicto de nombres
data class NotificacionModel(
    val titulo: String,
    val mensaje: String,
    val hora: String,
    val imageResourceId: Int = R.drawable.image3_647598
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Notificaciones2Usu(
    navController: NavController,
    onNavigateToScreen: (String) -> Unit = {}
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    // Cambiado a NotificacionModel
    val notificaciones = remember {
        listOf(
            NotificacionModel(
                "Sprite",
                "Asunto: ¡Noticia emocionante! ¡Oportunidad de Inversión con Sprite para tu emprendimiento!\n\n" +
                        "Hola [Nombre del destinatario],\n\n" +
                        "¡Espero que estés teniendo un día excelente! Quería compartir contigo una noticia emocionante que podría ser un gran impulso para tu emprendimiento.\n\n" +
                        "En Sprite, estamos siempre en búsqueda de nuevas y emocionantes oportunidades de colaboración con emprendedores como tú que están haciendo olas en el mundo empresarial. Después de revisar tu empresa, [Nombre de tu Empresa], quedamos impresionados por tu visión, tu dedicación y el impacto que estás teniendo en tu industria.\n\n" +
                        "Nos complace informarte que estamos considerando patrocinar tu emprendimiento como parte de nuestra iniciativa para apoyar a empresarios prometedores.\n\n" +
                        "Además, te ofrecemos acceso exclusivo a eventos de networking, sesiones de mentoría con expertos de la industria, y una campaña de marketing conjunta para potenciar tu marca en nuevos mercados. Creemos que esta colaboración puede ser muy fructífera tanto para Sprite como para [Nombre de tu Empresa], y estamos emocionados de explorar esta oportunidad contigo.\n\n" +
                        "Quedamos a la espera de tu respuesta para coordinar una reunión en la que podamos discutir más detalles sobre esta propuesta.",
                "4:15 P.M.",
                R.drawable.image241
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

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Column {
                        Image(
                            painter = if (imageUri != null) {
                                painterResource(id = R.drawable.image3_647598)
                            } else {
                                painterResource(id = R.drawable.image3_647598)
                            },
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
                    "Mi Perfil" to Icons.Default.Person,
                    "Inicio" to Icons.Default.Home,
                    "Busqueda por categoria" to Icons.Default.Search,
                    "Consultar redes" to Icons.Default.Share,
                    "Lista de emprendimientos" to Icons.Default.List,
                    "Notificaciones" to Icons.Default.Notifications,
                    "Chat" to Icons.Default.Email,
                    "Cerrar Sesión" to Icons.Default.ExitToApp,
                    "Ayuda" to Icons.Default.Info
                ).forEach { (texto, icono) ->
                    NavigationDrawerItem(
                        icon = { Icon(icono, contentDescription = texto) },
                        label = { Text(texto) },
                        selected = texto == "Notificaciones",
                        onClick = {
                            scope.launch {
                                drawerState.close()
                                onNavigateToScreen(texto)
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
                                .padding(horizontal = 16.dp, vertical = 8.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.Start
                                    ) {
                                        Image(
                                            painter = painterResource(id = notificacion.imageResourceId),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(40.dp)
                                                .clip(CircleShape),
                                            contentScale = ContentScale.Crop
                                        )
                                        Spacer(modifier = Modifier.width(12.dp))
                                        Text(
                                            text = notificacion.titulo,
                                            fontSize = 16.sp,
                                            color = Color.Black
                                        )
                                    }
                                    Text(
                                        text = notificacion.hora,
                                        fontSize = 12.sp,
                                        color = Color.Gray
                                    )
                                }
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = notificacion.mensaje,
                                    fontSize = 14.sp,
                                    color = Color.DarkGray,
                                    lineHeight = 20.sp
                                )
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
fun Notificaciones2UsuPreview() {
    Notificaciones2Usu(navController = rememberNavController())
}
