package com.example.jimmy_polanco_ap2_p1_.presentacion.Edit

sealed class EditCervezaUiEvent {

    data class OnNombreChange(val value: String) : EditCervezaUiEvent()

    data class OnMarcaChange(val value: String) : EditCervezaUiEvent()

    data class OnPuntuacionChange(val value: String) : EditCervezaUiEvent()

    object OnSaveClick : EditCervezaUiEvent()
}