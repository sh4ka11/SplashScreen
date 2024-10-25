package com.example.splasscreen.screens

import com.example.splashscreen.R
import com.example.splashscreen.ui.theme.SplashScreenTheme

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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Olvidar1() {
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .background(Color(0xffffffff))
            .size(900.dp, 1000.dp) // Aumentar el tamaño
            .verticalScroll(rememberScrollState()) // Permitir scroll vertical
            .clipToBounds(),
    ) {
        // Image-1141:227-204736911-un-hombre-de-negocios-mirando-por-la-ventana-a-una-vista-de-la-ciudad-visión-empresarial-ideas-transformed 2
        Image(
            painter = painterResource(id = R.drawable.fondoolvidar),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = -5.dp, y = 0.dp)
                .size(435.dp, 560.dp), // Aumentar el tamaño de la imagen también
        )

        // Empty-1141:228-Rectangle 691

        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 0.dp, y = 309.dp)
                .background(Color(0xfff5f5f3), RoundedCornerShape(20.dp))
                .size(900.dp, 1000.dp), // Ajustar tamaño del cuadro
        )

        // Image-1141:229-image 178
        Image(
            painter = painterResource(id = R.drawable.sinfondo),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 14.dp, y = 42.dp)
                .size(216.dp, 89.dp),
        )

        // Empty-1141:231-Rectangle 728
        Button(
            onClick = { /* Acción del botón */ },
            modifier = Modifier
                .align(Alignment.TopCenter) // Centrar el botón horizontalmente
                .offset(y = 693.dp) // Mantener el desplazamiento vertical
                .size(300.dp, 50.dp), // Hacer el botón más largo
        ) {
            Text(
                text = "Siguiente",
                color = Color(0xfff9f7f3), // Color del texto
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
            )
        }

        // Empty-1141:233-Rectangle 722
        
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 33.dp, y = 531.dp)
                .background(Color(0xfffcfcfc), RoundedCornerShape(20.dp))
                .size(54.dp, 84.dp)
                .border(1.dp, Color(0xff000000), RoundedCornerShape(20.dp)),
        )
        // Empty-1141:234-Rectangle 723
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 96.dp, y = 531.dp)
                .background(Color(0xfffcfcfc), RoundedCornerShape(20.dp))
                .size(54.dp, 84.dp)
                .border(1.dp, Color(0xff000000), RoundedCornerShape(20.dp)),
        )
        // Empty-1141:235-Rectangle 724
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 159.dp, y = 531.dp)
                .background(Color(0xfffcfcfc), RoundedCornerShape(20.dp))
                .size(54.dp, 84.dp)
                .border(1.dp, Color(0xff000000), RoundedCornerShape(20.dp)),
        )
        // Empty-1141:236-Rectangle 725
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 222.dp, y = 531.dp)
                .background(Color(0xfffcfcfc), RoundedCornerShape(20.dp))
                .size(54.dp, 84.dp)
                .border(1.dp, Color(0xff000000), RoundedCornerShape(20.dp)),
        )
        // Empty-1141:237-Rectangle 726
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 285.dp, y = 531.dp)
                .background(Color(0xfffcfcfc), RoundedCornerShape(20.dp))
                .size(54.dp, 84.dp)
                .border(1.dp, Color(0xff000000), RoundedCornerShape(20.dp)),
        )
        // Empty-1141:238-Rectangle 727
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 348.dp, y = 531.dp)
                .background(Color(0xfffcfcfc), RoundedCornerShape(20.dp))
                .size(54.dp, 84.dp)
                .border(1.dp, Color(0xff000000), RoundedCornerShape(20.dp)),
        )
        // Text-1141:239-Codigo de confirmacion
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentHeight()
                .offset(x = 53.dp, y = 349.dp)
                .width(373.dp),
            text = "Codigo de confirmacion",
            color = Color(0xff000000),
            fontSize = 30.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-1141:240-Le enviamos un correo electronico con el codigo de confirmacion a numero: 31085967498
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 10.dp, y = 416.dp) // Moverlo un poco más a la izquierda ajustando el offset en x
                .size(387.dp, 92.dp),
            text = "Le enviamos un correo electronico con el codigo de confirmacion a numero: \n31085967498\n\n",
            color = Color(0xb2000000),
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center, // Mantener el texto centrado
            overflow = TextOverflow.Ellipsis,
        )

        // Text-1141:241-¿No recibiste un correo electronico?
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentHeight()
                .offset(x = 32.dp, y = 816.dp)
                .width(369.dp),
            text = "¿No recibiste un correo electronico?",
            color = Color(0xb2000000),
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-1141:242-Reenviar codigo
        Button(
            onClick = { /* Acción del botón */ },
            modifier = Modifier
                .align(Alignment.TopCenter) // Centrar el botón horizontalmente
                .offset(y = 869.dp) // Mantener el desplazamiento vertical
                .size(300.dp, 50.dp), // Hacer el botón más largo
        ) {
            Text(

                text = "Reenviar código",
                color = Color(0xffffffff), // Color del texto blanco
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
            )
        }



        // Image-1141:243-Line 11
        Image(
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 39.dp, y = 791.dp)
                .size(365.dp, 2.dp)
                .border(1.dp, Color(0xffcec7c7)),
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ChatScreen1Preview() {
    MaterialTheme {
        Olvidar1(

        )
    }
}