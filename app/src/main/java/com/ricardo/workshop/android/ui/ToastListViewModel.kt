package com.ricardo.workshop.android.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ricardo.workshop.android.data.ApiServiceFactory
import com.ricardo.workshop.android.data.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class ToastListViewModel : ViewModel() {

    // udf
    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

//    init {
//        viewModelScope.launch {
//            try {
//                val toasts = LocalDataSource().getToasts()
//                _uiState.value = UiState.Content(toasts)
//            } catch (e: Exception) {
//                _uiState.value = UiState.Error
//            }
//        }
//    }

    fun getToasts() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val apiService = ApiServiceFactory.createApiService()
                val toasts = apiService.getToasts()
                _uiState.value = UiState.Content(toasts)
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.localizedMessage ?: "Error")
            }
        }
    }

    sealed class UiState {
        data object Loading : UiState()
        data class Error(val errorMessage: String) : UiState()
        data class Content(val toasts: List<Toast>) : UiState()
    }
}