package com.example.shop.domain.utils

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.shop.domain.model.Item
import com.example.shop.presentation.ui.theme.EerieBlack
import com.example.shop.presentation.ui.theme.Vanilla


@Composable
fun EditText(
    keyboardType: KeyboardType,
    itemUiState: ItemUiState,
    onValueItemChange: (Item) -> Unit = {}
) {
    var text by remember {
        mutableStateOf("")
    }

    Spacer(modifier = Modifier.height(16.dp))
    Text(
        modifier = Modifier.padding(start = 16.dp),
        text = "Title",
        style = MaterialTheme.typography.body1,
        color = EerieBlack
    )

    TextField(
        value = text,
        onValueChange = { text = it}
    )
    TextField(
        value = itemUiState.item.title,
        onValueChange = {
            onValueItemChange(itemUiState.item.copy(title = it))
        },
        enabled = true,
        readOnly = false,
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 5.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent,
            disabledBorderColor = Color.Transparent,
            unfocusedContainerColor = Vanilla,
            focusedContainerColor = Vanilla,
            disabledContainerColor = Vanilla,

            ),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType)
    )

    Spacer(modifier = Modifier.height(16.dp))

    Text(
        modifier = Modifier.padding(start = 16.dp),
        text = "Item",
        style = MaterialTheme.typography.body1,
        color = EerieBlack
    )

    TextField(
        value = itemUiState.item.type,
        onValueChange = {
            onValueItemChange(itemUiState.item.copy(type = it))
        },
        enabled = true,
        readOnly = false,
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 5.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent,
            disabledBorderColor = Color.Transparent,
            unfocusedContainerColor = Vanilla,
            focusedContainerColor = Vanilla,
            disabledContainerColor = Vanilla,

            ),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType)
    )

    Spacer(modifier = Modifier.height(16.dp))

    Text(
        modifier = Modifier.padding(start = 16.dp),
        text = "Price",
        style = MaterialTheme.typography.body1,
        color = EerieBlack
    )

    TextField(
        value = itemUiState.item.price,
        onValueChange = {
            onValueItemChange(itemUiState.item.copy(price = it))
        },
        enabled = true,
        readOnly = false,
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 5.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent,
            disabledBorderColor = Color.Transparent,
            unfocusedContainerColor = Vanilla,
            focusedContainerColor = Vanilla,
            disabledContainerColor = Vanilla,

            ),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType)
    )
}
