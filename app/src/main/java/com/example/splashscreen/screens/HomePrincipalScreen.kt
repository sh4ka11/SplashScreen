package ai.codia.x.composeui.demo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.R
import com.example.splashscreen.screens.EmprendeMainView

@Composable
fun HomePincipalScreen(navController: NavController) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        HomePrincipalaScreen()
    }
}

@Composable
fun HomePrincipalaScreen() {
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .background(Color(0xff000000))
            .size(430.dp, 2536.dp)
            .clipToBounds(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.image4_751131),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 5.dp, y = 0.dp)
                .size(438.dp, 633.dp),
        )

        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .size(430.dp, 960.dp),
        )

        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .size(430.dp, 960.dp),
        )

        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 5.dp, y = 176.dp)
                .background(Color(0xfff5f5f3))
                .size(430.dp, 436.dp),
        )

        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 16.dp, y = 241.dp)
                .size(417.dp, 82.dp),
            text = "¡El enlace de emprendedores\n con \n inversionistas!",
            color = Color(0xff000000),
            fontSize = 25.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
        )

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

        // Botón "Iniciar Sesión"
        Button(
            onClick = { /* Add navigation logic here */ },
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 45.dp, y = 565.dp)
                .size(154.dp, 33.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFFFF)),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "Iniciar \n Sesion",
                color = Color(0xFF000000),
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal
            )
        }

        // Botón "Crear Cuenta"
        Button(
            onClick = { /* Add navigation logic here */ },
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 238.dp, y = 565.dp)
                .size(154.dp, 33.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF38352E)),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "Crear Cuenta",
                color = Color(0xFFFFFFFF),
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal
            )
        }

        Button(
            onClick = { /* Add navigation or action here */ },
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 122.dp, y = 515.dp)
                .size(223.dp, 33.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(
                text = "¿Listo para comenzar?",
                color = Color(0xB2000000),
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
            )
        }

        Button(
            onClick = { /* Add navigation or action here */ },
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 104.dp, y = 670.dp)
                .size(263.dp, 105.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(
                text = "Crea tu propio emprendimiento",
                color = Color(0xFFFFFFFF),
                fontSize = 30.sp,
                fontWeight = FontWeight.Normal,
            )
        }

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 70.dp, y = 21.dp)
                .size(320.dp, 110.dp),
        )

        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 0.dp, y = 798.dp)
                .background(Color(0xffd9d9d9), RoundedCornerShape(20.dp))
                .size(430.dp, 211.dp),
        )

        Image(
            painter = painterResource(id = R.drawable.image4_751131),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 0.dp, y = 798.dp)
                .size(430.dp, 211.dp),
        )

        Image(
            painter = painterResource(id = R.drawable.image4_751131),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 1.dp, y = 2323.dp)
                .size(430.dp, 730.dp),
        )

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

        Image(
            painter = painterResource(id = R.drawable.platasubida),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 0.dp, y = 1014.dp)
                .size(430.dp, 211.dp),
        )

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

        Image(
            painter = painterResource(id = R.drawable.manos),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 0.dp, y = 1230.dp)
                .size(434.dp, 211.dp),
        )

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

        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 25.dp, y = 1465.dp)
                .size(392.dp, 205.dp),
            text = "Emprende Link busca facilitar la colaboración y el crecimiento empresarial al conectar de manera  eficiente a emprendedores con grandes empresas, creando oportunidades para el desarrollo  conjunto de soluciones innovadoras.",
            color = Color(0xffffffff),
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
        )

        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 0.dp, y = 1908.dp)
                .background(Color(0xffffffff))
                .size(430.dp, 415.dp),
        )

        // Botón "Iniciar Sesión Como Inversor"
        Button(
            onClick = { /* Add navigation logic here */ },
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 54.dp, y = 2212.dp)
                .size(154.dp, 52.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD9D9D9)),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "Iniciar Sesion\nComo Inversor",
                color = Color(0xFF000000),
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )
        }

        // Botón "Crear Cuenta Como Inversor"
        Button(
            onClick = { /* Add navigation logic here */ },
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 227.dp, y = 2212.dp)
                .size(170.dp, 52.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF38352E)),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "Crear Cuenta\nComo Inversor",
                color = Color(0xFFFFFFFF),
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )
        }

        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 54.dp, y = 1963.dp)
                .size(323.dp, 88.dp),
            text = "Crear Cuenta\nComo Inversor",
            color = Color(0xff000000),
            fontSize = 30.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
        )

        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 40.dp, y = 2037.dp)
                .size(340.dp, 168.dp),
            text = "Asociese con mas emprendedores para poder hacer progresar a tu negocio, o encuentra proveedores de diferentes productos",
            color = Color(0xb2000000),
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
        )

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 40.dp, y = 2335.dp)
                .size(350.dp, 125.dp),
        )

        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 66.dp, y = 2471.dp)
                .size(311.dp, 45.dp),
            text = "2024 Emprende Link l Acerca de l politica de privacidad",
            color = Color(0xff000000),
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
        )

        Image(
            painter = painterResource(id = R.drawable.image8_751146),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 0.dp, y = 1656.dp)
                .size(430.dp, 256.dp),
        )

        Image(
            painter = painterResource(id = R.drawable.image9_751147),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 12.dp, y = 43.dp)
                .size(55.dp, 55.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomePincipalScreen(navController = navController)
}