package com.example.shop.presentation.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shop.domain.model.Item
import com.example.shop.domain.usecase.InsertItemUseCase
import com.example.shop.domain.utils.ItemUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemScreenViewModel @Inject constructor(
    private val insertUseCase: InsertItemUseCase
) : ViewModel() {

    var itemUiState by mutableStateOf(ItemUiState())
        private set

    fun updateItem(item: Item) {
        itemUiState = ItemUiState(
            item = item,
            isEntryValid = validInput()
        )
    }

    fun insertItem() {
        if (validInput())
            viewModelScope.launch {
                try {
                    insertUseCase.invoke(itemUiState.item)
                } catch (e: Exception) {

                }
            }
    }

    private fun validInput(uiState: Item = itemUiState.item): Boolean {
        return with(uiState) {
            title.isNotBlank() && !price.equals(null) && type.isNotBlank()
        }
    }
}
