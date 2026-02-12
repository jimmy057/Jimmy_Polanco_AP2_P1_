package com.example.jimmy_polanco_ap2_p1_.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jimmy_polanco_ap2_p1_.data.local.dao.Cervezadao
import com.example.jimmy_polanco_ap2_p1_.data.local.entities.CervezaEntity

@Database(
    entities = [
        CervezaEntity::class
    ],
    version = 1,
    exportSchema = false
)

abstract class appdatabase: RoomDatabase(){
    abstract fun Cervezadao(): Cervezadao

}