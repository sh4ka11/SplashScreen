import com.example.splashscreen.R

// BusinessItem.kt

// BusinessListView.kt
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.BorderStroke
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


data class BusinessItem(
    val name: String,
    val description: String,
    val backgroundImageRes: Int,
    val logoImageRes: Int
)

@Composable
fun BusinessListView(navController: NavController,
    modifier: Modifier = Modifier,
    onVisitClick: (BusinessItem) -> Unit = {}
) {
    val businesses = listOf(
        BusinessItem(
            name = "VINO EL ÉXTASIS",
            description = "AQUEL QUE VINO AL MUNDO Y NO TOMÓ VINO, ¿ENTONCES A QUÉ VINO?",
            backgroundImageRes = R.drawable.fondovino,
            logoImageRes = R.drawable.logovino
        ),
        BusinessItem(
            name = "AREPA PURO MAIZ",
            description = "Somos un emprendimiento enfocado en el procesamiento y comercialización de arepas de todo tipo.",
            backgroundImageRes = R.drawable.fondovino,
            logoImageRes = R.drawable.arepas
        ),
        BusinessItem(
            name = "CARNES LA BUENA VACA",
            description = "Somos un emprendimiento enfocado en el procesamiento de carnes rojas.",
            backgroundImageRes = R.drawable.fondovino,
            logoImageRes = R.drawable.arepas
        ),
        BusinessItem(
            name = "RESTAURANTE DON MIGUEL",
            description = "Restaurante familiar enfocado en darle la mayor atención al cliente para que se sienta satisfecho con nuestros productos.",
            backgroundImageRes = R.drawable.fondovino,
            logoImageRes = R.drawable.arepas
        )
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(Color.White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    modifier = Modifier.size(24.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .height(200.dp)
                        .padding(vertical = 8.dp),
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.width(24.dp))
            }
        }

        // Title
        Text(
            text = "EMPRENDIMIENTOS",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF5F5F5))
                .padding(vertical = 12.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                color = Color(0xFF333333)
            )
        )

        // Business List
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(businesses) { business ->
                BusinessCard(
                    business = business,
                    onVisitClick = { onVisitClick(business) }
                )
            }
        }
    }
}

@Composable
private fun BusinessCard(
    business: BusinessItem,
    onVisitClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box {
            Column {
                // Background Image
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                ) {
                    Image(
                        painter = painterResource(id = business.backgroundImageRes),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Transparent,
                                        Color.Black.copy(alpha = 0.3f)
                                    )
                                )
                            )
                    )
                }

                Spacer(modifier = Modifier.height(40.dp))

                // Business Name
                Text(
                    text = business.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    textAlign = TextAlign.Center
                )

                // Description
                Text(
                    text = business.description,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    color = Color.Gray
                )

                // Visit Button
                Button(
                    onClick = onVisitClick,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(vertical = 16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black
                    ),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(
                        text = "Visitar",
                        modifier = Modifier.padding(horizontal = 24.dp),
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }

            // Logo
            Surface(
                modifier = Modifier
                    .size(70.dp)
                    .align(Alignment.TopCenter)
                    .offset(y = 145.dp),
                shape = CircleShape,
                border = BorderStroke(2.dp, Color.White),
                color = Color.White
            ) {
                Image(
                    painter = painterResource(id = business.logoImageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxSize(),
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWiewApp() {
    BusinessListView(navController = rememberNavController())
}
