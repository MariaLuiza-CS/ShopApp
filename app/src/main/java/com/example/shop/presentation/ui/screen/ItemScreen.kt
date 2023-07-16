package com.example.shop.presentation.ui.screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shop.domain.model.Item
import com.example.shop.presentation.ui.viewmodel.ItemScreenViewModel

@Composable
fun ItemScreen() {
    val exampleViewModel = hiltViewModel<ItemScreenViewModel>()

    exampleViewModel.insertItem(Item(1,"teste", 10.3))
}