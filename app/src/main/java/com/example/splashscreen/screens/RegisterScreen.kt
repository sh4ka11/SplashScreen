package com.example.splashscreen.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.navigation.NavigationItem

@Composable
fun RegistrationScreen(navController: NavHostController) {
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
                        .size(200.dp)
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

                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    label = { Text("Nombre") },
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    label = { Text("Apellido") },
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    label = { Text("Documento") },
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    label = { Text("Telefono") },
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {  },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black) ,
                            modifier = Modifier.align(Alignment.CenterHorizontally)

                ) {
                    Text(text = "Siguiente", color = Color.White)
                }
                TextButton(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    onClick = {  navController.navigate(
                                NavigationItem.Login.route) }
                ){
                    Text(text = "Ya tienes una cuenta?. Inicia Sesión!",color = Color.Gray)
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
@Preview(showBackground = true)
@Composable
fun RegistrationScreenPreview() {
    val navController = rememberNavController() // Crea un NavController para el preview
    RegistrationScreen(navController = navController) // Pasa el NavController a RegistrationScreen
}

