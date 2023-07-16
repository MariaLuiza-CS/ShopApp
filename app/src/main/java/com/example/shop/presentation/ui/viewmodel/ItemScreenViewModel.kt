package com.example.shop.presentation.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shop.domain.model.Item
import com.example.shop.domain.usecase.InsertItemUseCase
import com.example.shop.domain.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemScreenViewModel @Inject constructor(
    private val insertUseCase: InsertItemUseCase
) : ViewModel() {

    private val _tryInsertUser = mutableStateOf(Response.Failure(null))
    val tryInsertUser = _tryInsertUser

    fun insertItem(item: Item) {
        viewModelScope.launch {
            try {
                insertUseCase.invoke(item)
            } catch (e: Exception) {
                _tryInsertUser.value = Response.Failure(e)
            }
        }
    }

}