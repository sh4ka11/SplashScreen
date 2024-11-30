//package com.example.splashscreen.screens
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import Entrepreneurs
//
//@Composable
//fun EmprendedorScreen(
//    emprendedorViewModel: EmprendedorViewModel = viewModel()
//) {
//    val state = emprendedorViewModel.state
//
//    if (state.isLoading) {
//        Box(
//            modifier = Modifier.fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ) {
//            CircularProgressIndicator()
//        }
//    } else {
//        LazyColumn(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp)
//        ) {
//            items(state.emprededor) { emprendedor ->
//                EmprendedorItem(emprendedor)
//            }
//        }
//    }
//}
//
//@Composable
//fun EmprendedorItem(emprendedor: Entrepreneurs) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 8.dp),
//        elevation = CardDefaults.cardElevation(4.dp)
//    ) {
//        Column(modifier = Modifier.padding(16.dp)) {
//            Text(
//                text = "${emprendedor.name} ${emprendedor.lastname}",
//                style = MaterialTheme.typography.titleMedium
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(
//                text = "Email: ${emprendedor.email}",
//                style = MaterialTheme.typography.bodyMedium
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(
//                text = "Location: ${emprendedor.location}",
//                style = MaterialTheme.typography.bodyMedium
//            )
//        }
//    }
//}
