package com.example.splashscreen.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.R
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text


@Composable
fun HomeScreen(navController: NavController) {
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
        EmprendeMainView()
    }
}


@Composable
fun EmprendeMainView() {
    // Box-751:114-Home inicio sesion
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .background(Color(0xff000000))
            .size(430.dp, 2536.dp)
            .clipToBounds(),
    ) {
        // Image-751:115-204736911-un-hombre-de-negocios-mirando-por-la-ventana-a-una-vista-de-la-ciudad-visión-empresarial-ideas-transformed 2
        Image(
            painter = painterResource(id = R.drawable.image1_751115),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .size(438.dp, 633.dp),
        )
        // Empty-751:116-image 338
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .size(430.dp, 960.dp),
        )
        // Empty-751:117-image 339
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .size(430.dp, 960.dp),
        )
        // Empty-751:118-Rectangle 738
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 0.dp, y = 176.dp)
                .background(Color(0xfff5f5f3))
                .size(430.dp, 451.dp),
        )
        // Text-751:119-¡El enlace de emprendedores con inversionistas!
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 16.dp, y = 241.dp)
                .size(417.dp, 82.dp),
            text = "¡El enlace de emprendedores\n con  inversionistas!",
            color = Color(0xff000000),
            fontSize = 25.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-751:120-Emprende Link busca facilitar la colaboración y el crecimiento empresarial al conectar de manera eficiente a emprendedores con grandes empresas, creando oportunidades para el desarrollo conjunto de soluciones innovadoras.
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 23.dp, y = 338.dp)
                .size(393.dp, 144.dp),
            text = "Emprende Link busca facilitar la colaboración y el crecimiento empresarial al conectar de manera  eficiente a emprendedores con grandes empresas, creando oportunidades para el desarrollo  conjunto de soluciones innovadoras.",
            color = Color(0xb2000000),
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Empty-751:121-Rectangle 720
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 94.dp, y = 545.dp)
                .background(Color(0xff38352e), RoundedCornerShape(10.dp))
                .size(222.dp, 46.dp),
        )
        // Text-751:122-Crea tu empredimiento
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 59.dp, y = 553.dp)
                .size(292.dp, 26.dp),
            text = "Crea tu empredimiento",
            color = Color(0xffffffff),
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-751:125-¿Listo para comenzar?
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 105.dp, y = 497.dp)
                .size(223.dp, 33.dp),
            text = "¿Listo para comenzar?",
            color = Color(0xb2000000),
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Empty-751:126-Rectangle 745
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = -5.dp, y = 627.dp)
                .background(Color(0xff000000))
                .size(435.dp, 171.dp),
        )
        // Text-751:127-Crea tu propio emprendimiento
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 104.dp, y = 670.dp)
                .size(263.dp, 105.dp),
            text = "Crea tu propio emprendimiento",
            color = Color(0xffffffff),
            fontSize = 30.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Image-751:128-image 178
        Image(
            painter = painterResource(id = R.drawable.image2_751128),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 69.dp, y = 14.dp)
                .size(361.dp, 155.dp),
        )
        // Empty-751:129-Rectangle 746
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 0.dp, y = 798.dp)
                .background(Color(0xffd9d9d9), RoundedCornerShape(20.dp))
                .size(430.dp, 211.dp),
        )
        // Image-751:130-204736911-un-hombre-de-negocios-mirando-por-la-ventana-a-una-vista-de-la-ciudad-visión-empresarial-ideas-transformed 1
        Image(
            painter = painterResource(id = R.drawable.image3_751130),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 0.dp, y = 798.dp)
                .size(430.dp, 211.dp),
        )
        // Image-751:131-204736911-un-hombre-de-negocios-mirando-por-la-ventana-a-una-vista-de-la-ciudad-visión-empresarial-ideas-transformed 2
        Image(
            painter = painterResource(id = R.drawable.image4_751131),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 1.dp, y = 2323.dp)
                .size(430.dp, 915.dp),
        )
        // Text-751:132-Emprende
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 138.dp, y = 891.dp)
                .size(263.dp, 105.dp),
            text = "Emprende",
            color = Color(0xffffffff),
            fontSize = 30.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Image-751:133-Rectangle 747
        Image(
            painter = painterResource(id = R.drawable.image5_751133),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 0.dp, y = 1014.dp)
                .size(430.dp, 211.dp),
        )
        // Text-751:134-Invierte
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 158.dp, y = 1088.dp)
                .size(263.dp, 105.dp),
            text = "Invierte",
            color = Color(0xff000000),
            fontSize = 30.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Image-751:135-Rectangle 748
        Image(
            painter = painterResource(id = R.drawable.image6_751135),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 0.dp, y = 1230.dp)
                .size(434.dp, 211.dp),
        )
        // Text-751:136-Crear contactos
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 97.dp, y = 1320.dp)
                .size(263.dp, 105.dp),
            text = "Crear contactos",
            color = Color(0xffffffff),
            fontSize = 30.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-751:137-Emprende Link busca facilitar la colaboración y el crecimiento empresarial al conectar de manera eficiente a emprendedores con grandes empresas, creando oportunidades para el desarrollo conjunto de soluciones innovadoras.
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 25.dp, y = 1465.dp)
                .advancedShadow(
                    color = Color(0x3f000000),
                    alpha = 0.25f,
                    cornersRadius = 0.dp,
                    shadowBlurRadius = 4.dp,
                    offsetX = 0.dp,
                    offsetY = 4.dp
                )
                .size(392.dp, 205.dp),
            text = "Emprende Link busca facilitar la colaboración y el crecimiento empresarial al conectar de manera  eficiente a emprendedores con grandes empresas, creando oportunidades para el desarrollo  conjunto de soluciones innovadoras.",
            color = Color(0xffffffff),
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
        )
        // Empty-751:138-Rectangle 749
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 0.dp, y = 1908.dp)
                .background(Color(0xffffffff))
                .size(430.dp, 415.dp),
        )
        // Empty-751:139-Rectangle 750
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 133.dp, y = 2205.dp)
                .background(Color(0xff38352e), RoundedCornerShape(10.dp))
                .size(167.dp, 41.dp),
        )
        // Text-751:140-Crear un perfil
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 156.dp, y = 2211.dp)
                .size(138.dp, 29.dp),
            text = "Crear un perfil",
            color = Color(0xffffffff),
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-751:141-Sube de nivel tu negocio uniendote
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 60.dp, y = 1968.dp)
                .size(323.dp, 88.dp),
            text = "Sube de nivel tu negocio \nuniendote",
            color = Color(0xff000000),
            fontSize = 25.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-751:142-Asociese con mas emprededores para poder hacer progresar a tu negocio,o encuentra provedores de difenrentes productos
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 40.dp, y = 2037.dp)
                .size(340.dp, 168.dp),
            text = "Asociese con mas emprededores para poder hacer progresar a tu negocio,o encuentra provedores de difenrentes productos",
            color = Color(0xb2000000),
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-751:143-chat de emprendedores
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 87.dp, y = 1943.dp)
                .size(269.dp, 25.dp),
            text = "chat de emprendedores",
            color = Color(0xb2000000),
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
        )
        // Image-751:144-image 406
        Image(
            painter = painterResource(id = R.drawable.image7_751144),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 40.dp, y = 2335.dp)
                .size(374.dp, 132.dp),
        )
        // Text-751:145-2024 Emprende Link l Acerca de l politaca de privaciadad
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 66.dp, y = 2471.dp)
                .size(311.dp, 45.dp),
            text = " 2024 Emprende Link l Acerca de l politaca de privaciadad",
            color = Color(0xff000000),
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
        )
        // Image-751:146-image 415
        Image(
            painter = painterResource(id = R.drawable.image8_751146),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 0.dp, y = 1656.dp)
                .size(430.dp, 256.dp),
        )
        // Image-751:147-588a6507d06f6719692a2d15 3
        Image(
            painter = painterResource(id = R.drawable.image9_751147),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 14.dp, y = 36.dp)
                .size(55.dp, 55.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController() // Create a NavController for preview
    HomeScreen(navController = navController) // Pass it to HomeScreen
}