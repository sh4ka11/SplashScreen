package com.example.myapplication.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.splashscreen.R
import com.example.splashscreen.screens.ChatScreen1
import com.example.splashscreen.ui.theme.SplashScreenTheme


@Composable
fun Busqueda1() {


    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .background(Color(0xffd9d9d9))
            .fillMaxWidth() // Llenar todo el ancho disponible
            .height(1000.dp) // Mantener el alto
            .verticalScroll(rememberScrollState()) // Habilitar scroll vertical
            .clipToBounds(),
    ) {
        // Rectángulo interior
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                //.offset(x = 0.dp, y = -101.dp) // Elimina esto para evitar desplazamiento
                .background(Color(0xffd9d9d9))
                .fillMaxWidth() // Llenar todo el ancho disponible
                .height(3000.dp), // Mantener el alto
        )

        // Imagen
        Image(
            painter = painterResource(id = R.drawable.sinfondo),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 503.dp, y = 308.dp) // Ajusta esto si es necesario
                .size(36.dp, 33.dp),
        )


        // Image-1088:332-588a6507d06f6719692a2d15 3
        Image(
            painter = painterResource(id = R.drawable.sinfondo),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 19.dp, y = 28.dp)
                .size(width = 160.dp, height = 70.dp) // Aumenta el ancho a 160dp y mantiene la altura en 70dp
        )


        // Empty-1088:163-Rectangle 653
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 19.dp, y = 218.dp)
                .background(Color(0xffffffff), RoundedCornerShape(20.dp))
                .size(188.dp, 191.dp)
                .border(5.dp, Color(0xff000000), RoundedCornerShape(20.dp)),
        )
        // Empty-1088:369-Rectangle 762
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 225.dp, y = 218.dp)
                .background(Color(0xffffffff), RoundedCornerShape(20.dp))
                .size(188.dp, 191.dp)
                .border(5.dp, Color(0xff000000), RoundedCornerShape(20.dp)),
        )
        // Empty-1088:379-Rectangle 765
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 225.dp, y = 518.dp)
                .background(Color(0xffffffff), RoundedCornerShape(20.dp))
                .size(188.dp, 191.dp)
                .border(5.dp, Color(0xff000000), RoundedCornerShape(20.dp)),
        )
        // Empty-1088:380-Rectangle 766
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 19.dp, y = 824.dp)
                .background(Color(0xffffffff), RoundedCornerShape(20.dp))
                .size(188.dp, 191.dp)
                .border(5.dp, Color(0xff000000), RoundedCornerShape(20.dp)),
        )
        // Image-1088:403-Rectangle 772
        Image(
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 27.dp, y = 830.dp)
                .size(173.dp, 179.dp),
        )
        // Empty-1088:382-Rectangle 767
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 225.dp, y = 824.dp)
                .background(Color(0xffffffff), RoundedCornerShape(20.dp))
                .size(188.dp, 191.dp)
                .border(5.dp, Color(0xff000000), RoundedCornerShape(20.dp)),
        )
        // Empty-1105:25-Rectangle 782
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 19.dp, y = 1129.dp)
                .background(Color(0xffffffff), RoundedCornerShape(20.dp))
                .size(188.dp, 191.dp)
                .border(5.dp, Color(0xff000000), RoundedCornerShape(20.dp)),
        )
        // Empty-1105:24-Rectangle 781
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 223.dp, y = 1129.dp)
                .background(Color(0xffffffff), RoundedCornerShape(20.dp))
                .size(188.dp, 191.dp)
                .border(5.dp, Color(0xff000000), RoundedCornerShape(20.dp)),
        )
        // Image-1088:402-Rectangle 678
        Image(
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 234.dp, y = 830.dp)
                .size(173.dp, 179.dp),
        )
        // Empty-1088:378-Rectangle 764
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 19.dp, y = 518.dp)
                .background(Color(0xffffffff), RoundedCornerShape(20.dp))
                .size(188.dp, 191.dp)
                .border(5.dp, Color(0xff000000), RoundedCornerShape(20.dp)),
        )
        // Image-1088:383-Rectangle 685
        Image(
            painter = painterResource(id = R.drawable.escritorios),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 21.dp, y = 518.dp)
                .size(172.dp, 187.dp)
                .clip(RoundedCornerShape(20.dp)) // Curvatura en las esquinas
        )
        // Image-1088:370-image 232
        Image(
            painter = painterResource(id = R.drawable.arepas),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 233.dp, y = 224.dp)
                .size(170.dp, 179.dp),
        )


        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 19.dp, y = 468.dp)
        ) {
            Button(
                onClick = { /* Acción al hacer clic */ },
                modifier = Modifier
                    .width(80.dp) // Ancho del botón ajustado
                    .height(40.dp), // Altura del botón ajustada
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF000000), // Fondo negro
                    contentColor = Color(0xFFFFFFFF) // Texto blanco
                ),
                elevation = null // Sin sombra
            ) {
                Text(
                    text = "Visitar",
                    fontSize = 11.sp, // Tamaño de la fuente
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center, // Texto centrado
                    modifier = Modifier.fillMaxWidth(), // Ocupa todo el ancho del botón
                    overflow = TextOverflow.Clip // Evita truncamiento del texto
                )
            }
        }



        // Text-1088:224-Empresa procesadora de vino de todos los sabores
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 19.dp, y = 430.dp)
                .size(195.dp, 54.dp),
            text = "Empresa procesadora de vino de todos los sabores",
            color = Color(0xff000000),
            fontSize = 11.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-1088:225-vinos el extasis
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 19.dp, y = 409.dp)
                .size(157.dp, 30.dp),
            text = "vinos el extasis",
            color = Color(0xff000000),
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )




        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 21.dp, y = 768.dp)
        ) {
            Button(
                onClick = { /* Acción al hacer clic */ },
                modifier = Modifier
                    .width(80.dp) // Ancho del botón
                    .height(40.dp), // Altura del botón
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF000000), // Fondo negro
                    contentColor = Color(0xFFFFFFFF) // Texto blanco
                ),
                elevation = null // Sin sombra
            ) {
                Text(
                    text = "Visitar",
                    fontSize = 11.sp, // Tamaño de la fuente
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center, // Texto centrado
                    modifier = Modifier.fillMaxWidth(), // Ocupa todo el ancho del botón
                    overflow = TextOverflow.Clip // Evita truncamiento del texto
                )
            }
        }





        // Text-1088:386-Empresa fabricante de fichas de construccion para el aprendizaje
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 21.dp, y = 730.dp)
                .size(195.dp, 54.dp),
            text = "Empresa fabricante de fichas de construccion para el aprendizaje",
            color = Color(0xff000000),
            fontSize = 11.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-1088:387-Lego
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 21.dp, y = 709.dp)
                .size(157.dp, 30.dp),
            text = "Escritorios",
            color = Color(0xff000000),
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )



        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 225.dp, y = 768.dp)
        ) {
            Button(
                onClick = { /* Acción al hacer clic */ },
                modifier = Modifier
                    .width(80.dp) // Ancho del botón ajustado
                    .height(40.dp), // Altura del botón ajustada
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF000000), // Fondo negro
                    contentColor = Color(0xFFFFFFFF) // Texto blanco
                ),
                elevation = null // Sin sombra
            ) {
                Text(
                    text = "Visitar",
                    fontSize = 11.sp, // Tamaño de la fuente
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center, // Texto centrado
                    modifier = Modifier.fillMaxWidth(), // Ocupa todo el ancho del botón
                    overflow = TextOverflow.Clip // Evita truncamiento del texto
                )
            }
        }





        // Text-1088:391-Empresa dedicada a la fabricacion de papas de todos los sabores
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 225.dp, y = 730.dp)
                .size(195.dp, 54.dp),
            text = "Empresa dedicada a la fabricacion de papas de todos los sabores",
            color = Color(0xff000000),
            fontSize = 11.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-1088:392-Pringles
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 225.dp, y = 709.dp)
                .size(157.dp, 30.dp),
            text = "Pringles",
            color = Color(0xff000000),
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )


        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 21.dp, y = 1079.dp)
        ) {
            Button(
                onClick = { /* Acción al hacer clic */ },
                modifier = Modifier
                    .width(80.dp) // Ancho del botón ajustado
                    .height(40.dp), // Altura del botón ajustada
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF000000), // Fondo negro
                    contentColor = Color(0xFFFFFFFF) // Texto blanco
                ),
                elevation = null // Sin sombra
            ) {
                Text(
                    text = "Visitar",
                    fontSize = 11.sp, // Tamaño de la fuente
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center, // Texto centrado
                    modifier = Modifier.fillMaxWidth(), // Ocupa todo el ancho del botón
                    overflow = TextOverflow.Clip // Evita truncamiento del texto
                )
            }
        }



        // Text-1088:395-Empresa audiovisual enfocada en la produccion de largometrajes
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 21.dp, y = 1041.dp)
                .size(195.dp, 54.dp),
            text = "Empresa audiovisual enfocada en la produccion de largometrajes",
            color = Color(0xff000000),
            fontSize = 11.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-1088:396-Sony
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 21.dp, y = 1020.dp)
                .size(157.dp, 30.dp),
            text = "Sony",
            color = Color(0xff000000),
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )



        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 225.dp, y = 1079.dp)
        ) {
            Button(
                onClick = { /* Acción al hacer clic */ },
                modifier = Modifier
                    .width(80.dp) // Ancho del botón ajustado
                    .height(40.dp), // Altura del botón ajustada
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF000000), // Fondo negro
                    contentColor = Color(0xFFFFFFFF) // Texto blanco
                ),
                elevation = null // Sin sombra
            ) {
                Text(
                    text = "Visitar",
                    fontSize = 11.sp, // Tamaño de la fuente
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center, // Texto centrado
                    modifier = Modifier.fillMaxWidth(), // Ocupa todo el ancho del botón
                    overflow = TextOverflow.Clip // Evita truncamiento del texto
                )
            }
        }



        // Text-1088:399-Empresa promotora de cine y peliculas de todo tipo
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 225.dp, y = 1041.dp)
                .size(195.dp, 54.dp),
            text = "Empresa promotora de cine y peliculas de todo tipo",
            color = Color(0xff000000),
            fontSize = 11.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )




        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 19.dp, y = 1384.dp)
        ) {
            Button(
                onClick = { /* Acción al hacer clic */ },
                modifier = Modifier
                    .width(80.dp) // Ancho del botón ajustado
                    .height(40.dp), // Altura del botón ajustada
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF000000), // Fondo negro
                    contentColor = Color(0xFFFFFFFF) // Texto blanco
                ),
                elevation = null // Sin sombra
            ) {
                Text(
                    text = "Visitar",
                    fontSize = 11.sp, // Tamaño de la fuente
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center, // Texto centrado
                    modifier = Modifier.fillMaxWidth(), // Ocupa todo el ancho del botón
                    overflow = TextOverflow.Clip // Evita truncamiento del texto
                )
            }
        }



        // Text-1105:18-Empresa enfocada en la creacion de prendas deportivas
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 19.dp, y = 1346.dp)
                .size(195.dp, 54.dp),
            text = "Empresa enfocada en la creacion de prendas deportivas",
            color = Color(0xff000000),
            fontSize = 11.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-1105:19-Adibas
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 19.dp, y = 1325.dp)
                .size(157.dp, 30.dp),
            text = "Adibas",
            color = Color(0xff000000),
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-1105:26-Converse All Star
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 223.dp, y = 1325.dp)
                .size(191.dp, 30.dp),
            text = "Converse All Star",
            color = Color(0xff000000),
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )



        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 223.dp, y = 1384.dp)
        ) {
            Button(
                onClick = { /* Acción al hacer clic */ },
                modifier = Modifier
                    .width(80.dp) // Ancho del botón ajustado
                    .height(40.dp), // Altura del botón ajustada
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF000000), // Fondo negro
                    contentColor = Color(0xFFFFFFFF) // Texto blanco
                ),
                elevation = null // Sin sombra
            ) {
                Text(
                    text = "Visitar",
                    fontSize = 11.sp, // Tamaño de la fuente
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center, // Texto centrado
                    modifier = Modifier.fillMaxWidth(), // Ocupa todo el ancho del botón
                    overflow = TextOverflow.Clip // Evita truncamiento del texto
                )
            }
        }




        // Text-1105:22-Empresa enfocada en la fabricacion de zapatos deportivos finos
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 223.dp, y = 1346.dp)
                .size(195.dp, 54.dp),
            text = "Empresa enfocada en la fabricacion de zapatos deportivos finos",
            color = Color(0xff000000),
            fontSize = 11.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-1088:400-Amazon
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 225.dp, y = 1020.dp)
                .size(157.dp, 30.dp),
            text = "Amazon",
            color = Color(0xff000000),
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )



        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 225.dp, y = 468.dp)
        ) {
            Button(
                onClick = { /* Acción al hacer clic */ },
                modifier = Modifier
                    .width(80.dp) // Ancho del botón ajustado
                    .height(40.dp), // Altura del botón ajustada
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF000000), // Fondo negro
                    contentColor = Color(0xFFFFFFFF) // Texto blanco
                ),
                elevation = null // Sin sombra
            ) {
                Text(
                    text = "Visitar",
                    fontSize = 11.sp, // Tamaño de la fuente
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center, // Texto centrado
                    modifier = Modifier.fillMaxWidth(), // Ocupa todo el ancho del botón
                    overflow = TextOverflow.Clip // Evita truncamiento del texto
                )
            }
        }




        // Text-1088:373-Empresa de navegacion web que te ofrece todo tipo de informacion
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 225.dp, y = 430.dp)
                .size(195.dp, 54.dp),
            text = "Empresa de navegacion web que te ofrece todo tipo de informacion",
            color = Color(0xff000000),
            fontSize = 11.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-1088:374-Google Chrome
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 225.dp, y = 409.dp)
                .size(157.dp, 30.dp),
            text = "Arepas",
            color = Color(0xff000000),
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Image-1088:366-image 389
        Image(
            painter = painterResource(id = R.drawable.vino),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 19.dp, y = 225.dp)
                .size(183.dp, 179.dp),
        )
        // Image-1088:401-Rectangle 675
        Image(
            painter = painterResource(id = R.drawable.guanteschimbas),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 233.dp, y = 524.dp)
                .size(165.dp, 173.dp)

                .clip(RoundedCornerShape(20.dp)) // Curvatura en las esquinas
        )

        // Text-1088:404-Cargando...
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 116.dp, y = 1466.dp)
                .size(211.dp, 38.dp),
            text = "Cargando...",
            color = Color(0xff000000),
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
        )


        val textState = remember { mutableStateOf("") }

        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 27.dp, y = 109.dp)
                .background(Color.White, RoundedCornerShape(30.dp))
                .widthIn(max = 300.dp) // Ancho máximo de 300 dp
                .height(50.dp) // Mantener el alto
                .border(3.dp, Color.Black, RoundedCornerShape(15.dp)) // Agregar borde negro con esquinas redondeadas

        )
        {
            TextField(
                value = textState.value,
                onValueChange = { newText -> textState.value = newText },
                modifier = Modifier
                    .fillMaxSize() // Hace que el TextField ocupe todo el espacio disponible en el Box
                    .padding(vertical = 0.dp, horizontal = 0.dp), // Aumenta el padding vertical
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp, // Aumenta el tamaño de la fuente para mayor legibilidad
                    textAlign = TextAlign.Center
                ),


                )
        }
    }


    // Image-1099:165-image 398
    Image(
        painter = painterResource(id = R.drawable.lupa),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .offset(x = 374.dp, y = 115.dp)
            .size(28.dp, 28.dp),
    )
    // Image-1105:30-image 490
    Image(
        painter = painterResource(id = R.drawable.fondo),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .offset(x = 19.dp, y = 1129.dp)
            .size(188.dp, 191.dp),
    )
    // Image-1105:610-image 504
    Image(
        painter = painterResource(id = R.drawable.fondo),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .offset(x = 231.dp, y = 1135.dp)
            .size(173.dp, 179.dp),
    )
}

@Preview(showBackground = true)
@Composable
fun ChatScreen1Preview() {
    MaterialTheme {
        Busqueda1(

        )
    }
}