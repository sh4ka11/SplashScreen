package com.example.splashscreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

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
