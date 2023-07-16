package com.example.shop.domain.repository

import com.example.shop.domain.model.Item
import com.example.shop.domain.utils.Response
import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    suspend fun insertItem(item: Item)

    suspend fun updateItem(item: Item)

    fun getItem(id: Int): Flow<Item>

    fun getAllItems(): Flow<List<Item>>
}