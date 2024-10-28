package com.example.splashscreen.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

data class MessageDataInver(
    val id: Int,
    val message: String,
    val time: String,
    val isFromMe: Boolean,
    val isImage: Boolean = false,
    val imageResource: Int? = null
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreenInver(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var messageText by remember { mutableStateOf("") }
    val listState = rememberLazyListState()

    // Lista mutable de mensajes para añadir nuevos
    val chatMessages = remember { mutableStateListOf(
        MessageDataInver(1, "Estoy disponible\n[Disponibilidad del inversor].", "4:15 PM", false),
        MessageDataInver(2, "Si, perfecto", "4:18 PM", true),
        MessageDataInver(3, "¡Genial! Espero con interés hablar con usted con más detalle.", "4:18 PM", false),
        MessageDataInver(4, "Le enviaré un correo electrónico para confirmar la fecha y hora.", "4:19 PM", true),
        MessageDataInver(5, "Gracias, Buena tarde.", "4:20 PM", false)
    )}

    // Función para añadir un mensaje nuevo
    fun appendMessage(text: String, isFromMe: Boolean, isImage: Boolean = false, imageResource: Int? = null) {
        val timeFormat = SimpleDateFormat("h:mm a", Locale.getDefault())
        val currentTime = timeFormat.format(Date())

        chatMessages.add(
            MessageDataInver(
                id = chatMessages.size + 1,
                message = text,
                time = currentTime,
                isFromMe = isFromMe,
                isImage = isImage,
                imageResource = imageResource
            )
        )

        // Auto-respuesta tras el mensaje del usuario
        if (isFromMe) {
            scope.launch {
                delay(1000) // Retraso para simular el tiempo de respuesta
                val response = "¡Excelente! Gracias por tu mensaje."
                chatMessages.add(
                    MessageDataInver(
                        id = chatMessages.size + 1,
                        message = response,
                        time = timeFormat.format(Date()),
                        isFromMe = false
                    )
                )
                // Desplazarse al final
                listState.animateScrollToItem(chatMessages.size - 1)
            }
        }
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
                            scope.launch {
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
                .background(Color(0xFFECE5DD))
        ) {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
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
                        Image(
                            painter = painterResource(id = R.drawable.image3_647598),
                            contentDescription = "Foto de perfil",
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = "Kevin targaryen",
                                color = Color.Black,
                                fontSize = 16.sp
                            )
                            Text(
                                text = "targarienKevin@gmail.com",
                                color = Color.Gray,
                                fontSize = 12.sp
                            )
                        }
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Volver",
                            tint = Color.Black
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )
            )
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 8.dp),
                state = listState,
                reverseLayout = false
            ) {
                items(chatMessages) { message ->
                    InverMessageItem(message)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                shadowElevation = 4.dp
            ) {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = {
                            appendMessage(
                                "Imagen adjunta",
                                true,
                                true,
                                R.drawable.image3_647598
                            )
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Adjuntar imagen",
                            tint = Color.Gray
                        )
                    }
                    OutlinedTextField(
                        value = messageText,
                        onValueChange = { messageText = it },
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 8.dp),
                        placeholder = { Text("Escribe tu mensaje...") },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Color.Transparent,
                            focusedBorderColor = Color.Transparent,
                            unfocusedContainerColor = Color(0xFFF0F0F0),
                            focusedContainerColor = Color(0xFFF0F0F0)
                        ),
                        shape = RoundedCornerShape(24.dp),
                        trailingIcon = {
                            IconButton(onClick = { }) {
                                Icon(
                                    imageVector = Icons.Default.Call,
                                    contentDescription = "Voz",
                                    tint = Color.Gray
                                )
                            }
                        }
                    )
                    IconButton(
                        onClick = {
                            if (messageText.isNotBlank()) {
                                appendMessage(messageText, true)
                                messageText = ""
                            }
                        },
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Color(0xFF075E54))
                            .size(40.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Send,
                            contentDescription = "Enviar",
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun InverMessageItem(message: MessageDataInver) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        contentAlignment = if (message.isFromMe) Alignment.CenterEnd else Alignment.CenterStart
    ) {
        Surface(
            shape = RoundedCornerShape(12.dp),
            color = if (message.isFromMe) Color(0xFFDCF8C6) else Color.White,
            shadowElevation = 1.dp,
            modifier = Modifier.widthIn(max = 280.dp)
        ) {
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                if (message.isImage && message.imageResource != null) {
                    Image(
                        painter = painterResource(id = message.imageResource),
                        contentDescription = "Imagen adjunta",
                        modifier = Modifier
                            .size(200.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                }
                Text(
                    text = message.message,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = message.time,
                    color = Color.Gray,
                    fontSize = 12.sp,
                    modifier = Modifier.align(Alignment.End)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewChatScreenInver() {
    ChatScreenInver(navController = rememberNavController())
}
