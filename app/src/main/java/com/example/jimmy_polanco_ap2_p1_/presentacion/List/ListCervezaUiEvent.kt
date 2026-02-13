package com.example.jimmy_polanco_ap2_p1_.presentacion.List

import com.example.jimmy_polanco_ap2_p1_.domain.model.Cerveza

sealed class ListCervezaUiEvent {

    data class OnDeleteClick(val cerveza: Cerveza) : ListCervezaUiEvent()

}
