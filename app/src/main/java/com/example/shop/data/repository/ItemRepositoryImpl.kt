package com.example.shop.data.repository

import com.example.shop.data.dao.ItemDao
import com.example.shop.domain.model.Item
import com.example.shop.domain.repository.ItemRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(private val itemDao: ItemDao) : ItemRepository {

    override suspend fun insertItem(item: Item) = itemDao.insertItem(item)

    override suspend fun updateItem(item: Item) = itemDao.updateItem(item)

    override fun getItem(id: Int): Flow<Item> = itemDao.getItem(id)

    override fun getAllItems(): Flow<List<Item>> = itemDao.getAllItems()
}
