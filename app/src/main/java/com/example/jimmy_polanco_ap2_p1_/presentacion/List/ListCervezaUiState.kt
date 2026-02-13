package com.example.jimmy_polanco_ap2_p1_.presentacion.List

import com.example.jimmy_polanco_ap2_p1_.domain.model.Cerveza

data class ListCervezaUiState(
    val lista: List<Cerveza> = emptyList()
)