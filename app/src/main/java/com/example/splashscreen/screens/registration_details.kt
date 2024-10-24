import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.splashscreen.R

@Composable
fun ProfileForm(navController:NavHostController) {
    var nombre by remember { mutableStateOf("") }
    var fechaNacimiento by remember { mutableStateOf("") }
    var ubicacion by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var genero by remember { mutableStateOf("") }
    var etapa by remember { mutableStateOf("") }
    var documento by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo y título
        Text(
            text = "Emprende Link",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Conectar para crecer",
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Título de información adicional
        Text(
            text = "Informacion adicional",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Completaremos tu perfil de Emprede link por usted. Puede agregar tus datos ahora o puedes darle siguiente y despues los puedes ingresar.",
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Campos de formulario
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            shape = RoundedCornerShape(8.dp)
        )

        OutlinedTextField(
            value = fechaNacimiento,
            onValueChange = { fechaNacimiento = it },
            label = { Text("Fecha de nacimiento") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            shape = RoundedCornerShape(8.dp)
        )

        OutlinedTextField(
            value = ubicacion,
            onValueChange = { ubicacion = it },
            label = { Text("Ubicacion") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            shape = RoundedCornerShape(8.dp)
        )

        OutlinedTextField(
            value = telefono,
            onValueChange = { telefono = it },
            label = { Text("Telefono") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            shape = RoundedCornerShape(8.dp)
        )

        OutlinedTextField(
            value = genero,
            onValueChange = { genero = it },
            label = { Text("Genero") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            shape = RoundedCornerShape(8.dp)
        )

        OutlinedTextField(
            value = etapa,
            onValueChange = { etapa = it },
            label = { Text("Etapa") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            shape = RoundedCornerShape(8.dp)
        )

        OutlinedTextField(
            value = documento,
            onValueChange = { documento = it },
            label = { Text("Documento") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            shape = RoundedCornerShape(8.dp)
        )

        Button(
            onClick = { /* TODO: Implementar acción */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),   colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Siguiente")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewRegisterApp() {
    ProfileForm(navController = rememberNavController())
}
