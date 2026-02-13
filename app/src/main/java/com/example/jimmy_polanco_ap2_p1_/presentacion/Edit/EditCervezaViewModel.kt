package com.example.jimmy_polanco_ap2_p1_.presentacion.Edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jimmy_polanco_ap2_p1_.domain.model.Cerveza
import com.example.jimmy_polanco_ap2_p1_.domain.usecase.GetCervezaByIdUseCase
import com.example.jimmy_polanco_ap2_p1_.domain.usecase.InsertCervezaUseCase
import com.example.jimmy_polanco_ap2_p1_.domain.usecase.UpdateCervezaUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditCervezaViewModel @Inject constructor(
    private val insertUseCase: InsertCervezaUseCase,
    private val updateUseCase: UpdateCervezaUseCase,
    private val getByIdUseCase: GetCervezaByIdUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(EditCervezaUiState())
    val uiState: StateFlow<EditCervezaUiState> = _uiState

    fun loadCerveza(id: Int) {
        if (id == 0) return

        viewModelScope.launch {
            val cerveza = getByIdUseCase(id)
            cerveza?.let {
                _uiState.value = _uiState.value.copy(
                    id = it.idCerveza,
                    nombre = it.nombre,
                    marca = it.marca,
                    puntuacion = it.puntuacion.toString()
                )
            }
        }
    }

    fun onEvent(event: EditCervezaUiEvent) {
        when (event) {

            is EditCervezaUiEvent.OnNombreChange ->
                _uiState.value = _uiState.value.copy(nombre = event.value)

            is EditCervezaUiEvent.OnMarcaChange ->
                _uiState.value = _uiState.value.copy(marca = event.value)

            is EditCervezaUiEvent.OnPuntuacionChange ->
                _uiState.value = _uiState.value.copy(puntuacion = event.value)

            EditCervezaUiEvent.OnSaveClick ->
                save()
        }
    }

    private fun save() {
        viewModelScope.launch {

            if (_uiState.value.nombre.isBlank() ||
                _uiState.value.marca.isBlank() ||
                _uiState.value.puntuacion.isBlank()
            ) {
                return@launch
            }

            val puntuacionInt = _uiState.value.puntuacion.toIntOrNull()

            if (puntuacionInt == null || puntuacionInt !in 1..5) {
                return@launch
            }

            val cerveza = Cerveza(
                idCerveza = _uiState.value.id,
                nombre = _uiState.value.nombre,
                marca = _uiState.value.marca,
                puntuacion = puntuacionInt
            )

            if (_uiState.value.id == 0) {
                insertUseCase(cerveza)
            } else {
                updateUseCase(cerveza)
            }
        }
    }

}
