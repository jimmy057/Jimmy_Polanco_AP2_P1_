package com.example.jimmy_polanco_ap2_p1_.domain.repository

import com.example.jimmy_polanco_ap2_p1_.domain.model.Cerveza
import kotlinx.coroutines.flow.Flow

interface CervezaRepository {
    suspend  fun insert(cerveza: Cerveza)
    suspend  fun update(cerveza: Cerveza)
    suspend fun delete(cerveza: Cerveza)
    fun getAll(): Flow<List<Cerveza>>
}