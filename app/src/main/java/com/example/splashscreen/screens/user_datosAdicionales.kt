package com.example.splashscreen.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.R


@Composable
fun user_datosAdicionales(navController: NavController) {
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
        user_datosAdiccView()
    }
}

@Composable
fun user_datosAdiccView() {
    // Box-718:369-REGISTRO DE DATOS ADICIONALES
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .background(Color(0xffffffff))
            .size(430.dp, 960.dp)
            .clipToBounds(),
    ) {
        // Image-718:370-204736911-un-hombre-de-negocios-mirando-por-la-ventana-a-una-vista-de-la-ciudad-visión-empresarial-ideas-transformed 1
        Image(
            painter = painterResource(id = R.drawable.image4_751131),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = -5.dp, y = -6.dp)
                .size(435.dp, 722.dp),
        )
        // Empty-718:371-Rectangle 691
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 0.dp, y = 118.dp)
                .background(Color(0xfff5f5f3), RoundedCornerShape(20.dp))
                .size(430.dp, 896.dp),
        )
        // Text-718:372-Informacion adcional
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentHeight()
                .offset(x = 86.dp, y = 151.dp)
                .width(373.dp),
            text = "Informacion adcional",
            color = Color(0xff000000),
            fontSize = 25.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Image-718:373-image 178
        Image(
            painter = painterResource(id = R.drawable.image7_751144),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 3.dp, y = 14.dp)
                .size(216.dp, 89.dp),
        )
        // Empty-718:374-Rectangle 717
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 48.dp, y = 861.dp)
                .background(Color(0xff38352e), RoundedCornerShape(10.dp))
                .size(334.dp, 43.dp),
        )
        // Text-718:375-Siguiente
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 155.dp, y = 872.dp)
                .size(111.dp, 20.dp),
            text = "Siguiente",
            color = Color(0xfff9f7f3),
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
        )
        // Empty-718:376-Line 5
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 30.dp, y = 192.dp)
                .size(377.dp, 1.dp)
                .border(1.dp, Color(0xffcec7c7)),
        )
        // Text-718:377-Completaremos tu perfil de Emprede link por usted.Puede agregar tus datos ahora o puedes darle siguiente y despues los puedes ingresar.
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 30.dp, y = 205.dp)
                .size(387.dp, 92.dp),
            text = "Completaremos tu perfil de Emprede link por usted.Puede agregar tus datos ahora   \no puedes darle siguiente y despues los puedes ingresar.",
            color = Color(0xb2000000),
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-718:382-Nombre
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 41.dp, y = 315.dp)
                .size(152.dp, 45.dp),
            text = "Nombre",
            color = Color(0xff000000),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-718:383-Fecha de nacimiento
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 41.dp, y = 388.dp)
                .size(267.dp, 29.dp),
            text = "Fecha de nacimiento",
            color = Color(0xff000000),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-718:384-Ubicacion
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 39.dp, y = 465.dp)
                .size(161.dp, 43.dp),
            text = "Ubicacion",
            color = Color(0xff000000),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-1255:686-Telefono
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 39.dp, y = 536.dp)
                .size(161.dp, 43.dp),
            text = "Telefono",
            color = Color(0xff000000),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-718:385-Celular
        Text(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset(x = -267.dp, y = 516.dp)
                .size(119.dp, 44.dp),
            text = "Celular",
            color = Color(0xff000000),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-718:386-Genero
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 39.dp, y = 608.dp)
                .size(126.dp, 47.dp),
            text = "Genero",
            color = Color(0xff000000),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Empty-718:387-Rectangle 707
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 30.dp, y = 338.dp)
                .background(Color(0xffededed), RoundedCornerShape(10.dp))
                .size(382.dp, 44.dp)
                .border(2.dp, Color(0xff000000), RoundedCornerShape(10.dp)),
        )
        // Empty-718:388-Rectangle 708
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 30.dp, y = 408.dp)
                .background(Color(0xffededed), RoundedCornerShape(10.dp))
                .size(382.dp, 45.dp)
                .border(2.dp, Color(0xff000000), RoundedCornerShape(10.dp)),
        )
        // Empty-718:389-Rectangle 710
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 30.dp, y = 486.dp)
                .background(Color(0xffededed), RoundedCornerShape(10.dp))
                .size(382.dp, 45.dp)
                .border(2.dp, Color(0xff000000), RoundedCornerShape(10.dp)),
        )
        // Text-718:390-POPAYAN-Cauca-Colombia
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 36.dp, y = 495.dp)
                .size(362.dp, 43.dp),
            text = "POPAYAN-Cauca-Colombia",
            color = Color(0xff000000),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Empty-718:391-Rectangle 711
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 30.dp, y = 556.dp)
                .background(Color(0xffededed), RoundedCornerShape(10.dp))
                .size(382.dp, 46.dp)
                .border(2.dp, Color(0xff000000), RoundedCornerShape(10.dp)),
        )
        // Text-718:392-3214567890
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 41.dp, y = 565.dp)
                .size(357.dp, 45.dp),
            text = "3214567890",
            color = Color(0xff000000),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Empty-718:393-Rectangle 713
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 30.dp, y = 632.dp)
                .background(Color(0xffededed), RoundedCornerShape(10.dp))
                .size(382.dp, 46.dp)
                .border(2.dp, Color(0xff000000), RoundedCornerShape(10.dp)),
        )
        // Text-718:394-MASCULINO


    }}


@Preview(showBackground = true)
@Composable
fun user_datosViewPreview() {
    val navController = rememberNavController() // Create a NavController for preview
    user_registration_redes(navController = navController) // Pass it to HomeScreen
}


