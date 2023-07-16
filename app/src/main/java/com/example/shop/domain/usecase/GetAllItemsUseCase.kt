package com.example.shop.domain.usecase

import com.example.shop.domain.repository.ItemRepository
import javax.inject.Inject

class GetAllItemsUseCase @Inject constructor(private val itemRepository: ItemRepository) {
    suspend operator fun invoke() = itemRepository.getAllItems()
}