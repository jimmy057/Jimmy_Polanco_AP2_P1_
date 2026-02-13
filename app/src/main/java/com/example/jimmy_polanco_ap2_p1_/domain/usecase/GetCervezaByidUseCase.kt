package com.example.jimmy_polanco_ap2_p1_.domain.usecase

import com.example.jimmy_polanco_ap2_p1_.domain.model.Cerveza
import com.example.jimmy_polanco_ap2_p1_.domain.repository.CervezaRepository
import javax.inject.Inject

class GetCervezaByIdUseCase @Inject constructor(
    private val repository: CervezaRepository
) {
    suspend operator fun invoke(id: Int): Cerveza? {
        return repository.getById(id)
    }
}

