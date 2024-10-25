import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.R
import com.example.splashscreen.navigation.NavigationItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WineShopApp(navController: NavController) {
    var showContactInfo by remember { mutableStateOf(true) } // Cambiado a true para mostrar por defecto

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("VINO EL ÉXTASIS", fontWeight = FontWeight.Bold, color = Color.White) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Black
                ),
                actions = {
                    IconButton(onClick = { showContactInfo = !showContactInfo }) {
                        Icon(
                            imageVector = if (showContactInfo) Icons.Filled.Person else Icons.Filled.Warning, // Adjust this line
                            contentDescription = "Toggle Contact Info",
                            tint = Color.White
                        )
                    }
                    IconButton(
                        //Icono editar
                        onClick ={ navController.navigate(
                           NavigationItem.EditarEmpredimiento.route)
                        },
                        modifier = Modifier
                            .size(32.dp)
                            .fillMaxWidth()
                            .padding(start = 8.dp) // Añade padding desde la izquierda
                    ) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Editar",
                            tint = Color.White
                        )
                    }
                },
                modifier = Modifier.shadow(4.dp)
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
                .padding(padding)
        ) {
            // Header Section

            // Contact Info Card con animación
            item {
                AnimatedVisibility(
                    visible = showContactInfo,
                    enter = expandVertically() + fadeIn(),
                    exit = shrinkVertically() + fadeOut()
                ) {
                    ContactInfoCard()
                }
            }

            // Wine Categories
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Descripción",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Text(
                        text = "Experimenta la magia del vino: Un viaje sensorial único...",
                        fontSize = 14.sp,
                        color = Color.DarkGray,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }

            item {
                ProductCard(
                    title = "Vino tinto Malbec argentino",
                    description = "Sumérgete en un torbellino de sensaciones con este vino tinto Malbec argentino, una oda a la intensidad y la expresión.",
                    imageRes = R.drawable.vino1,
                    price = "$29.99" // Price added here
                )
            }

            item {
                ProductCard(
                    title = "Vino rosado Pinot Noir de Francia",
                    description = "Deléitate con la delicadeza y el encanto de este vino rosado Pinot Noir francés...",
                    imageRes = R.drawable.vino2,
                    price = "$25.99" // Price added here
                )
            }

            item {
                ProductCard(
                    title = "Vino blanco Chardonnay de California",
                    description = "Disfruta de la frescura y la elegancia de este vino blanco Chardonnay californiano...",
                    imageRes = R.drawable.vino3,
                    price = "$32.99" // Price added here
                )
            }
            item {
                ProductCard(
                    title = "Vino espumoso Prosecco italiano",
                    description = "Celebra con cada burbuja de este Prosecco italiano, ideal para acompañar momentos especiales.",
                    imageRes = R.drawable.vino4,
                    price = "$38.99" // Price added here
                )
            }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .background(Color(0xFFEFEFEF)) // Light background for contrast
                        .border(2.dp, Color.Black, shape = RoundedCornerShape(8.dp)) // Border around the entire column
                        .padding(16.dp) // Additional padding inside the column
                ) {
                    Text(
                        text = "Experimenta la magia del vino: Un viaje sensorial único",
                        fontSize = 18.sp, // Increased font size for the title
                        fontWeight = FontWeight.Bold, // Bold for emphasis
                        color = Color.DarkGray, // Darker color for the title
                        modifier = Modifier.padding(bottom = 8.dp) // Spacing below the title
                    )

                    // Body text with improved formatting
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.DarkGray)) {
                                append("Más que una bebida, una pasión: ")
                            }
                            append("Embárcate en un viaje sensorial sin igual donde cada gota te invita a descubrir un universo de sabores, aromas y tradición.\n\n")

                            withStyle(style = SpanStyle(color = Color.DarkGray)) {
                                append("Un legado familiar: ")
                            }
                            append("Sumérgete en la historia que cada botella cuenta, un relato de tradición familiar, innovación y dedicación inquebrantable.\n\n")

                            withStyle(style = SpanStyle(color = Color.DarkGray)) {
                                append("Explora un mundo fascinante: ")
                            }
                            append("Descubre la complejidad de sabores y aromas que cada cepa ofrece y déjate cautivar por la magia del vino.\n\n")

                            withStyle(style = SpanStyle(color = Color.DarkGray)) {
                                append("Más que un producto, una experiencia: ")
                            }
                            append("Únete a nuestra comunidad, participa en vendimias, degusta nuestros vinos y descubre por qué somos más que un simple líquido.\n\n")

                            withStyle(style = SpanStyle(color = Color.DarkGray)) {
                                append("Forma parte de la experiencia: ")
                            }
                            append("Disfruta de eventos exclusivos, talleres de cata y momentos inolvidables en torno a una copa de vino.")
                        },
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }
    }
}


@Composable
fun ContactInfoCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .shadow(8.dp, RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Encabezado con imagen y nombre
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Imagen del emprendedor
                Image(
                    painter = painterResource(id = R.drawable.imagenrealdesebas),
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color(0xFF2B0000), CircleShape)
                )

                Spacer(modifier = Modifier.width(16.dp))

                // Nombre y título
                Column {
                    Text(
                        text = "CRISTIAN SEBASTIAN DELGADO",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2B0000)
                    )
                    Text(
                        text = "Fundador & Sommelier",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Divider(color = Color(0xFFEEEEEE), thickness = 1.dp)
            Spacer(modifier = Modifier.height(16.dp))

            // Información de contacto
            ContactInfoRow(
                icon = Icons.Filled.Email,
                text = "Cristiansdp@gmail.com",
                onClick = { /* TODO: Implementar acción de email */ }
            )
            ContactInfoRow(
                icon = Icons.Filled.Phone,
                text = "320-898-7646",
                onClick = { /* TODO: Implementar acción de teléfono */ }
            )
            ContactInfoRow(
                icon = Icons.Filled.LocationOn,
                text = "Subida Lucía, 40 - Jersey City, Gal / 86551",
                onClick = { /* TODO: Implementar acción de ubicación */ }
            )
            ContactInfoRow(
                icon = Icons.Filled.Place,
                text = "POPAYÁN",
                onClick = { /* TODO: Implementar acción de ciudad */ }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botones de redes sociales
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                SocialMediaButton(icon = Icons.Filled.Favorite)
                SocialMediaButton(icon = Icons.Filled.Send)
                SocialMediaButton(icon = Icons.Filled.Person)
                SocialMediaButton(icon = Icons.Filled.Email)
            }
        }
    }
}

@Composable
fun ContactInfoRow(icon: ImageVector, text: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = Color(0xFF2B0000)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun SocialMediaButton(icon: ImageVector) {
    IconButton(onClick = { /* TODO: Implementar acción de redes sociales */ }) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = Color(0xFF2B0000)
        )
    }
}

@Composable
fun ProductCard(title: String, description: String, imageRes: Int, price: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .shadow(4.dp, RoundedCornerShape(8.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = description, fontSize = 14.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = price, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color(0xFF2B0000)) // Price display
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWineShopApp() {
    WineShopApp(navController = rememberNavController())
}
