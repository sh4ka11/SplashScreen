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
fun user_registration_te(navController: NavController) {
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
        userteView()
    }
}

/**
 * Created by codia-figma
 */
@Composable
fun userteView() {
    // Box-706:176-REGISTRO DE USUARIO 3
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .background(Color(0xffffffff))
            .size(430.dp, 960.dp)
            .clipToBounds(),
    ) {
        // Image-710:251-204736911-un-hombre-de-negocios-mirando-por-la-ventana-a-una-vista-de-la-ciudad-visión-empresarial-ideas-transformed 1
        Image(
            painter = painterResource(id = R.drawable.image4_751131),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = -5.dp, y = -6.dp)
                .size(435.dp, 722.dp),
        )
        // Empty-706:178-Rectangle 691
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 0.dp, y = 527.dp)
                .background(Color(0xfff5f5f3), RoundedCornerShape(20.dp))
                .size(430.dp, 487.dp),
        )
        // Text-706:179-Resgistrarse en Emprede link
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentHeight()
                .offset(x = 45.dp, y = 556.dp)
                .width(373.dp),
            text = "Resgistrarse en Emprede link",
            color = Color(0xff000000),
            fontSize = 25.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Image-706:185-image 178
        Image(
            painter = painterResource(id = R.drawable.image7_751144),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 5.dp, y = 25.dp)
                .size(216.dp, 89.dp),
        )
        // Empty-706:183-Rectangle 717
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 53.dp, y = 808.dp)
                .background(Color(0xff38352e), RoundedCornerShape(10.dp))
                .size(334.dp, 43.dp),
        )
        // Text-706:184-Siguiente
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 160.dp, y = 819.dp)
                .size(111.dp, 20.dp),
            text = "Siguiente",
            color = Color(0xfff9f7f3),
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-706:187-¿Necesitas Ayuda?
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 140.dp, y = 879.dp)
                .size(148.dp, 25.dp),
            text = "¿Necesitas Ayuda?",
            color = Color(0xff000000),
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Empty-706:192-Rectangle 721
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 45.dp, y = 716.dp)
                .background(Color(0xfffcfcfc), RoundedCornerShape(20.dp))
                .size(342.dp, 54.dp)
                .border(1.dp, Color(0xff000000), RoundedCornerShape(20.dp)),
        )
        // Empty-710:202-Line 5
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 39.dp, y = 661.dp)
                .size(348.dp, 1.dp)
                .border(1.dp, Color(0xffcec7c7)),
        )
        // Empty-710:204-Line 7
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 226.dp, y = 661.dp)
                .size(161.dp, 1.dp)
                .border(1.dp, Color(0xff000000)),
        )
        // Text-710:205-Telefono
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentSize()
                .offset(x = 251.dp, y = 612.dp),
            text = "Telefono",
            color = Color(0xff000000),
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-710:309-+1
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentSize()
                .offset(x = 110.dp, y = 730.dp),
            text = "+1",
            color = Color(0xff000000),
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-710:206-Correo
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentSize()
                .offset(x = 93.dp, y = 612.dp),
            text = "Correo",
            color = Color(0xb2000000),
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Image-710:219-Line 10
        Image(
            painter = painterResource(id = R.drawable.banderagriga),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 98.dp, y = 727.dp)
                .size(1.dp, 33.dp)
                .border(1.dp, Color(0x4c000000)),
        )
        // Image-710:308-image 398
        Image(
            painter = painterResource(id = R.drawable.banderagriga),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 53.dp, y = 727.dp)
                .size(33.dp, 33.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun userteViewPreview() {
    val navController = rememberNavController() // Create a NavController for preview
    user_registration_te(navController = navController) // Pass it to HomeScreen
}


