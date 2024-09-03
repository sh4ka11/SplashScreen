package com.example.splashscreen.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.navigation.NavigationItem

@Composable
fun LoginScreen(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Bienvenido!", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = "",
            onValueChange = { },
            label = { Text("Usuario")},
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = "",
            onValueChange = { },
            label = { Text("Contraseña")},
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /*TODO*/ }) {
            Text("Iniciar Sesion")
        }
        Button(
            onClick = {
                navController.navigate( // Navigate to a route in the current NavGraph
                    NavigationItem.Home.route // Route defined in AppNavHost
                ) }
        ) {
            Text("Registrarse")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(rememberNavController())
}