package com.example.shop.domain.usecase

import com.example.shop.domain.model.Item
import com.example.shop.domain.repository.ItemRepository
import javax.inject.Inject

class UpdateItemUseCase @Inject constructor(private val itemRepository: ItemRepository) {
    suspend operator fun invoke(item: Item) = itemRepository.updateItem(item)
}