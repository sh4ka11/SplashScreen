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
fun user_registration_redes(navController: NavController) {
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
        userregister_redesView()
    }
}

/**
 * Created by codia-figma
 */
@Composable
fun userregister_redesView() {
        // Box-718:344-REGISTRO DE REDS
        Box(
            contentAlignment = Alignment.TopStart,
            modifier = Modifier
                .background(Color(0xffffffff))
                .size(430.dp, 960.dp)
                .clipToBounds(),
        ) {
            // Image-718:345-204736911-un-hombre-de-negocios-mirando-por-la-ventana-a-una-vista-de-la-ciudad-visión-empresarial-ideas-transformed 1
            Image(
                painter = painterResource(id = R.drawable.image4_751131),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = -5.dp, y = -6.dp)
                    .size(435.dp, 722.dp),
            )
            // Empty-718:346-Rectangle 691
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 0.dp, y = 527.dp)
                    .background(Color(0xfff5f5f3), RoundedCornerShape(20.dp))
                    .size(430.dp, 487.dp),
            )
            // Text-718:347-Resgistrarse en Emprede link
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
            // Image-718:348-image 178
            Image(
                painter = painterResource(id = R.drawable.image7_751144),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 14.dp, y = 42.dp)
                    .size(216.dp, 89.dp),
            )
            // Empty-718:349-Rectangle 717
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 52.dp, y = 860.dp)
                    .background(Color(0xff38352e), RoundedCornerShape(10.dp))
                    .size(334.dp, 43.dp),
            )
            // Text-718:350-Saltar
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 159.dp, y = 871.dp)
                    .size(111.dp, 20.dp),
                text = "Saltar",
                color = Color(0xfff9f7f3),
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
            )
            // Empty-718:353-Line 5
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 45.dp, y = 617.dp)
                    .size(348.dp, 1.dp)
                    .border(1.dp, Color(0xffcec7c7)),
            )
            // Text-718:360-Completaremos tu perfil de Emprede link por usted.Puede agregar el resto de tus redes despues.
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 30.dp, y = 637.dp)
                    .size(387.dp, 92.dp),
                text = "Completaremos tu perfil de Emprede link por usted.Puede agregar el resto de tus redes despues.",
                color = Color(0xb2000000),
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
            )
            // Image-718:361-Rectangle 758
            Image(
                painter = painterResource(id = R.drawable.logoface),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 53.dp, y = 727.dp)
                    .size(106.dp, 103.dp),
            )
            // Empty-718:362-Rectangle 759
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 280.dp, y = 729.dp)
                    .background(Color(0xffffffff))
                    .size(106.dp, 103.dp),
            )
            // Image-718:366-image 422
            Image(
                painter = painterResource(id = R.drawable.linkedin),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 280.dp, y = 727.dp)
                    .size(107.dp, 102.dp),
            )
            // Image-718:363-Rectangle 760
            Image(
                painter = painterResource(id = R.drawable.tiktiklogo),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 166.dp, y = 727.dp)
                    .size(106.dp, 103.dp),
            )
        }
    }

@Preview(showBackground = true)
@Composable
fun user_redesaViewPreview() {
    val navController = rememberNavController() // Create a NavController for preview
    user_registration_redes(navController = navController) // Pass it to HomeScreen
}



