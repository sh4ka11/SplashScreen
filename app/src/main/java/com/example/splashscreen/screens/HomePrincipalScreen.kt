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
fun HomePrincipalScreen(navController: NavController) {
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
//        CodiaMainView()
    }
}

//@Composable
//fun CodiaMainView() {
//    // Box-710:268-HOME-
//    Box(
//        contentAlignment = Alignment.TopStart,
//        modifier = Modifier
//            .background(Color(0xff000000))
//            .size(430.dp, 2536.dp)
//            .clipToBounds(),
//    ) {
//        // Image-718:277-204736911-un-hombre-de-negocios-mirando-por-la-ventana-a-una-vista-de-la-ciudad-visión-empresarial-ideas-transformed 2
//        Image(
//            painter = painterResource(id = R.drawable.image1_751115),
//            contentDescription = null,
//            contentScale = ContentScale.FillBounds,
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = 5.dp, y = 0.dp)
//                .size(438.dp, 633.dp),
//        )
//        // Empty-710:269-image 338
//        Box(
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .size(430.dp, 960.dp),
//        )
//        // Empty-710:291-image 339
//        Box(
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .size(430.dp, 960.dp),
//        )
//        // Empty-718:98-Rectangle 738
//        Box(
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = 5.dp, y = 176.dp)
//                .background(Color(0xfff5f5f3))
//                .size(430.dp, 436.dp),
//        )
//        // Text-718:101-¡El enlace de emprendedores con inversionistas!
//        Text(
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = 16.dp, y = 241.dp)
//                .size(417.dp, 82.dp),
//            text = "¡El enlace de emprendedores\n con  inversionistas!",
//            color = Color(0xff000000),
//            fontSize = 25.sp,
//            fontWeight = FontWeight.Normal,
//            textAlign = TextAlign.Center,
//            overflow = TextOverflow.Ellipsis,
//        )
//        // Text-718:107-Emprende Link busca facilitar la colaboración y el crecimiento empresarial al conectar de manera eficiente a emprendedores con grandes empresas, creando oportunidades para el desarrollo conjunto de soluciones innovadoras.
//        Text(
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = 23.dp, y = 338.dp)
//                ,
//            text = "Emprende Link busca facilitar la colaboración y el crecimiento empresarial al conectar de manera  eficiente a emprendedores con grandes empresas, creando oportunidades para el desarrollo  conjunto de soluciones innovadoras.",
//            color = Color(0xb2000000),
//            fontSize = 16.sp,
//            fontWeight = FontWeight.Normal,
//            textAlign = TextAlign.Left,
//            overflow = TextOverflow.Ellipsis,
//        )
//        // Empty-718:108-Rectangle 720
//        Box(
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = 45.dp, y = 565.dp)
//                .background(Color(0xffffffff), RoundedCornerShape(10.dp))
//                .size(154.dp, 33.dp),
//        )
//        // Text-718:109-Iniciar Sesion
//        Text(
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = 67.dp, y = 569.dp)
//                .size(138.dp, 29.dp),
//            text = "Iniciar Sesion",
//            color = Color(0xff000000),
//            fontSize = 18.sp,
//            fontWeight = FontWeight.Normal,
//            textAlign = TextAlign.Left,
//            overflow = TextOverflow.Ellipsis,
//        )
//        // Empty-718:110-Rectangle 719
//        Box(
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = 238.dp, y = 565.dp)
//                .background(Color(0xff38352e), RoundedCornerShape(10.dp))
//                .size(154.dp, 33.dp),
//        )
//        // Text-718:111-Crear Cuenta
//        Text(
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = 255.dp, y = 569.dp)
//                .size(138.dp, 29.dp),
//            text = "Crear Cuenta",
//            color = Color(0xffffffff),
//            fontSize = 18.sp,
//            fontWeight = FontWeight.Normal,
//            textAlign = TextAlign.Left,
//            overflow = TextOverflow.Ellipsis,
//        )
//        // Text-718:112-¿Listo para comenzar?
//        Text(
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = 122.dp, y = 515.dp)
//                .size(223.dp, 33.dp),
//            text = "¿Listo para comenzar?",
//            color = Color(0xb2000000),
//            fontSize = 18.sp,
//            fontWeight = FontWeight.Normal,
//            textAlign = TextAlign.Left,
//            overflow = TextOverflow.Ellipsis,
//        )
//        // Empty-718:113-Rectangle 745
//        Box(
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = -5.dp, y = 627.dp)
//                .background(Color(0xff000000))
//                .size(435.dp, 171.dp),
//        )
//        // Text-718:114-Crea tu propio emprendimiento
//        Text(
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = 104.dp, y = 670.dp)
//                .size(263.dp, 105.dp),
//            text = "Crea tu propio emprendimiento",
//            color = Color(0xffffffff),
//            fontSize = 30.sp,
//            fontWeight = FontWeight.Normal,
//            textAlign = TextAlign.Left,
//            overflow = TextOverflow.Ellipsis,
//        )
//        // Image-718:115-image 178
//        Image(
//            painter = painterResource(id = R.drawable.image2_751128),
//            contentDescription = null,
//            contentScale = ContentScale.FillBounds,
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = 58.dp, y = 21.dp)
//                .size(340.dp, 155.dp),
//        )
//        // Empty-718:238-Rectangle 746
//        Box(
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = 0.dp, y = 798.dp)
//                .background(Color(0xffd9d9d9), RoundedCornerShape(20.dp))
//                .size(430.dp, 211.dp),
//        )
//        // Image-718:247-204736911-un-hombre-de-negocios-mirando-por-la-ventana-a-una-vista-de-la-ciudad-visión-empresarial-ideas-transformed 1
//        Image(
//            painter = painterResource(id = R.drawable.image3_751130),
//            contentDescription = null,
//            contentScale = ContentScale.FillBounds,
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = 0.dp, y = 798.dp)
//                .size(430.dp, 211.dp),
//        )
//        // Image-718:276-204736911-un-hombre-de-negocios-mirando-por-la-ventana-a-una-vista-de-la-ciudad-visión-empresarial-ideas-transformed 2
//        Image(
//            painter = painterResource(id = R.drawable.image4_751131),
//            contentDescription = null,
//            contentScale = ContentScale.FillBounds,
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = 1.dp, y = 2323.dp)
//                .size(430.dp, 730.dp),
//        )
//        // Text-718:242-Emprende
//        Text(
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = 138.dp, y = 891.dp)
//                .size(263.dp, 105.dp),
//            text = "Emprende",
//            color = Color(0xffffffff),
//            fontSize = 30.sp,
//            fontWeight = FontWeight.Normal,
//            textAlign = TextAlign.Left,
//            overflow = TextOverflow.Ellipsis,
//        )
//        // Image-718:239-Rectangle 747
//        Image(
//            painter = painterResource(id = R.drawable.image5_751133),
//            contentDescription = null,
//            contentScale = ContentScale.FillBounds,
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = 0.dp, y = 1014.dp)
//                .size(430.dp, 211.dp),
//        )
//        // Text-718:243-Invierte
//        Text(
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = 158.dp, y = 1088.dp)
//                .size(263.dp, 105.dp),
//            text = "Invierte",
//            color = Color(0xff000000),
//            fontSize = 30.sp,
//            fontWeight = FontWeight.Normal,
//            textAlign = TextAlign.Left,
//            overflow = TextOverflow.Ellipsis,
//        )
//        // Image-718:240-Rectangle 748
//        Image(
//            painter = painterResource(id = R.drawable.image6_751135),
//            contentDescription = null,
//            contentScale = ContentScale.FillBounds,
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = 0.dp, y = 1230.dp)
//                .size(434.dp, 211.dp),
//        )
//        // Text-718:245-Crear contactos
//        Text(
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = 97.dp, y = 1320.dp)
//                .size(263.dp, 105.dp),
//            text = "Crear contactos",
//            color = Color(0xffffffff),
//            fontSize = 30.sp,
//            fontWeight = FontWeight.Normal,
//            textAlign = TextAlign.Left,
//            overflow = TextOverflow.Ellipsis,
//        )
//        // Text-718:248-Emprende Link busca facilitar la colaboración y el crecimiento empresarial al conectar de manera eficiente a emprendedores con grandes empresas, creando oportunidades para el desarrollo conjunto de soluciones innovadoras.
//        Text(
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = 25.dp, y = 1465.dp)
//                .advancedShadow(color = Color(0x3f000000), alpha = 0.25f, cornersRadius = 0.dp, shadowBlurRadius = 4.dp, offsetX = 0.dp, offsetY = 4.dp)
//                .size(392.dp, 205.dp),
//            text = "Emprende Link busca facilitar la colaboración y el crecimiento empresarial al conectar de manera  eficiente a emprendedores con grandes empresas, creando oportunidades para el desarrollo  conjunto de soluciones innovadoras.",
//            color = Color(0xffffffff),
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Normal,
//            textAlign = TextAlign.Center,
//            overflow = TextOverflow.Ellipsis,
//        )
//        // Empty-718:251-Rectangle 749
//        Box(
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = 0.dp, y = 1908.dp)
//                .background(Color(0xffffffff))
//                .size(430.dp, 415.dp),
//        )
//        // Empty-1255:526-Rectangle 751
//        Box(
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = 54.dp, y = 2212.dp)
//                .background(Color(0xffd9d9d9), RoundedCornerShape(10.dp))
//                .size(154.dp, 52.dp),
//        )
//        // Text-1255:527-Iniciar Sesion Como Inversor
//        Text(
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = 71.dp, y = 2216.dp)
//                .size(138.dp, 29.dp),
//            text = "Iniciar Sesion\nComo Inversor",
//            color = Color(0xff000000),
//            fontSize = 18.sp,
//            fontWeight = FontWeight.Normal,
//            textAlign = TextAlign.Left,
//            overflow = TextOverflow.Ellipsis,
//        )
//        // Empty-718:257-Rectangle 750
//        Box(
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = 227.dp, y = 2212.dp)
//                .background(Color(0xff38352e), RoundedCornerShape(10.dp))
//                .size(170.dp, 52.dp),
//        )
//        // Text-718:258-Crear Cuenta Como Inversor
//        Text(
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = 252.dp, y = 2216.dp)
//                .size(138.dp, 29.dp),
//            text = " Crear Cuenta\nComo Inversor",
//            color = Color(0xffffffff),
//            fontSize = 18.sp,
//            fontWeight = FontWeight.Normal,
//            textAlign = TextAlign.Left,
//            overflow = TextOverflow.Ellipsis,
//        )
//        // Text-718:252-Crear Cuenta Como Inversor
//        Text(
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = 54.dp, y = 1963.dp)
//                .size(323.dp, 88.dp),
//            text = " Crear Cuenta \nComo Inversor",
//            color = Color(0xff000000),
//            fontSize = 30.sp,
//            fontWeight = FontWeight.Normal,
//            textAlign = TextAlign.Center,
//            overflow = TextOverflow.Ellipsis,
//        )
//        // Text-718:253-Asociese con mas emprededores para poder hacer progresar a tu negocio,o encuentra provedores de difenrentes productos
//        Text(
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = 40.dp, y = 2037.dp)
//                .size(340.dp, 168.dp),
//            text = "Asociese con mas emprededores para poder hacer progresar a tu negocio,o encuentra provedores de difenrentes productos",
//            color = Color(0xb2000000),
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Normal,
//            textAlign = TextAlign.Center,
//            overflow = TextOverflow.Ellipsis,
//        )
//        // Image-718:263-image 406
//        Image(
//            painter = painterResource(id = R.drawable.image7_751144),
//            contentDescription = null,
//            contentScale = ContentScale.FillBounds,
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = 40.dp, y = 2335.dp)
//                .size(374.dp, 132.dp),
//        )
//        // Text-718:267-2024 Emprende Link l Acerca de l politaca de privaciadad
//        Text(
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = 66.dp, y = 2471.dp)
//                .size(311.dp, 45.dp),
//            text = " 2024 Emprende Link l Acerca de l politaca de privaciadad",
//            color = Color(0xff000000),
//            fontSize = 18.sp,
//            fontWeight = FontWeight.Normal,
//            textAlign = TextAlign.Center,
//            overflow = TextOverflow.Ellipsis,
//        )
//        // Image-718:271-image 415
//        Image(
//            painter = painterResource(id = R.drawable.image8_751146),
//            contentDescription = null,
//            contentScale = ContentScale.FillBounds,
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = 0.dp, y = 1656.dp)
//                .size(430.dp, 256.dp),
//        )
//        // Image-751:148-588a6507d06f6719692a2d15 3
//        Image(
//            painter = painterResource(id = R.drawable.image9_751147),
//            contentDescription = null,
//            contentScale = ContentScale.FillBounds,
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .offset(x = 8.dp, y = 43.dp)
//                .size(55.dp, 55.dp),
//        )
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun HomePrincipalScreenViewPreview() {
//    val navController = rememberNavController() // Create a NavController for preview
//    HomePrincipalScreen(navController = navController) // Pass it to HomeScreen
//}


