package com.example.shop.presentation.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shop.domain.utils.EditText
import com.example.shop.presentation.ui.theme.EerieBlack
import com.example.shop.presentation.ui.theme.Flax
import com.example.shop.presentation.ui.theme.IndianRed
import com.example.shop.presentation.ui.theme.LightVanilla
import com.example.shop.presentation.ui.viewmodel.ItemScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemScreen() {
    val itemViewModel = hiltViewModel<ItemScreenViewModel>()

    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .background(LightVanilla)
            ) {
                EditText(
                    keyboardType = KeyboardType.Text,
                    itemUiState = itemViewModel.itemUiState,
                    onValueItemChange = itemViewModel::updateItem
                )

                Button(
                    onClick = {
                        itemViewModel.insertItem()
                    },
                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                        contentColor = EerieBlack,
                        containerColor = Flax,

                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = "Add",
                        style = MaterialTheme.typography.body1
                    )
                }

            }
        }
    )
}
