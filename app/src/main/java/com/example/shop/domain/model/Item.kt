package com.example.shop.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val title: String,
    val price: Double
)
