package com.example.splashscreen.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.navigation.NavController
import com.example.splashscreen.viewmodel.PruebaPerfilViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Pruebavista(viewModel: PruebaPerfilViewModel  = viewModel(),navController: NavController) {

    val count = viewModel.count.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Counter Example") }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Count: $count",
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { viewModel.increment() }) {
                    Text("Increment")
                }
            }
        }
    }
}