package com.example.splashscreen.screens
//
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.CircularProgressIndicator
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.graphics.Color
//import androidx.navigation.NavController
//import java.lang.reflect.Modifier
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun LoginUser(
//    navController: NavController,
//    viewModel: LoginViewModel = viewModel()
//) {
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }

    // Observa el estado del login
//    val loginState = viewModel.loginState.value

    // ... (resto de tu código UI actual)

    // Modifica el Button onClick
//    Button(
//        onClick = {
//            viewModel.login(email, password)
//        },
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(40.dp),
//        colors = ButtonDefaults.buttonColors(
//            containerColor = Color(0xFF38352E)
//        ),
//        shape = RoundedCornerShape(10.dp)
//    ) {
//        when (loginState) {
//            is LoginViewModel.LoginState.Loading -> CircularProgressIndicator(color = Color.White)
//            else -> Text("Iniciar sesion")
//        }
//    }

    // Maneja los estados del login
//    LaunchedEffect(loginState) {
//        when (loginState) {
//            is LoginViewModel.LoginState.Success -> {
//                navController.navigate("HomeUsuario")
//            }
//            is LoginViewModel.LoginState.Error -> {
//                // Muestra un mensaje de error
//            }
//            else -> {}
//        }
//    }
