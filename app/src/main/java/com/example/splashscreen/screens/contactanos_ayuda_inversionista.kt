package com.example.splashsreen.screens

import android.widget.ExpandableListView.ExpandableListContextMenuInfo
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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

data class Queestion(
    val title: String,
    val content: String
)

@Composable
fun ExpandableListContex(
    question: Question,
    modifier: Modifier = Modifier
) {
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
    ) {
        // Pregunta y flecha
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

        // Contenido expandible
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

@Composable
fun Contactanosinver() {
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
            // Contenido fijo (Encabezado y detalles de contacto)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(155.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .offset(x = 20.dp, y = 27.dp)
                        .size(35.dp, 24.dp),
                )

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

            Box(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .background(Color(0xffffffff), RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .height(236.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
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

            // Contenido desplazable (Preguntas)
            LazyColumn(
                modifier = Modifier.fillMaxSize()
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
                            .padding(end = 20.dp, bottom = 16.dp),
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

@Preview(showBackground = true)
@Composable
fun contactactarinverPreview() {
    MaterialTheme {
        Contactanosinver()
    }
}

