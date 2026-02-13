package com.example.jimmy_polanco_ap2_p1_.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cerveza")
data class CervezaEntity(

    @PrimaryKey(autoGenerate = true)
    val idCerveza: Int = 0,

    val nombre: String,
    val marca: String,
    val puntuacion: Int
)

