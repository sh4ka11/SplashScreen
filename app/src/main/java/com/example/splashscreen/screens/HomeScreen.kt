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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.R

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Encabezado con logo
        HeaderSection()

        // Texto de bienvenida
        WelcomeSection()

        // Sección "Crea tu propio emprendimiento"
        CreateSection()

        // Sección "Chat de emprendedores"
        ChatSection()
    }
}

@Composable
fun HeaderSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo), // Pon tu logo aquí
            contentDescription = "Logo",
            modifier = Modifier
                .height(100.dp)
                .align(Alignment.Center)
        )
    }
}

@Composable
fun WelcomeSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "¡El enlace de emprendedores con inversionistas!",
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold
            ),
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Emprende Link busca facilitar la colaboración y el crecimiento empresarial al conectar de manera eficiente a emprendedores con grandes empresas, creando oportunidades para el desarrollo conjunto de soluciones innovadoras.",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* Acción para crear un emprendimiento */ },
            modifier = Modifier.align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                    shape = RoundedCornerShape(50)
        ) {
            Text("Crea tu emprendimiento")
        }
    }
}

@Composable
fun CreateSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Crea tu propio emprendimiento",
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold
            ),
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        // Imagen vacía de Emprende
        Image(
            painter = painterResource(id = R.drawable.hombrenegocios), // Reemplaza con la imagen que quieras
            contentDescription = "Emprende",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    }
}

@Composable
fun ChatSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Chat de emprendedores",
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold
            ),
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        // Imagen vacía de chat
        Image(
            painter = painterResource(id = R.drawable.manos), // Reemplaza con la imagen que quieras
            contentDescription = "Chat",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* Acción para crear un perfil */ },
            modifier = Modifier.align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(50)
        ) {
            Text("Crear un perfil")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}
