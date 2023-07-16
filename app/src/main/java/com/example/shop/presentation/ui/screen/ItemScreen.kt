package com.example.shop.presentation.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shop.domain.utils.EditText
import com.example.shop.presentation.ui.viewmodel.ItemScreenViewModel

@Composable
fun ItemScreen() {
    val exampleViewModel = hiltViewModel<ItemScreenViewModel>()
    Column(modifier = Modifier.fillMaxSize()) {
        EditText(onClick = { /*TODO*/ }, label = "titulo")
    }
}