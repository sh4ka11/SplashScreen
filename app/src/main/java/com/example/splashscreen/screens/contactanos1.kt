package com.example.splashsreen.screens

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
import com.example.splashscreen.R
import com.example.splashscreen.ui.theme.SplashScreenTheme



@Composable
fun Contactanos() {
    // Box-1063:1429-Contactanos
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .background(Color(0xffffffff))
            .size(430.dp, 894.dp)
            .clipToBounds(),
    ) {
        // Image-1063:1430-image 435
        Image(
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 0.dp, y = 79.dp)
                .size(430.dp, 815.dp),
        )
        // Empty-1063:1431-Rectangle 742
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 20.dp, y = 424.dp)
                .background(Color(0xffffffff), RoundedCornerShape(10.dp))
                .size(387.dp, 62.dp),
        )
        // Empty-1063:1827-Rectangle 745
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 20.dp, y = 495.dp)
                .background(Color(0xffffffff), RoundedCornerShape(10.dp))
                .size(387.dp, 62.dp),
        )
        // Image-1063:1434-image 190
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 503.dp, y = 308.dp)
                .size(36.dp, 33.dp),
        )
        // Empty-1063:1435-Rectangle 676
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 20.dp, y = 155.dp)
                .background(Color(0xffffffff), RoundedCornerShape(10.dp))
                .size(391.dp, 236.dp),
        )
        // Text-1063:1436-Contactanos
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 163.dp, y = 89.dp)
                .size(121.dp, 50.dp),
            text = "Contactanos",
            color = Color(0xffffffff),
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-1063:1437-Ver mas...
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 349.dp, y = 847.dp)
                .size(82.dp, 16.dp),
            text = "Ver mas...",
            color = Color(0xff000000),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Image-1063:1438-588a6507d06f6719692a2d15 3
        Image(
            painter = painterResource(id = R.drawable.menu),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 20.dp, y = 27.dp)
                .size(35.dp, 24.dp),
        )
        // Image-1063:1439-image 180
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 80.dp, y = 0.dp)
                .size(216.dp, 77.dp), // Cambié 89.dp a 60.dp
        )

        // Text-1063:1788-¿Nesecitas ayuda? ¡Escribenos!
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 37.dp, y = 171.dp)
                .size(321.dp, 20.dp),
            text = "¿Nesecitas ayuda?  ¡Escribenos!",
            color = Color(0xff000000),
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-1063:1793-!Tambien puedes por correo¡
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 32.dp, y = 256.dp)
                .size(321.dp, 20.dp),
            text = "!Tambien puedes por correo¡",
            color = Color(0xff000000),
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-1063:1459-¿Como cambiar mi contraseña?
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 47.dp, y = 445.dp)
                .size(249.dp, 20.dp),
            text = "¿Como cambiar mi contraseña?",
            color = Color(0xff000000),
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-1063:1826-¿Como publicar un emprendimiento?
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 47.dp, y = 516.dp)
                .size(296.dp, 20.dp),
            text = "¿Como publicar un emprendimiento?",
            color = Color(0xff000000),
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-1063:1789-Numeros: 3108596745 3108974856 31152867569
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 37.dp, y = 196.dp)
                .size(311.dp, 60.dp),
            text = "Numeros:\n3108596745              3108974856            31152867569",
            color = Color(0xad000000),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-1063:1794-Correo Electronico: emprendelinkAyuda@gmail.com
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 37.dp, y = 281.dp)
                .size(311.dp, 60.dp),
            text = "Correo Electronico:\nemprendelinkAyuda@gmail.com",
            color = Color(0xad000000),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Image-1063:1790-png-transparent-telephone-computer-icons-phone-icon-template-miscellaneous-service-computer 1
        Image(
            painter = painterResource(id = R.drawable.telefono),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 114.dp, y = 211.dp)
                .size(17.dp, 16.dp),
        )
        // Image-1063:1791-download 1
        Image(
            painter = painterResource(id = R.drawable.whatsapp),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 223.dp, y = 210.dp)
                .size(19.dp, 18.dp),
        )
        // Image-1063:1792-download 2
        Image(
            painter = painterResource(id = R.drawable.whatsapp),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 328.dp, y = 210.dp)
                .size(19.dp, 18.dp),
        )
        // Image-1063:1823-images 1
        Image(
            painter = painterResource(id = R.drawable.gmail),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 228.dp, y = 295.dp)
                .size(32.dp, 40.dp), // Ajusté el tamaño aquí
        )

        // Image-1063:1825-vector-arrow-down-line-black-icon 1
        Image(
            painter = painterResource(id = R.drawable.flecha),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 359.dp, y = 445.dp)
                .size(25.dp, 26.dp),
        )
        // Image-1063:1828-vector-arrow-down-line-black-icon 2
        Image(
            painter = painterResource(id = R.drawable.flecha),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 359.dp, y = 513.dp)
                .size(25.dp, 26.dp),
        )
        // Empty-1063:1833-Rectangle 747
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 20.dp, y = 641.dp)
                .background(Color(0xffffffff), RoundedCornerShape(10.dp))
                .size(387.dp, 62.dp),
        )
        // Text-1063:1834-¿Como ver los comentario?
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 47.dp, y = 662.dp)
                .size(296.dp, 20.dp),
            text = "¿Como ver los comentario?",
            color = Color(0xff000000),
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Image-1063:1835-vector-arrow-down-line-black-icon 5
        Image(
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 359.dp, y = 659.dp)
                .size(25.dp, 26.dp),
        )
        // Empty-1063:1836-Rectangle 748
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 20.dp, y = 716.dp)
                .background(Color(0xffffffff), RoundedCornerShape(10.dp))
                .size(387.dp, 62.dp),
        )
        // Text-1063:1837-Preguntas frecuentas.
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 47.dp, y = 737.dp)
                .size(296.dp, 20.dp),
            text = "Preguntas frecuentas.",
            color = Color(0xff000000),
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Image-1063:1838-vector-arrow-down-line-black-icon 6
        Image(
            painter = painterResource(id = R.drawable.flecha),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 359.dp, y = 734.dp)
                .size(25.dp, 26.dp),
        )
        // Empty-1063:1830-Rectangle 746
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 20.dp, y = 566.dp)
                .background(Color(0xffffffff), RoundedCornerShape(10.dp))
                .size(387.dp, 62.dp),
        )
        // Text-1063:1831-¿Como mirar mi emprendimiento?
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 47.dp, y = 587.dp)
                .size(296.dp, 20.dp),
            text = "¿Como mirar mi emprendimiento?",
            color = Color(0xff000000),
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Image-1063:1832-vector-arrow-down-line-black-icon 4
        Image(
            painter = painterResource(id = R.drawable.flecha),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 359.dp, y = 584.dp)
                .size(25.dp, 26.dp),
        )
        // Image-1063:1829-vector-arrow-down-line-black-icon 3
        Image(
            painter = painterResource(id = R.drawable.flecha),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 359.dp, y = 445.dp)
                .size(25.dp, 26.dp),
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ChatScreen1Preview() {
    MaterialTheme {
        Contactanos(

        )
    }
}