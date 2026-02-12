package com.example.jimmy_polanco_ap2_p1_.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.jimmy_polanco_ap2_p1_.data.local.entities.CervezaEntity
import kotlinx.coroutines.flow.Flow

@Dao
   interface Cervezadao {
       @Insert(onConflict = onConflictStrategy.REPLACE)
       suspend fun insert(cerveza: CervezaEntity)
       @Update
       suspend fun update(cerveza: CervezaEntity)
       @Delete
       suspend fun delete(cerveza: CervezaEntity)
       @Query("SELECT * FROM cerveza")
       fun getAll(): Flow<List<CervezaEntity>>
       @Query("SELECT * FROM cerveza WHERE IdCerveza = :id")
       suspend fun getById(id: Int): CervezaEntity?
       @Upsert
       suspend fun upsert(entity: CervezaEntity)

   }