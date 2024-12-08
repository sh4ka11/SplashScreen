package ai.codia.x.composeui.demo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
fun HomePincipalScreen(navController: NavController) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        HomePrincipalaScreen(navController)
    }
}

@Composable
fun HomePrincipalaScreen(navController: NavController) {
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
                .size(400.dp, 500.dp),
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
                .size(500.dp, 436.dp),
        )

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

        Button(
            onClick = { navController.navigate("loginUsuario")},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xfff5f5f3)
            ),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 112.dp, y = 480.dp)
                .size(223.dp, 34.dp),
        ) {
            Text(
                text = "¿Listo  para comenzar?",
                color = Color.Black,
                fontSize = 15.sp
            )
        }

        Button(
            onClick = {navController.navigate("LoginPrueba") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 45.dp, y = 535.dp)
                .size(158.dp, 55.dp)

        ) {
            Text(
                text = "Iniciar \n Sesión",
                color = Color.Black,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
            )
        }
            //Como colocar un link
        //ah

        Button(
            onClick = { navController.navigate("UserRegistrationCorreo") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff38352e)
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 235.dp, y = 535.dp)
                .size(158.dp, 55.dp)

        ) {
            Text(
                text = "Crear Cuenta",
                color = Color.White,
                fontSize = 18.sp
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = -5.dp, y = 627.dp)
                .background(Color(0xff000000))
                .size(435.dp, 171.dp),
        )

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

        Image(
            painter = painterResource(id = R.drawable.image7_751144),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 67.dp, y = 21.dp)
                .size(300.dp, 145.dp),
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
            painter = painterResource(id = R.drawable.manos),
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
            color = Color.White,
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
                .offset(x = 0.dp, y = 1230.dp)
                .size(434.dp, 211.dp),
        )

        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 97.dp, y = 1320.dp)
                .size(263.dp, 105.dp),
            text = "Crear contactos",
            color = Color.Black,
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

        Button(
            onClick = { navController.navigate("login_inversor") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xffd9d9d9)
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 50.dp, y = 2212.dp)
                .size(154.dp, 55.dp)
        ) {
            Text(
                text = "Iniciar Sesión\nComo Inversor",
                color = Color.Black,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
        }

        Button(
            onClick = { navController.navigate("register_inversor") }, // Navega a RegisterInversor
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff38352e)
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 225.dp, y = 2212.dp)
                .size(170.dp, 55.dp)
        ) {
            Text(
                text = "Crear Cuenta\nComo Inversor",
                color = Color.White,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
        }

        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 50.dp, y = 1963.dp)
                .size(323.dp, 88.dp),
            text = "Crear Cuenta \nComo Inversor",
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
            text = "Asociese con mas emprededores para poder hacer progresar a tu negocio,o encuentra provedores de difenrentes productos",
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
                .size(340.dp, 132.dp),
        )

        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 66.dp, y = 2471.dp)
                .size(311.dp, 45.dp),
            text = "2024 Emprende Link l Acerca de l politaca de privaciadad",
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
                .offset(x = 5.dp, y = 1656.dp)
                .size(450.dp, 256.dp),
        )


    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomePincipalScreen(navController = navController)
}