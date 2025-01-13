package com.ricardo.workshop.android.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ricardo.workshop.android.data.LocalDataSource
import com.ricardo.workshop.android.data.Toast
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
        viewModelScope.launch {
            try {
                val toasts = LocalDataSource().getToasts()
                _uiState.value = UiState.Content(toasts)
            } catch (e: Exception) {
                _uiState.value = UiState.Error
            }
        }
    }

    sealed class UiState {
        data object Loading : UiState()
        data object Error : UiState()
        data class Content(val toasts: List<Toast>) : UiState()
    }
}