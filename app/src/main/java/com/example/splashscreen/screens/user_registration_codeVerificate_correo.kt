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
fun user_registration_codeve_correo(navController: NavController) {
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
        usertecodevView()
    }
}


@Composable
fun usertecodevView() {

        // Box-710:228-REGISTRO DE USUARIO 5
        Box(
            contentAlignment = Alignment.TopStart,
            modifier = Modifier
                .background(Color(0xffffffff))
                .size(430.dp, 960.dp)
                .clipToBounds(),
        ) {
            // Image-710:252-204736911-un-hombre-de-negocios-mirando-por-la-ventana-a-una-vista-de-la-ciudad-visión-empresarial-ideas-transformed 2
            Image(
                painter = painterResource(id = R.drawable.image4_751131),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = -5.dp, y = 0.dp)
                    .size(435.dp, 722.dp),
            )
            // Empty-710:253-Rectangle 691
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 0.dp, y = 309.dp)
                    .background(Color(0xfff5f5f3), RoundedCornerShape(20.dp))
                    .size(430.dp, 651.dp),
            )
            // Image-710:231-image 178
            Image(
                painter = painterResource(id = R.drawable.image7_751144),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 14.dp, y = 42.dp)
                    .size(216.dp, 89.dp),
            )
            // Empty-710:232-Rectangle 717
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 39.dp, y = 680.dp)
                    .background(Color(0xff38352e), RoundedCornerShape(10.dp))
                    .size(361.dp, 57.dp),
            )
            // Empty-710:266-Rectangle 728
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 40.dp, y = 848.dp)
                    .background(Color(0xff38352e), RoundedCornerShape(10.dp))
                    .size(361.dp, 57.dp),
            )
            // Text-710:233-Siguiente
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 155.dp, y = 693.dp)
                    .size(111.dp, 20.dp),
                text = "Siguiente",
                color = Color(0xfff9f7f3),
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
            )
            // Empty-710:235-Rectangle 722
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 33.dp, y = 531.dp)
                    .background(Color(0xfffcfcfc), RoundedCornerShape(20.dp))
                    .size(54.dp, 84.dp)
                    .border(1.dp, Color(0xff000000), RoundedCornerShape(20.dp)),
            )
            // Empty-710:261-Rectangle 723
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 96.dp, y = 531.dp)
                    .background(Color(0xfffcfcfc), RoundedCornerShape(20.dp))
                    .size(54.dp, 84.dp)
                    .border(1.dp, Color(0xff000000), RoundedCornerShape(20.dp)),
            )
            // Empty-710:262-Rectangle 724
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 159.dp, y = 531.dp)
                    .background(Color(0xfffcfcfc), RoundedCornerShape(20.dp))
                    .size(54.dp, 84.dp)
                    .border(1.dp, Color(0xff000000), RoundedCornerShape(20.dp)),
            )
            // Empty-710:263-Rectangle 725
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 222.dp, y = 531.dp)
                    .background(Color(0xfffcfcfc), RoundedCornerShape(20.dp))
                    .size(54.dp, 84.dp)
                    .border(1.dp, Color(0xff000000), RoundedCornerShape(20.dp)),
            )
            // Empty-710:264-Rectangle 726
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 285.dp, y = 531.dp)
                    .background(Color(0xfffcfcfc), RoundedCornerShape(20.dp))
                    .size(54.dp, 84.dp)
                    .border(1.dp, Color(0xff000000), RoundedCornerShape(20.dp)),
            )
            // Empty-710:265-Rectangle 727
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 348.dp, y = 531.dp)
                    .background(Color(0xfffcfcfc), RoundedCornerShape(20.dp))
                    .size(54.dp, 84.dp)
                    .border(1.dp, Color(0xff000000), RoundedCornerShape(20.dp)),
            )
            // Text-710:240-Codigo de confirmacion
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
            // Text-710:241-Le enviamos un correo electronico con el codigo de confirmacion a gustavo@gmail.com
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 24.dp, y = 416.dp)
                    .size(387.dp, 92.dp),
                text = "Le enviamos un correo electronico con el codigo de confirmacion a gustavo@gmail.com\n\n",
                color = Color(0xb2000000),
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
            )
            // Text-710:242-¿No recibiste un correo electronico?
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .wrapContentHeight()
                    .offset(x = 32.dp, y = 812.dp)
                    .width(369.dp),
                text = "¿No recibiste un correo electronico?",
                color = Color(0xb2000000),
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
            )
            // Text-710:267-Reenviar codigo
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .wrapContentHeight()
                    .offset(x = 43.dp, y = 865.dp)
                    .width(369.dp),
                text = "Reenviar codigo",
                color = Color(0xffffffff),
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
            )
            // Image-710:260-Line 11
            Image(
                painter = painterResource(id = R.drawable.banderagriga),
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
fun usercodevViewPreview() {
    val navController = rememberNavController() // Create a NavController for preview
    user_registration_codeve_correo(navController = navController) // Pass it to HomeScreen
}


