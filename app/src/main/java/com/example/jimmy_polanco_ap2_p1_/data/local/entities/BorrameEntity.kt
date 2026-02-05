package com.example.jimmy_polanco_ap2_p1_.data.local.entities

import android.R
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "borrame")
data class BorrameEntity(
    @PrimaryKey(autoGenerate = true)
    val borrame: R.string,
)

