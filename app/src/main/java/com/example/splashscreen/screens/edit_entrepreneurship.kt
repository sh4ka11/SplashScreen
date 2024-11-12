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

// Modelo de datos para el producto con imagen seleccionable
data class WineProduct(
    val id: Int,
    var title: String,
    var description: String,
    var imageRes: Int, // Ahora es variable para permitir cambios
    var price: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WineEditAppApp(navController: NavController) {

    var showContactInfo by remember { mutableStateOf(true) }
    var showEditDialog by remember { mutableStateOf(false) }
    var selectedProduct by remember { mutableStateOf<WineProduct?>(null) }

    // Lista de imágenes disponibles para seleccionar
    val availableImages = listOf(
        R.drawable.vino1,
        R.drawable.vino2,
        R.drawable.vino3,
        R.drawable.vino4
    )

    // Lista mutable de productos
    var products by remember {
        mutableStateOf(listOf(
            WineProduct(
                1,
                "Vino tinto Malbec argentino",
                "Sumérgete en un torbellino de sensaciones con este vino tinto Malbec argentino, una oda a la intensidad y la expresión.",
                R.drawable.vino1,
                "$29.99"
            ),
            WineProduct(
                2,
                "Vino rosado Pinot Noir de Francia",
                "Deléitate con la delicadeza y el encanto de este vino rosado Pinot Noir francés...",
                R.drawable.vino2,
                "$25.99"
            )
            // Los otros productos se pueden agregar aquí
        ))
    }

    // Dialog para editar producto
    if (showEditDialog && selectedProduct != null) {
        EditProductDialog(
            product = selectedProduct!!,
            availableImages = availableImages,
            onDismiss = {
                showEditDialog = false
                selectedProduct = null
            },
            onConfirm = { editedProduct ->
                products = products.map {
                    if (it.id == editedProduct.id) editedProduct else it
                }
                showEditDialog = false
                selectedProduct = null
            }
        )
    }

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
                            imageVector = if (showContactInfo) Icons.Filled.Person else Icons.Filled.Warning,
                            contentDescription = "Toggle Contact Info",
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
            // Sección de información de contacto (no editable)
            item {
                AnimatedVisibility(
                    visible = showContactInfo,
                    enter = expandVertically() + fadeIn(),
                    exit = shrinkVertically() + fadeOut()
                ) {
                    ContactInfoCard()
                }
            }

            // Sección de productos (editable)
            items(products) { product ->
                ProductCard(
                    product = product,
                    onEditClick = {
                        selectedProduct = product
                        showEditDialog = true
                    },
                    onDeleteClick = {
                        products = products.filter { it.id != product.id }
                    }
                )
            }
        }
    }
}

@Composable
fun ProductCard(
    product: WineProduct,
    onEditClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .shadow(4.dp, RoundedCornerShape(8.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = product.imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )

                // Botones de edición y eliminación
                Row(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                ) {
                    IconButton(
                        onClick = onEditClick,
                        modifier = Modifier
                            .size(32.dp)
                            .background(Color.White.copy(alpha = 0.8f), CircleShape)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Editar",
                            tint = Color(0xFF2B0000)
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(
                        onClick = onDeleteClick,
                        modifier = Modifier
                            .size(32.dp)
                            .background(Color.White.copy(alpha = 0.8f), CircleShape)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Eliminar",
                            tint = Color(0xFF2B0000)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(text = product.title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = product.description, fontSize = 14.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = product.price, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color(0xFF2B0000))
        }
    }
}

@Composable
fun EditProductDialog(
    product: WineProduct,
    availableImages: List<Int>,
    onDismiss: () -> Unit,
    onConfirm: (WineProduct) -> Unit
) {
    var editedTitle by remember { mutableStateOf(product.title) }
    var editedDescription by remember { mutableStateOf(product.description) }
    var editedPrice by remember { mutableStateOf(product.price) }
    var editedImageRes by remember { mutableStateOf(product.imageRes) }
    var showImagePicker by remember { mutableStateOf(false) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Editar Producto") },
        text = {
            Column {
                // Imagen actual y botón para cambiar
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .clickable { showImagePicker = true }
                ) {
                    Image(
                        painter = painterResource(id = editedImageRes),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Black.copy(alpha = 0.3f))
                    )
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Cambiar imagen",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(48.dp),
                        tint = Color.White
                    )
                }

                if (showImagePicker) {
                    AlertDialog(
                        onDismissRequest = { showImagePicker = false },
                        title = { Text("Seleccionar imagen") },
                        text = {
                            LazyColumn {
                                items(availableImages) { imageRes ->
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clickable {
                                                editedImageRes = imageRes
                                                showImagePicker = false
                                            }
                                            .padding(8.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Image(
                                            painter = painterResource(id = imageRes),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(60.dp)
                                                .clip(RoundedCornerShape(4.dp)),
                                            contentScale = ContentScale.Crop
                                        )
                                        Spacer(modifier = Modifier.width(16.dp))
                                        Text("Imagen ${availableImages.indexOf(imageRes) + 1}")
                                    }
                                }
                            }
                        },
                        confirmButton = {
                            TextButton(onClick = { showImagePicker = false }) {
                                Text("Cerrar")
                            }
                        }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = editedTitle,
                    onValueChange = { editedTitle = it },
                    label = { Text("Título") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = editedDescription,
                    onValueChange = { editedDescription = it },
                    label = { Text("Descripción") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = editedPrice,
                    onValueChange = { editedPrice = it },
                    label = { Text("Precio") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            TextButton(onClick = {
                onConfirm(product.copy(
                    title = editedTitle,
                    description = editedDescription,
                    price = editedPrice,
                    imageRes = editedImageRes
                ))
            }) {
                Text("Guardar")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancelar")
            }
        }
    )
}
@Preview(showBackground = true)
@Composable
fun PreviewWineEditApp() {
    WineEditAppApp(navController = rememberNavController())
}
