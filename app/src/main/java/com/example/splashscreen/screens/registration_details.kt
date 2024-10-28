import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

// Definición de colores neutros
val NeutralBackground = Color(0xFFF5F5F5)
val NeutralPrimary = Color(0xFF4A4A4A)
val NeutralSecondary = Color(0xFF6B6B6B)
val NeutralSurface = Color(0xFFFFFFFF)

@Composable
fun ProfileForm(navController: NavHostController) {
    var nombre by remember { mutableStateOf("") }
    var fechaNacimiento by remember { mutableStateOf("") }
    var ubicacion by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var genero by remember { mutableStateOf("") }
    var etapa by remember { mutableStateOf("") }
    var documento by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(NeutralBackground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo y título
            Text(
                text = "Emprende Link",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = NeutralPrimary,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "Conectar para crecer",
                fontSize = 14.sp,
                color = NeutralSecondary,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            // Título de información adicional
            Text(
                text = "Información adicional",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = NeutralPrimary,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "Completaremos tu perfil de Emprende Link por usted. Puede agregar tus datos ahora o puedes darle siguiente y después los puedes ingresar.",
                fontSize = 14.sp,
                color = NeutralSecondary,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            // Campos de formulario con colores neutros
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre", color = NeutralSecondary) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = NeutralSecondary,
                    focusedBorderColor = NeutralPrimary,
                    unfocusedContainerColor = NeutralSurface,
                    focusedContainerColor = NeutralSurface
                )
            )

            OutlinedTextField(
                value = fechaNacimiento,
                onValueChange = { fechaNacimiento = it },
                label = { Text("Fecha de nacimiento", color = NeutralSecondary) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = NeutralSecondary,
                    focusedBorderColor = NeutralPrimary,
                    unfocusedContainerColor = NeutralSurface,
                    focusedContainerColor = NeutralSurface
                )
            )

            OutlinedTextField(
                value = ubicacion,
                onValueChange = { ubicacion = it },
                label = { Text("Ubicación", color = NeutralSecondary) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = NeutralSecondary,
                    focusedBorderColor = NeutralPrimary,
                    unfocusedContainerColor = NeutralSurface,
                    focusedContainerColor = NeutralSurface
                )
            )

            OutlinedTextField(
                value = telefono,
                onValueChange = { telefono = it },
                label = { Text("Teléfono", color = NeutralSecondary) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = NeutralSecondary,
                    focusedBorderColor = NeutralPrimary,
                    unfocusedContainerColor = NeutralSurface,
                    focusedContainerColor = NeutralSurface
                )
            )

            OutlinedTextField(
                value = genero,
                onValueChange = { genero = it },
                label = { Text("Género", color = NeutralSecondary) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = NeutralSecondary,
                    focusedBorderColor = NeutralPrimary,
                    unfocusedContainerColor = NeutralSurface,
                    focusedContainerColor = NeutralSurface
                )
            )

            OutlinedTextField(
                value = etapa,
                onValueChange = { etapa = it },
                label = { Text("Etapa", color = NeutralSecondary) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = NeutralSecondary,
                    focusedBorderColor = NeutralPrimary,
                    unfocusedContainerColor = NeutralSurface,
                    focusedContainerColor = NeutralSurface
                )
            )

            OutlinedTextField(
                value = documento,
                onValueChange = { documento = it },
                label = { Text("Documento", color = NeutralSecondary) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = NeutralSecondary,
                    focusedBorderColor = NeutralPrimary,
                    unfocusedContainerColor = NeutralSurface,
                    focusedContainerColor = NeutralSurface
                )
            )

            // Botón centrado
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = { /* TODO: Implementar acción */ },
                    modifier = Modifier
                        .width(200.dp)
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = NeutralPrimary
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        "Siguiente",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRegisterApp() {
    ProfileForm(navController = rememberNavController())
}