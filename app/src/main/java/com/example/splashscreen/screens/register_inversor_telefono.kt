package com.example.splashscreen.screens

import android.content.res.Configuration
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterPhoneView(
    navController: NavController,
    onBackClick: () -> Unit = { navController.navigate("register_inversor") }
) {
    var phoneNumber by remember { mutableStateOf("") }
    val configuration = LocalConfiguration.current
    val isPortrait = configuration.orientation == Configuration.ORIENTATION_PORTRAIT

    // Animation for bounce effect
    var offsetY by remember { mutableStateOf(0f) }
    val animatedOffset by animateFloatAsState(
        targetValue = offsetY,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF1C1B1F)
                )
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            if (isPortrait) {
                Image(
                    painter = painterResource(id = R.drawable.hom),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .offset(y = (-73).dp)
                        .size(800.dp, 600.dp)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = if (isPortrait) 180.dp else 0.dp)
            ) {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .offset(y = animatedOffset.dp)
                        .pointerInput(Unit) {
                            detectDragGestures(
                                onDragEnd = { offsetY = 0f },
                                onDrag = { change, dragAmount ->
                                    change.consume()
                                    val newOffset = (offsetY + dragAmount.y).coerceIn(0f, 50f)
                                    if (dragAmount.y > 0 || offsetY > 0) {
                                        offsetY = newOffset
                                    }
                                }
                            )
                        },
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 35.dp),
                    color = Color(0xFFF5F5F3)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .padding(24.dp)
                    ) {
                        Text(
                            text = "Resgístrarse en Emprede link",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontSize = 25.sp
                            )
                        )

                        Spacer(modifier = Modifier.height(24.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Correo",
                                modifier = Modifier
                                    .clickable { onBackClick() }
                                    .padding(horizontal = 8.dp, vertical = 8.dp),
                                style = MaterialTheme.typography.titleMedium,
                                color = Color.Gray
                            )
                            Spacer(modifier = Modifier.width(100.dp))
                            Text(
                                text = "Teléfono",
                                modifier = Modifier
                                    .padding(horizontal = 8.dp, vertical = 8.dp),
                                style = MaterialTheme.typography.titleMedium,
                                color = Color.Black
                            )
                        }

                        Divider(
                            modifier = Modifier.padding(vertical = 8.dp),
                            color = Color.Black
                        )

                        OutlinedTextField(
                            value = phoneNumber,
                            onValueChange = { phoneNumber = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            shape = RoundedCornerShape(12.dp),
                            leadingIcon = {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(start = 8.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.col_flag),
                                        contentDescription = "col flag",
                                        modifier = Modifier.size(24.dp)
                                    )
                                    Text(
                                        text = "+57",
                                        modifier = Modifier.padding(horizontal = 4.dp)
                                    )
                                }
                            },
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color.Black,
                                unfocusedBorderColor = Color.Black
                            )
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Button(
                                onClick = { },
                                modifier = Modifier
                                    .fillMaxWidth(0.8f)
                                    .height(48.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF38352E)
                                ),
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                Text("Siguiente")
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "¿Necesitas Ayuda?",
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { },
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Center,
                            color = Color(0xFF38352E)
                        )
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun RegisterInversorPhonePreview() {
    MaterialTheme {
        RegisterPhoneView(navController = rememberNavController())
    }
}