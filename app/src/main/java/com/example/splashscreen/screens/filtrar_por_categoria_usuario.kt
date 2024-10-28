package com.example.splashscreen.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.splashscreen.R

data class Categoria(
    val nombre: String,
    val icono: Int
)

@Composable

fun Busquedafil() {
    var searchText by remember { mutableStateOf("") }

    // Lista de categorías
    val categorias = remember {
        listOf(
            Categoria("Articulos deportivos", R.drawable.deportes),
            Categoria("Articulos para el hogar", R.drawable.hogar),
            Categoria("Electronica", R.drawable.electronica),
            Categoria("Idumentaria", R.drawable.indumentaria),
            Categoria("Instrumentos musicales", R.drawable.musica),
            Categoria("Productos para mascotas", R.drawable.mascotas),
            Categoria("Suministros de oficina", R.drawable.oficina),
            Categoria("Artesanias", R.drawable.artesanias),
            Categoria("Herramientas de trabajo", R.drawable.herramientas),
            Categoria("Educacion", R.drawable.educacion),
            Categoria("Alimentacion", R.drawable.alimentacion),
            Categoria("Vehiculos", R.drawable.vehiculos)
        )
    }

    // Filtrar categorías basado en el texto de búsqueda
    val categoriasFiltradas = remember(searchText) {
        if (searchText.isEmpty()) {
            categorias
        } else {
            categorias.filter {
                it.nombre.lowercase().contains(searchText.lowercase())
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffd9d9d9))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Header con menú y logo
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = "Menu",
                    modifier = Modifier.size(35.dp, 24.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.sinfondo),
                    contentDescription = "Logo",
                    modifier = Modifier.size(212.dp, 82.dp)
                )
                Spacer(modifier = Modifier.width(35.dp))
            }

            // Campo de búsqueda
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                TextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    placeholder = { Text("Buscar...") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White, RoundedCornerShape(30.dp)),
                    trailingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.lupa),
                            contentDescription = "Buscar",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        disabledContainerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(30.dp)
                )
            }

            Text(
                text = "Sugerencias para ti",
                modifier = Modifier.padding(vertical = 16.dp),
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal
            )

            // Lista de categorías filtradas
            LazyColumn {
                items(categoriasFiltradas) { categoria ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = categoria.icono),
                            contentDescription = categoria.nombre,
                            modifier = Modifier.size(33.dp, 30.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = categoria.nombre,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }


            if (categoriasFiltradas.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.telescopio),
                            contentDescription = "No se encontraron resultados",
                            modifier = Modifier.size(187.dp)
                        )
                        Text(
                            text = "No se encontraron resultados",
                            fontSize = 15.sp,
                            textAlign = TextAlign.Center
                        )


                    }

                }

            }

        }

    }

}

@Preview(showBackground = true)
@Composable
fun Busquedafiltro() {
    MaterialTheme {
        Busquedafil(

        )
    }
}






