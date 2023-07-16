package com.example.shop.domain.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun EditText(
    onClick: () -> Unit,
    label: String
) {
    var textLabel by rememberSaveable { mutableStateOf(label) }

    OutlinedTextField(
        value = textLabel,
        onValueChange = { textLabel = it },
        enabled = true,
        readOnly = false,
        singleLine = false,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 10.dp)
            .border(5.dp, Color.Red, RoundedCornerShape(percent = 50))
            .background(Color.Green, RoundedCornerShape(percent = 50)),
        colors = OutlinedTextFieldDefaults.colors(
            disabledBorderColor = Color.Green,
//            cursorColor = ,
//            disabledContainerColor = Color.Yellow,
//            disabledLabelColor = Color.Red
//            disabledLeadingIconColor = ,
//            disabledPlaceholderColor = ,
//            disabledSupportingTextColor = ,
//            disabledTextColor = ,
//            disabledPrefixColor = ,
//            disabledSuffixColor = ,
//            disabledTrailingIconColor = ,
//            errorBorderColor = ,
//            errorContainerColor = ,
//            errorCursorColor = ,
//            errorLabelColor = ,
//            errorLeadingIconColor = ,
//            errorPlaceholderColor = ,
//            errorPrefixColor = ,
//            errorSupportingTextColor = ,
//            errorTextColor = ,
//            errorSuffixColor = ,
//            errorTrailingIconColor = ,
//            focusedBorderColor = ,
//            focusedContainerColor = ,
//            focusedLabelColor = ,
//            focusedLeadingIconColor = ,
//            focusedPlaceholderColor = ,
//            focusedPrefixColor = ,
//            focusedSupportingTextColor = ,
//            focusedTextColor = ,
//            focusedSuffixColor = ,
//            focusedTrailingIconColor = ,
//            selectionColors = ,
//            unfocusedBorderColor = ,
//            unfocusedContainerColor = ,
//            unfocusedLabelColor = ,
//            unfocusedLeadingIconColor = ,
//            unfocusedPlaceholderColor = ,
//            unfocusedPrefixColor = ,
//            unfocusedSupportingTextColor = ,
//            unfocusedTextColor = ,
//            unfocusedSuffixColor = ,
//            unfocusedTrailingIconColor =
        )
    )
}