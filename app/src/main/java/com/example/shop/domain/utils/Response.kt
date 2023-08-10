package com.example.shop.domain.utils

import com.example.shop.domain.model.Item

data class ItemUiState(
    val item : Item = Item(),
    val isEntryValid: Boolean = false
)
