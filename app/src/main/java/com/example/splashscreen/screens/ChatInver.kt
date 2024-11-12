package com.example.splashscreen.screens

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
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.R
import kotlinx.coroutines.launch

data class ChatInverMessage(
    val id: Int,
    val userName: String,
    val lastMessage: String,
    val time: String,
    val profilePicture: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatInverScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val drawerInverState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineInverScope = rememberCoroutineScope()
    var searchInverQuery by remember { mutableStateOf("") }

    // Sample chat messages
    val allInverChatMessages = listOf(
        ChatInverMessage(1, "Kevin targaryen", "MENSAJE", "4:15 PM", R.drawable.image3_647598),
        ChatInverMessage(2, "Kevin Alexis", "MENSAJE", "7:15 PM", R.drawable.image3_647598),
        ChatInverMessage(3, "Cristian sebastian", "MENSAJE", "9:15 PM", R.drawable.image3_647598),
        ChatInverMessage(4, "Monica Galindo", "MENSAJE", "4:15 PM", R.drawable.image3_647598),
        ChatInverMessage(5, "Alexa calvache", "MENSAJE", "4:15 PM", R.drawable.image3_647598),
        ChatInverMessage(6, "Stiven Godoy", "MENSAJE", "4:15 PM", R.drawable.image3_647598),
        ChatInverMessage(7, "Carlos sebastian", "MENSAJE", "4:15 PM", R.drawable.image3_647598)
    )

    val filteredInverMessages = remember(searchInverQuery) {
        if (searchInverQuery.isEmpty()) {
            allInverChatMessages
        } else {
            allInverChatMessages.filter {
                it.userName.lowercase().contains(searchInverQuery.lowercase())
            }
        }
    }

    ModalNavigationDrawer(
        drawerState = drawerInverState,
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

                // Drawer menu items
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
                        selected = texto == "Chat",
                        onClick = {
                            coroutineInverScope.launch {
                                drawerInverState.close()
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
                .background(Color.White)
        ) {
            // Top App Bar
            CenterAlignedTopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "ChatInver",
                            color = Color.Black,
                            fontSize = 20.sp
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            coroutineInverScope.launch {
                                if (drawerInverState.isClosed) drawerInverState.open()
                                else drawerInverState.close()
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

            // Search Bar
            OutlinedTextField(
                value = searchInverQuery,
                onValueChange = { searchInverQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                placeholder = { Text("Buscar...") },
                leadingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "Buscar",
                        tint = Color.Gray
                    )
                },
                trailingIcon = {
                    if (searchInverQuery.isNotEmpty()) {
                        IconButton(onClick = { searchInverQuery = "" }) {
                            Icon(
                                Icons.Default.Clear,
                                contentDescription = "Limpiar búsqueda",
                                tint = Color.Gray
                            )
                        }
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.LightGray,
                    focusedBorderColor = Color.Gray,
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White
                ),
                shape = RoundedCornerShape(24.dp),
                singleLine = true
            )

            // New Conversation Button
            OutlinedButton(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.Black
                ),
                border = ButtonDefaults.outlinedButtonBorder.copy(
                    brush = SolidColor(Color.LightGray)
                )
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Nueva conversación",
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "Nueva conversación",
                    color = Color.Black
                )
            }

            Divider(
                modifier = Modifier.padding(vertical = 8.dp),
                thickness = 1.dp,
                color = Color.LightGray
            )

            // Chat List with enhanced spacing
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(filteredInverMessages) { message ->
                    Column {
                        ChatInverItem(message)
                        Divider(
                            modifier = Modifier
                                .padding(start = 76.dp, top = 8.dp)
                                .fillMaxWidth(),
                            color = Color.LightGray,
                            thickness = 1.dp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ChatInverItem(message: ChatInverMessage) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Profile Picture
        Box(
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
                .background(Color.LightGray)
        ) {
            Image(
                painter = painterResource(id = message.profilePicture),
                contentDescription = "Profile picture",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Message Info
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = message.userName,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Medium
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = message.lastMessage,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
        }

        // Time
        if (message.time.isNotEmpty()) {
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = message.time,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatInverScreenPreview() {
    ChatInverScreen(navController = rememberNavController())
}
