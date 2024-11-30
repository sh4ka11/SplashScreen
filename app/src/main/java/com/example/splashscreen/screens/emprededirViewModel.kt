package com.example.splashscreen.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.splashscreen.data.emprededorState
import com.example.splashscreen.navigation.ApiService
import kotlinx.coroutines.launch
import Entrepreneurs

class EmprendedorViewModel : ViewModel() {

     var state  by mutableStateOf(emprededorState())

    private set
    var response:List<Entrepreneurs> by mutableStateOf(listOf())
        private set

    init {

        viewModelScope.launch {
            state = state.copy(
                isLoading = true
            )
            val apiService = ApiService.getInstance()
            val  emprendedorList = apiService.getEmprededor()
            response= emprendedorList

            state = state.copy(
                isLoading = false,
                emprededor = response
            )
        }
    }
}



