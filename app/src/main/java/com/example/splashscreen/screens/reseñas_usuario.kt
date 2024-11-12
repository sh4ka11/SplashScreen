package com.example.splashscreen.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.splashscreen.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResenasUsuarioView() {
    var expandedReviewIndex by remember { mutableStateOf<Int?>(null) }
    var showReplyField by remember { mutableStateOf<Int?>(null) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(300.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Mi Perfil") },
                    label = { Text("Mi Perfil") },
                    selected = false,
                    onClick = {
                        scope.launch { drawerState.close() }
                    }
                )

                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") },
                    label = { Text("Inicio") },
                    selected = false,
                    onClick = {
                        scope.launch { drawerState.close() }
                    }
                )

                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.Search, contentDescription = "Busqueda por categoria") },
                    label = { Text("Busqueda por categoria") },
                    selected = false,
                    onClick = {
                        scope.launch { drawerState.close() }
                    }
                )

                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.Share, contentDescription = "Consultar redes") },
                    label = { Text("Consultar redes") },
                    selected = false,
                    onClick = {
                        scope.launch { drawerState.close() }
                    }
                )

                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.List, contentDescription = "Lista de empredimientos") },
                    label = { Text("Lista de empredimientos") },
                    selected = false,
                    onClick = {
                        scope.launch { drawerState.close() }
                    }
                )

                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.Notifications, contentDescription = "Notificaciones") },
                    label = { Text("Notificaciones") },
                    selected = false,
                    onClick = {
                        scope.launch { drawerState.close() }
                    }
                )

                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.Email, contentDescription = "Chat") },
                    label = { Text("Chat") },
                    selected = false,
                    onClick = {
                        scope.launch { drawerState.close() }
                    }
                )

                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.ExitToApp, contentDescription = "Cerrar Sesión") },
                    label = { Text("Cerrar Sesión") },
                    selected = false,
                    onClick = {
                        scope.launch { drawerState.close() }
                    }
                )

                Spacer(modifier = Modifier.weight(1f))

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
    ) {
        Box(
            contentAlignment = Alignment.TopStart,
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
        ) {
            // Fondo
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 0.dp, y = 85.dp)
                    .size(430.dp, 800.dp)
                    .background(Color(0xFF3A3A3A))
            )

            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        title = {

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
                                    contentDescription = "Menu",
                                    tint = Color.White
                                )
                            }
                        },
                        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                            containerColor = Color(0xFF1C1B1F)
                        )
                    )
                }
            ) { paddingValues ->
                Column(
                    modifier = Modifier.padding(paddingValues)
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        text = "RESEÑAS",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center
                    )

                    // Reviews List
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(4) { index ->
                            ReviewCard(
                                index = index,
                                isExpanded = expandedReviewIndex == index,
                                showReply = showReplyField == index,
                                onExpandClick = {
                                    expandedReviewIndex = if (expandedReviewIndex == index) null else index
                                },
                                onReplyClick = {
                                    showReplyField = if (showReplyField == index) null else index
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

// El ReviewCard permanece igual que en tu código original
@Composable
private fun ReviewCard(
    index: Int,
    isExpanded: Boolean,
    showReply: Boolean,
    onExpandClick: () -> Unit,
    onReplyClick: () -> Unit
) {
    var replyText by remember { mutableStateOf("") }
    var replies by remember { mutableStateOf(listOf<String>()) } // Lista para almacenar respuestas

    val companyInfo = when(index) {
        0 -> Triple(R.drawable.sonylogo, "Sony", "2:15 PM")
        1 -> Triple(R.drawable.lego, "Lego", "3:15 PM")
        2 -> Triple(R.drawable.amazon, "Amazon", "4:15 PM")
        else -> Triple(R.drawable.pringles, "Pringles", "5:15 PM")
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(10.dp))
            .clickable(onClick = onExpandClick)
            .padding(16.dp)
    ) {
        Column {
            // Encabezado del comentario
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = companyInfo.first),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .size(40.dp)
                            .border(1.dp, Color(0xFF000000), RoundedCornerShape(20.dp))
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = companyInfo.second,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.estrellas),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.size(84.dp, 20.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Asunto: Invitación a una Colaboración Innovadora entre Sony y [Nombre de tu Empresa]...",
                maxLines = if (isExpanded) Int.MAX_VALUE else 2,
                overflow = TextOverflow.Ellipsis,
                fontSize = 12.sp
            )

            // Muestra la hora y el botón de responder
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = companyInfo.third,
                    fontSize = 12.sp,
                    color = Color.Black
                )
                TextButton(onClick = onReplyClick) {
                    Text("Responder", color = Color.Gray)
                }
            }

            // Campo de respuesta
            AnimatedVisibility(
                visible = showReply,
                enter = expandVertically(),
                exit = shrinkVertically()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = replyText,
                        onValueChange = { replyText = it },
                        placeholder = { Text("Escribe una respuesta...") },
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Gray,
                            unfocusedBorderColor = Color.Gray
                        )
                    )
                    IconButton(
                        onClick = {
                            // Agregar la respuesta a la lista de respuestas
                            if (replyText.isNotEmpty()) {
                                replies = replies + replyText
                                replyText = "" // Limpiar el campo después de enviar
                            }
                        },
                        modifier = Modifier.size(48.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.enviar),
                            contentDescription = "Enviar",
                            tint = Color.Black
                        )
                    }
                }
            }

            // Mostrar las respuestas debajo del comentario
            replies.forEach { reply ->
                Text(
                    text = reply,
                    fontSize = 12.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(top = 8.dp, start = 16.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewResenasUsuarioView() {
    ResenasUsuarioView()
}