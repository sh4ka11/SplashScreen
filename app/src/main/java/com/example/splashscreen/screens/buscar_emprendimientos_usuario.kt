package com.example.splashsreen.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.splashscreen.R

data class Emprendimiento(
    val nombre: String,
    val descripcion: String,
    val imagen: Int
)

@Composable
fun Busqueda1() {
    var searchText by remember { mutableStateOf("") }

    val emprendimientos = listOf(
        Emprendimiento("Vinos el éxtasis", "Empresa procesadora de vino con productos artesanales de calidad", R.drawable.vino),

        Emprendimiento("Vinos el éxtasis", "Empresa procesadora de vino con productos artesanales de calidad", R.drawable.vino),

        Emprendimiento("Vinos el éxtasis", "Empresa procesadora de vino con productos artesanales de calidad", R.drawable.vino),

        Emprendimiento("Vinos el éxtasis", "Empresa procesadora de vino con productos artesanales de calidad", R.drawable.vino),

        Emprendimiento("Vinos el éxtasis", "Empresa procesadora de vino con productos artesanales de calidad", R.drawable.vino),

        Emprendimiento("Vinos el éxtasis", "Empresa procesadora de vino con productos artesanales de calidad ora de vino con productos artesanales de calidad ora de vino con productos artesanales de calidad ora de vino con productos artesanales de calidad ora de vino con productos artesanales de calidad ora de vino con productos artesanales de calidad ", R.drawable.vino),
        Emprendimiento("Arepas", "Empresa de arepas frescas y caseras que trae el sabor auténtico de Colombia", R.drawable.arepas),
        Emprendimiento("Escritorios", "Fabricante de escritorios ergonómicos para espacios de trabajo cómodos", R.drawable.escritorios),
        Emprendimiento("Artesanías", "Venta de artesanías locales hechas a mano con materiales sostenibles", R.drawable.artesanias),
    )

    val filteredEmprendimientos = emprendimientos.filter {
        it.nombre.contains(searchText, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD9D9D9))
            .padding(16.dp)
    ) {
        // Logo
        Image(
            painter = painterResource(id = R.drawable.sinfondo),
            contentDescription = "Logo",
            modifier = Modifier
                .padding(start = 8.dp)
                .height(70.dp)
        )

        // Cuadro de búsqueda
        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            placeholder = { Text("Buscar...") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .background(Color.White) // Fondo blanco del cuadro de búsqueda
        )

        // Lista de cards agrupadas en filas
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(filteredEmprendimientos.chunked(2)) { rowItems ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    rowItems.forEach { emprendimiento ->
                        EmprendimientoCard(emprendimiento)
                    }
                }
            }
        }
    }
}

@Composable
fun EmprendimientoCard(emprendimiento: Emprendimiento) {
    var isExpanded by remember { mutableStateOf(false) } // Estado para controlar la expansión de la descripción

    Card(
        modifier = Modifier
            .width(180.dp) // Ancho ajustado para que todas las cards sean iguales
            .height(250.dp) // Altura ajustada para que todas las cards sean iguales
            .padding(8.dp)
            .border(1.dp, Color.Black),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White // Fondo blanco para las cards
        )
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = emprendimiento.imagen),
                contentDescription = emprendimiento.nombre,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Text(
                text = emprendimiento.nombre,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 4.dp)
            )

            // Descripción con "Ver más" / "Ver menos"
            Column(modifier = Modifier.fillMaxWidth()) {
                val description = if (isExpanded) emprendimiento.descripcion else emprendimiento.descripcion.take(40) + if (emprendimiento.descripcion.length > 40) "..." else ""
                Text(
                    text = description,
                    fontSize = 12.sp,
                    maxLines = if (isExpanded) Int.MAX_VALUE else 2,
                    overflow = TextOverflow.Ellipsis
                )
                if (emprendimiento.descripcion.length > 40) {
                    Text(
                        text = if (isExpanded) "Ver menos" else "Ver más",
                        color = Color.Black,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .clickable { isExpanded = !isExpanded } // Cambiar estado al hacer clic
                            .padding(top = 4.dp) // Espacio entre la descripción y el texto de ver más/menos
                    )
                }
            }

            // Botón "Visitar" en la parte inferior izquierda
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Button(
                    onClick = { /* Acción del botón */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .padding(4.dp)
                        .width(90.dp) // Ajustado para que el texto sea visible
                        .height(30.dp)
                ) {
                    Text("Visitar", fontSize = 12.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Busqueda1Preview() {
    Busqueda1()
}
