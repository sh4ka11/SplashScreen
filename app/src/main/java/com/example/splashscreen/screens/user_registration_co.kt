package com.example.splashscreen.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.R

@Composable
fun user_registration_co(navController: NavController) {
    // Use a vertical scroll state for scrolling functionality
    val scrollState = rememberScrollState()

    // Column layout with a vertical scroll modifier
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState), // Apply vertical scroll modifier here
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Call to EmprendeMainView (if this is your main content)
        userMainView()
    }
}



@Composable
fun userMainView() {
    // Box-710:207-REGISTRO DE USUARIO 4
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .background(Color(0xffffffff))
            .size(430.dp, 960.dp)
            .clipToBounds(),
    ) {
        // Image-710:248-204736911-un-hombre-de-negocios-mirando-por-la-ventana-a-una-vista-de-la-ciudad-visión-empresarial-ideas-transformed 1
        Image(
            painter = painterResource(id = R.drawable.image4_751131),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = -8.dp, y = -73.dp)
                .size(438.dp, 644.dp),
        )
        // Empty-710:208-Rectangle 691
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 0.dp, y = 328.dp)
                .background(Color(0xfff5f5f3), RoundedCornerShape(20.dp))
                .size(430.dp, 632.dp),
        )
        // Image-710:210-image 178
        Image(
            painter = painterResource(id = R.drawable.image7_751144),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 14.dp, y = 42.dp)
                .size(216.dp, 89.dp),
        )
        // Empty-710:211-Rectangle 717
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 75.dp, y = 672.dp)
                .background(Color(0xff38352e), RoundedCornerShape(10.dp))
                .size(281.dp, 37.dp),
        )
        // Text-710:212-Siguiente
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 166.dp, y = 680.dp)
                .size(111.dp, 20.dp),
            text = "Siguiente",
            color = Color(0xfff9f7f3),
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
        )
        // Empty-710:214-Rectangle 721
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 27.dp, y = 590.dp)
                .background(Color(0xfffcfcfc), RoundedCornerShape(20.dp))
                .size(386.dp, 54.dp)
                .border(1.dp, Color(0xff000000), RoundedCornerShape(20.dp)),
        )
        // Empty-710:221-Rectangle 722
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 24.dp, y = 508.dp)
                .background(Color(0xfffcfcfc), RoundedCornerShape(20.dp))
                .size(389.dp, 54.dp)
                .border(1.dp, Color(0xff000000), RoundedCornerShape(20.dp)),
        )
        // Empty-710:215-Line 5
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 44.dp, y = 480.dp)
                .size(348.dp, 1.dp)
                .border(1.dp, Color(0xffcec7c7)),
        )
        // Empty-710:216-Line 7
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 44.dp, y = 480.dp)
                .size(161.dp, 1.dp)
                .border(1.dp, Color(0xff000000)),
        )
        // Text-710:217-Telefono
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentSize()
                .offset(x = 255.dp, y = 431.dp),
            text = "Telefono",
            color = Color(0xb2000000),
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-710:218-Correo
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentSize()
                .offset(x = 80.dp, y = 431.dp),
            text = "Correo",
            color = Color(0xff000000),
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-710:220-Resgistrarse en Emprede link
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentHeight()
                .offset(x = 44.dp, y = 370.dp)
                .width(373.dp),
            text = "Resgistrarse en Emprede link",
            color = Color(0xff000000),
            fontSize = 25.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-710:222-Al proporcionar su número de teléfono a Emprede link, usted acepta recibir mensajes SMS con notificaciones relacionadas con su cuenta. Es posible que se apliquen mensajes estándar
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 44.dp, y = 732.dp)
                .size(369.dp, 92.dp),
            text = "Al proporcionar su número de teléfono a Emprede link, usted acepta recibir mensajes SMS con notificaciones relacionadas con su cuenta. Es posible que se apliquen mensajes estándar\n\n",
            color = Color(0xb2000000),
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-710:223-¿Ya tienes una cuenta?
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentHeight()
                .offset(x = -49.dp, y = 856.dp)
                .width(369.dp),
            text = "¿Ya tienes una cuenta?",
            color = Color(0xb2000000),
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-710:224-Iniciar sesión
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentHeight()
                .offset(x = 221.dp, y = 856.dp)
                .width(156.dp),
            text = " Iniciar sesión",
            color = Color(0xff000000),
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-718:298-Correo electronico
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 28.dp, y = 521.dp)
                .size(381.dp, 28.dp),
            text = "Correo electronico",
            color = Color(0xb2000000),
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-718:299-Crear contraseña
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 33.dp, y = 603.dp)
                .size(381.dp, 28.dp),
            text = "Crear contraseña",
            color = Color(0xb2000000),
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun userViewPreview() {
    val navController = rememberNavController() // Create a NavController for preview
    user_registration_co(navController = navController) // Pass it to HomeScreen
}


