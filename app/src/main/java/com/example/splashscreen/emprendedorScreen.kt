package com.example.splashscreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun EmprendedorScreen(
    emprendedorViewModel: EmprendedorViewModel = viewModel()
) {
    val state = emprendedorViewModel.state

    // Check if loading
    if (state.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        // Display list of Emprendedores
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(state.emprededor) { Entrepreneurs ->
                EmprendedorItem(Entrepreneurs)
            }
        }
    }
}

@Composable
fun EmprendedorItem(emprendedor: Entrepreneurs) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "name: ${emprendedor.name}", style = MaterialTheme.typography.bodyLarge)
        }
    }
}
