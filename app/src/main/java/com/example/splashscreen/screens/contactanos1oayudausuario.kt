package com.example.splashsreen.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.splashscreen.R
import kotlinx.coroutines.launch

data class Question(
    val title: String,
    val content: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Contactanos() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val questions = listOf(
        Question(
            "¿Como cambiar mi contraseña?",
            "Para cambiar tu contraseña, sigue estos pasos:\n\n" +
                    "1. Ingresa a tu perfil desde el menú principal\n" +
                    "2. Selecciona la opción 'Configuración de cuenta'\n" +
                    "3. Haz clic en 'Cambiar contraseña'\n" +
                    "4. Ingresa tu contraseña actual y la nueva contraseña\n" +
                    "5. Confirma los cambios y ¡listo!"
        ),
        Question(
            "¿Como publicar un emprendimiento?",
            "Para publicar tu emprendimiento en nuestra plataforma:\n\n" +
                    "1. Accede a la sección 'Nuevo emprendimiento'\n" +
                    "2. Completa todos los datos requeridos de tu negocio\n" +
                    "3. Agrega fotos y descripción detallada\n" +
                    "4. Selecciona la categoría adecuada\n" +
                    "5. Revisa la información y publica"
        ),
        Question(
            "¿Como mirar mi emprendimiento?",
            "Para visualizar tu emprendimiento publicado:\n\n" +
                    "1. Ve a tu perfil de usuario\n" +
                    "2. Selecciona la pestaña 'Mis emprendimientos'\n" +
                    "3. Allí encontrarás todos tus negocios publicados\n" +
                    "4. Puedes ver estadísticas y comentarios\n" +
                    "5. También puedes editar la información cuando lo necesites"
        ),
        Question(
            "¿Como ver los comentarios?",
            "Para ver los comentarios de tu emprendimiento:\n\n" +
                    "1. Ingresa a la publicación de tu emprendimiento\n" +
                    "2. Desplázate hacia abajo hasta la sección de comentarios\n" +
                    "3. Podrás ver todos los comentarios ordenados por fecha\n" +
                    "4. Puedes responder a cada comentario\n" +
                    "5. También puedes gestionar y moderar los comentarios"
        ),
        Question(
            "Preguntas frecuentes",
            "Aquí encontrarás respuestas a las preguntas más comunes:\n\n" +
                    "• ¿Cómo recupero mi contraseña?\n" +
                    "• ¿Puedo tener múltiples emprendimientos?\n" +
                    "• ¿Cómo destaco mi emprendimiento?\n" +
                    "• ¿Cómo contacto a otros emprendedores?\n" +
                    "• ¿Cómo reporto contenido inadecuado?"
        )
    )



    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(300.dp)
            ) {
                Column(
                    modifier = Modifier.padding(vertical = 16.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    // Imagen del perfil
                    Image(
                        painter = painterResource(id = R.drawable.imagenrealdesebas),
                        contentDescription = "Perfil",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    )

                    // Nombre de usuario
                    Text(
                        text = "Usuario",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 16.dp, top = 8.dp)
                    )

                    // Correo electrónico
                    Text(
                        text = "usuario@example.com",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
                    )

                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        color = Color.LightGray
                    )
                }

                // Opciones del menú
                val menuItems = listOf(
                    Pair(Icons.Default.Person, "Mi Perfil"),
                    Pair(Icons.Default.Home, "Inicio"),
                    Pair(Icons.Default.Search, "Busqueda por categoria"),
                    Pair(Icons.Default.Share, "Consultar redes"),
                    Pair(Icons.Default.List, "Lista de emprendimientos"),
                    Pair(Icons.Default.Notifications, "Notificaciones"),
                    Pair(Icons.Default.Email, "Chat"),
                    Pair(Icons.Default.ExitToApp, "Cerrar Sesión")
                )

                LazyColumn {
                    items(menuItems) { (icon, label) ->
                        NavigationDrawerItem(
                            icon = { Icon(icon, contentDescription = label) },
                            label = { Text(label) },
                            selected = false,
                            onClick = {
                                scope.launch { drawerState.close() }
                            }
                        )
                    }

                    item { Spacer(modifier = Modifier.weight(1f)) }
                    item { Spacer(modifier = Modifier.height(120.dp)) }

                    item {
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
            }
        }
    ) {
        Box(
            contentAlignment = Alignment.TopStart,
            modifier = Modifier
                .background(Color(0xffffffff))
                .size(430.dp, 894.dp)
                .clipToBounds(),
        ) {
            Image(
                painter = painterResource(id = R.drawable.fondo),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 0.dp, y = 79.dp)
                    .size(430.dp, 815.dp),
            )

            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                // Header con menú y logo
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(155.dp)
                ) {
                    // Botón del menú modificado para usar el drawer
                    IconButton(
                        onClick = {
                            scope.launch {
                                if (drawerState.isClosed) drawerState.open()
                                else drawerState.close()
                            }
                        },
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .offset(x = 20.dp, y = 27.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu",
                            tint = Color.Black,
                            modifier = Modifier.size(24.dp)
                        )
                    }

                    Image(
                        painter = painterResource(id = R.drawable.sinfondo),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .offset(x = 80.dp, y = 0.dp)
                            .size(216.dp, 77.dp),
                    )

                    Text(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .offset(x = 163.dp, y = 89.dp)
                            .size(121.dp, 50.dp),
                        text = "Contactanos",
                        color = Color(0xffffffff),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Left,
                    )
                }

                // Resto del contenido original
                Box(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .background(Color(0xffffffff), RoundedCornerShape(10.dp))
                        .fillMaxWidth()
                        .height(236.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "¿Nesecitas ayuda? ¡Escribenos!",
                            color = Color(0xff000000),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal,
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Numeros:\n3108596745              3108974856            31152867569",
                            color = Color(0xad000000),
                            fontSize = 12.sp,
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "!Tambien puedes por correo¡",
                            color = Color(0xff000000),
                            fontSize = 15.sp,
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Correo Electronico:\nemprendelinkAyuda@gmail.com",
                            color = Color(0xad000000),
                            fontSize = 12.sp,
                        )
                    }
                }

                Spacer(modifier = Modifier.height(33.dp))

                // Lista de preguntas
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp)
                ) {
                    items(questions) { question ->
                        ExpandableQuestion(
                            question = question,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp),
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            Text(
                                text = "Ver mas...",
                                color = Color(0xff000000),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ExpandableQuestion(
    question: Question,
    modifier: Modifier = Modifier
) {
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .background(Color(0xffffffff), RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .clickable { isExpanded = !isExpanded }
        ) {
            Text(
                text = question.title,
                color = Color(0xff000000),
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .padding(start = 27.dp, top = 21.dp, bottom = 21.dp)
                    .width(296.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.flecha),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 23.dp)
                    .size(25.dp, 26.dp)
                    .rotate(if (isExpanded) 180f else 0f)
            )
        }

        if (isExpanded) {
            Text(
                text = question.content,
                color = Color(0xad000000),
                fontSize = 14.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xffffffff))
                    .padding(16.dp)
            )
        }

        Spacer(modifier = Modifier.height(13.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ContactanosPreview() {
    MaterialTheme {
        Contactanos()
    }
}