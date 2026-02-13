package com.example.jimmy_polanco_ap2_p1_.data.local.mapper

import com.example.jimmy_polanco_ap2_p1_.data.local.entities.CervezaEntity
import com.example.jimmy_polanco_ap2_p1_.domain.model.Cerveza

fun CervezaEntity.toDomain() = Cerveza(
    idCerveza = idCerveza,
    nombre = nombre,
    marca = marca,
    puntuacion = puntuacion
)

fun Cerveza.toEntity() = CervezaEntity(
    idCerveza = idCerveza,
    nombre = nombre,
    marca = marca,
    puntuacion = puntuacion
)