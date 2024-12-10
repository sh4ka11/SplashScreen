package com.example.splashscreen.viewmodel

import LoginViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class PruebaPerfilViewModel : ViewModel()
{
    var count = mutableStateOf(0)
        private set

    // Function to increment the counter
    fun increment() {
        count.value++
    }
}

