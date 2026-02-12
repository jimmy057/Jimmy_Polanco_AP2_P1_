package com.example.jimmy_polanco_ap2_p1_.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Cerveza")
data class CervezaEntity(
    @PrimaryKey(autoGenerate = true)
    val IdCerveza: Int = 0,
    val Nombre: String,
    val Marca: String,
    val Puntuacion: Int
)

