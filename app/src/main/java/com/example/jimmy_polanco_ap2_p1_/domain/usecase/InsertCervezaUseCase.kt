package com.example.jimmy_polanco_ap2_p1_.domain.usecase

import com.example.jimmy_polanco_ap2_p1_.domain.model.Cerveza
import com.example.jimmy_polanco_ap2_p1_.domain.repository.CervezaRepository

class InsertCervezaUseCase(
    private val repository: CervezaRepository
) {
    suspend operator fun invoke(cerveza: Cerveza) {
        repository.insert(cerveza)
    }
}