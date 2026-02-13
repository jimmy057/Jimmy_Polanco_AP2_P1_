package com.example.jimmy_polanco_ap2_p1_.presentacion.List

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jimmy_polanco_ap2_p1_.domain.usecase.DeleteCervezaUseCase
import com.example.jimmy_polanco_ap2_p1_.domain.usecase.GetCervezaUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListCervezaViewModel @Inject constructor(
    private val getCervezaUseCase: GetCervezaUseCase,
    private val deleteCervezaUseCase: DeleteCervezaUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(ListCervezaUiState())
    val uiState: StateFlow<ListCervezaUiState> = _uiState

    init {
        getCervezas()
    }

    private fun getCervezas() {
        viewModelScope.launch {
            getCervezaUseCase().collect { lista ->
                _uiState.value = _uiState.value.copy(lista = lista)
            }
        }
    }

    fun onEvent(event: ListCervezaUiEvent) {
        when (event) {
            is ListCervezaUiEvent.OnDeleteClick -> {
                viewModelScope.launch {
                    deleteCervezaUseCase(event.cerveza)
                }
            }
        }
    }
}
