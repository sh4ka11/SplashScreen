package com.example.splashscreen.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.R
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
import com.example.splashscreen.ui.theme.SplashScreenTheme
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


/**
 * Created by codia-figma
 */
@Composable
fun UserProfileMainView(navController: NavController = rememberNavController()) {
    // Box-920:214-Perfil de usuario
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .background(Color(0xffffffff))
            .size(430.dp, 894.dp)
            .clipToBounds(),
    ) {
        // Image-920:215-image 434
        Image(
            painter = painterResource(id = com.example.splashscreen.R.drawable.image1_920215),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 0.dp, y = -2.dp)
                .size(672.dp, 896.dp),
        )
        // Image-920:216-image 190
        Image(
            painter = painterResource(id = com.example.splashscreen.R.drawable.image2_920216),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 503.dp, y = 308.dp)
                .size(36.dp, 33.dp),
        )
        // Empty-647:597-Rectangle 717
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 11.dp, y = 118.dp)
                .background(Color(0xffd9d9d9), RoundedCornerShape(20.dp))
                .size(409.dp, 123.dp)
                .border(2.dp, Color(0xffd9d9d9), RoundedCornerShape(20.dp)),
        )
        // Empty-647:631-Rectangle 720
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 0.dp, y = 259.dp)
                .background(Color(0xffd9d9d9), RoundedCornerShape(20.dp))
                .size(413.dp, 402.dp)
                .border(2.dp, Color(0xffd9d9d9), RoundedCornerShape(20.dp)),
        )
        // Text-647:606-Nombre:
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 148.dp, y = 129.dp)
                .size(124.dp, 29.dp),
            text = "Nombre:   ",
            color = Color(0xff000000),
            fontSize = 13.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-647:605-Cristian sebastian delgado calvache
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 148.dp, y = 150.dp)
                .size(302.dp, 17.dp),
            text = "Miiguel sebastian delgado calvache",
            color = Color(0xff000000),
            fontSize = 13.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Image-647:598-image 12
        Image(
            painter = painterResource(id = com.example.splashscreen.R.drawable.image3_647598),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 11.dp, y = 118.dp)
                .size(119.dp, 123.dp)
                .border(4.dp, Color(0xffd9d9d9), RoundedCornerShape(360.dp)),
        )
        // Empty-647:599-Rectangle 718
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 282.dp, y = 190.dp)
                .background(Color(0xff38352e), RoundedCornerShape(20.dp))
                .size(125.dp, 42.dp),
        )
        // Empty-647:600-Rectangle 719
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 148.dp, y = 190.dp)
                .background(Color(0xff38352e), RoundedCornerShape(20.dp))
                .size(119.dp, 42.dp),
        )
        // Text-647:602-Editar perfil
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 167.dp, y = 202.dp)
                .size(91.dp, 19.dp),
            text = "Editar perfil",
            color = Color(0xffffffff),
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-647:603-Compartir perfil
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 288.dp, y = 202.dp)
                .size(137.dp, 19.dp),
            text = "Compartir perfil",
            color = Color(0xffffffff),
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Image-647:607-588a6507d06f6719692a2d15 3
        Image(
            painter = painterResource(id = com.example.splashscreen.R.drawable.menu2),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 11.dp, y = 30.dp)
                .size(54.dp, 55.dp),
        )
        // Text-647:610-Fecha de nacimiento
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 25.dp, y = 274.dp)
                .size(70.dp, 49.dp),
            text = "Fecha de\nnacimiento",
            color = Color(0xff000000),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-647:611-Correo
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 28.dp, y = 337.dp)
                .size(95.dp, 38.dp),
            text = "Correo",
            color = Color(0xff000000),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-647:612-Ubicacion
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 25.dp, y = 381.dp)
                .size(132.dp, 38.dp),
            text = "Ubicacion",
            color = Color(0xff000000),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-647:613-Celular
        Text(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset(x = -307.dp, y = 442.dp)
                .size(98.dp, 37.dp),
            text = "Celular",
            color = Color(0xff000000),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-647:614-Genero
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 25.dp, y = 490.dp)
                .size(103.dp, 39.dp),
            text = "Genero",
            color = Color(0xff000000),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-647:615-Etapa
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 25.dp, y = 553.dp)
                .size(104.dp, 36.dp),
            text = "Etapa ",
            color = Color(0xff000000),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Empty-647:616-Rectangle 708
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 99.dp, y = 273.dp)
                .background(Color(0xffededed), RoundedCornerShape(10.dp))
                .size(314.dp, 35.dp)
                .border(2.dp, Color(0xff000000), RoundedCornerShape(10.dp)),
        )
        // Empty-647:617-Rectangle 710
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 101.dp, y = 375.dp)
                .background(Color(0xffededed), RoundedCornerShape(10.dp))
                .size(313.dp, 36.dp)
                .border(2.dp, Color(0xff000000), RoundedCornerShape(10.dp)),
        )
        // Text-647:618-POPAYAN-Cauca-Colombia
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 106.dp, y = 384.dp)
                .size(308.dp, 27.dp),
            text = "POPAYAN-Cauca-Colombia",
            color = Color(0xff000000),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Empty-647:619-Rectangle 711
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 101.dp, y = 431.dp)
                .background(Color(0xffededed), RoundedCornerShape(10.dp))
                .size(313.dp, 38.dp)
                .border(2.dp, Color(0xff000000), RoundedCornerShape(10.dp)),
        )
        // Text-647:620-3214567890
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 108.dp, y = 442.dp)
                .size(308.dp, 35.dp),
            text = "3214567890",
            color = Color(0xff000000),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Empty-647:621-Rectangle 713
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 101.dp, y = 482.dp)
                .background(Color(0xffededed), RoundedCornerShape(10.dp))
                .size(312.dp, 37.dp)
                .border(2.dp, Color(0xff000000), RoundedCornerShape(10.dp)),
        )
        // Text-647:622-MASCULINO
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 104.dp, y = 491.dp)
                .size(304.dp, 28.dp),
            text = "MASCULINO",
            color = Color(0xff000000),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Empty-647:623-Rectangle 714
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 100.dp, y = 540.dp)
                .background(Color(0xffededed), RoundedCornerShape(10.dp))
                .size(312.dp, 37.dp)
                .border(2.dp, Color(0xff000000), RoundedCornerShape(10.dp)),
        )
        // Text-647:624-Primera fase: la idea de negocio
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 103.dp, y = 549.dp)
                .size(304.dp, 32.dp),
            text = "Primera fase: la idea de negocio",
            color = Color(0xff000000),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-647:625-DOCUMENTO
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 19.dp, y = 610.dp)
                .size(103.dp, 36.dp),
            text = "DOCUMENTO",
            color = Color(0xff000000),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Empty-647:626-Rectangle 716
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 99.dp, y = 601.dp)
                .background(Color(0xffededed), RoundedCornerShape(10.dp))
                .size(312.dp, 36.dp)
                .border(2.dp, Color(0xff000000), RoundedCornerShape(10.dp)),
        )
        // Text-647:627-19861598659864
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 108.dp, y = 607.dp)
                .size(304.dp, 32.dp),
            text = "19861598659864",
            color = Color(0xff000000),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Empty-647:628-Rectangle 709
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 99.dp, y = 328.dp)
                .background(Color(0xffededed), RoundedCornerShape(10.dp))
                .size(314.dp, 36.dp)
                .border(2.dp, Color(0xff000000), RoundedCornerShape(10.dp)),
        )
        // Text-647:629-sdp402@gmail.com
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 106.dp, y = 336.dp)
                .size(302.dp, 28.dp),
            text = "sdp402@gmail.com",
            color = Color(0xff000000),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-647:630-Nacido(a) el 05 de septiembre de 2002
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 106.dp, y = 282.dp)
                .size(308.dp, 20.dp),
            text = "Nacido(a) el 05 de septiembre de  2002",
            color = Color(0xff000000),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
    }
}



@Preview(showBackground = true)
@Composable
fun UserProfileMainViewPreview() {
    SplashScreenTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val scrollState = rememberScrollState()
            Column(modifier = Modifier.verticalScroll(scrollState)) {
                UserProfileMainView()  // No es necesario pasar navController en la vista previa
            }
        }
    }
}

