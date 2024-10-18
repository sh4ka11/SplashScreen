import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.* // Para columnas y filas
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.splashscreen.ui.theme.SplashScreenTheme
import com.example.splashscreen.R
import com.example.splashscreen.ui.theme.SplashScreenTheme

class Main : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreenTheme{
                // Llamamos a la función que contiene las preguntas
                PreguntasConRespuestas()
            }
        }
    }
}

@Composable
fun PreguntasConRespuestas() {
    Column(modifier = Modifier.padding(16.dp)) {
        // Primera pregunta
        PreguntaConRespuesta(
            pregunta = "¿Cuál es la capital de Francia?",
            respuesta = "La capital de Francia es París."
        )

        // Segunda pregunta
        PreguntaConRespuesta(
            pregunta = "¿Cuál es el océano más grande del mundo?",
            respuesta = "El océano más grande del mundo es el Pacífico."
        )
    }
}

@Composable
fun PreguntaConRespuesta(pregunta: String, respuesta: String) {
    // Recordamos si la respuesta está visible o no
    var respuestaVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Flecha que al ser clickeada alterna la visibilidad de la respuesta
            Image(
                painter = painterResource(id = R.drawable.flecha), // Reemplaza con tu recurso de imagen
                contentDescription = "Flecha",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { respuestaVisible = !respuestaVisible }, // Alternamos la visibilidad
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.width(8.dp))

            // Texto de la pregunta
            Text(text = pregunta)
        }

        // Condicional para mostrar u ocultar la respuesta
        if (respuestaVisible) {
            Text(
                text = respuesta,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
            )
        }
    }
}
