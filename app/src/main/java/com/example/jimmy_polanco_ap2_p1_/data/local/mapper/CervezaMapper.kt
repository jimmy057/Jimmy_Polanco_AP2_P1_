package com.example.jimmy_polanco_ap2_p1_.data.local.mapper

import com.example.jimmy_polanco_ap2_p1_.data.local.entities.CervezaEntity
import com.example.jimmy_polanco_ap2_p1_.domain.model.Cerveza

fun CervezaEntity.toDomain() = Cerveza(
    IdCerveza,
    Nombre,
    Marca,
    Puntuacion
)

fun Cerveza.toEntity() = CervezaEntity(
    IdCerveza,
    Nombre,
    Marca,
    Puntuacion
)