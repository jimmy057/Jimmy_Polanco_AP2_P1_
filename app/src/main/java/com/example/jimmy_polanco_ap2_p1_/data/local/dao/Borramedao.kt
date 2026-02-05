package com.example.jimmy_polanco_ap2_p1_.data.local.dao

import androidx.room.Dao
import androidx.room.Upsert
import com.example.jimmy_polanco_ap2_p1_.data.local.entities.BorrameEntity

@Dao
   interface Borramedao {
       @Upsert
       suspend fun upsert(entity: BorrameEntity)

   }