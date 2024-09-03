package com.example.splashscreen.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserRegistrationScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        // Fondo (opcional si deseas agregar uno)
        // Imagen de fondo o color sólido

        // Contenido principal
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // Imagen del logo en la esquina superior izquierda
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    painter = painterResource(id = LocalContext.current.resources.getIdentifier("logo", "drawable", LocalContext.current.packageName)),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(80.dp)
                        .padding(top = 16.dp),
                    contentScale = ContentScale.Fit
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Título centrado
            Text(
                text = "Registro de usuario",
                style = MaterialTheme.typography.headlineMedium, // Reemplaza h4 por headlineMedium o el estilo que prefieras
                color = Color.Black,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )


            Spacer(modifier = Modifier.height(24.dp))

            // Formulario de registro
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .wrapContentSize(Alignment.Center)
            ) {
                val nombre = remember { mutableStateOf(TextFieldValue()) }
                val apellido = remember { mutableStateOf(TextFieldValue()) }
                val documento = remember { mutableStateOf(TextFieldValue()) }
                val telefono = remember { mutableStateOf(TextFieldValue()) }

                BasicTextField(
                    value = nombre.value,
                    onValueChange = { nombre.value = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    decorationBox = { innerTextField ->
                        TextFieldDecoration("Nombre", innerTextField)
                    }
                )

                BasicTextField(
                    value = apellido.value,
                    onValueChange = { apellido.value = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    decorationBox = { innerTextField ->
                        TextFieldDecoration("Apellido", innerTextField)
                    }
                )

                BasicTextField(
                    value = documento.value,
                    onValueChange = { documento.value = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    decorationBox = { innerTextField ->
                        TextFieldDecoration("Documento", innerTextField)
                    }
                )

                BasicTextField(
                    value = telefono.value,
                    onValueChange = { telefono.value = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    decorationBox = { innerTextField ->
                        TextFieldDecoration("Telefono", innerTextField)
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { /* Acción del botón */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
                ) {
                    Text(text = "Siguiente", color = Color.White)
                }
            }
        }
    }
}

@Composable
fun TextFieldDecoration(label: String, innerTextField: @Composable () -> Unit) {
    Column {
        Text(text = label, fontSize = 12.sp, color = Color.Gray)
        innerTextField()
    }
}

