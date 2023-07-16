package com.example.shop.domain.usecase

import com.example.shop.domain.repository.ItemRepository
import javax.inject.Inject

class GetItemUseCase @Inject constructor(private val itemRepository: ItemRepository) {
    suspend operator fun invoke(id: Int) = itemRepository.getItem(id)
}