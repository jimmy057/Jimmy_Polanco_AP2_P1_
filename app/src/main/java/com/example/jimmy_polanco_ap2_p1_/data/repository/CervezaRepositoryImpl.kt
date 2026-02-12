package com.example.jimmy_polanco_ap2_p1_.data.repository

import com.example.jimmy_polanco_ap2_p1_.data.local.dao.Cervezadao
import com.example.jimmy_polanco_ap2_p1_.data.local.mapper.toEntity
import com.example.jimmy_polanco_ap2_p1_.domain.model.Cerveza
import com.example.jimmy_polanco_ap2_p1_.domain.repository.CervezaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CervezaRepositoryImpl (
    private val dao: Cervezadao
): CervezaRepository {
    override suspend fun insert(cerveza: Cerveza) {
        dao.insert(cerveza.toEntity())
    }

    override suspend fun update(cerveza: Cerveza) {
        dao.update(cerveza.toEntity())
    }

    override suspend fun delete(cerveza: Cerveza) {
        dao.delete(cerveza.toEntity())
    }

    override fun getAll(): Flow<List<Cerveza>> {
        return dao.getAll().map { lista->
            Lista.map {it.toDomain()}
        }
    }

    override suspend fun getById(id: Int): Cerveza? {
        return dao getById(id)? .toDomain()
    }
}