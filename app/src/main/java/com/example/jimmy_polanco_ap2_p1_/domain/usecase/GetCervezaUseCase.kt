package com.example.jimmy_polanco_ap2_p1_.domain.usecase

import com.example.jimmy_polanco_ap2_p1_.domain.model.Cerveza
import com.example.jimmy_polanco_ap2_p1_.domain.repository.CervezaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCervezaUseCase @Inject constructor(
    private val repository: CervezaRepository
) {
    operator fun invoke(): Flow<List<Cerveza>> {
        return repository.getAll()
    }
}
