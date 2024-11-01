package com.shahriar.nectar.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp

@Composable
fun CustomEmailView(
    emailText: TextFieldValue,
    onTextChanged: (TextFieldValue) -> Unit,
){
    val focusManager = LocalFocusManager.current  // Request for inputText Focusing and Hiding as well as keyboard manager

    BasicTextField(
        value = emailText,
        singleLine = true,
        onValueChange = { newEmailText ->
            if (newEmailText.text.length <= 25) {
                onTextChanged(newEmailText)
            }
        },
        modifier = Modifier
            .fillMaxWidth(),
        textStyle = TextStyle(color = Color.Black,fontSize = 14.sp),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next // Specify "Next" action
        ),
        keyboardActions = KeyboardActions(
            onNext = {focusManager.moveFocus(FocusDirection.Down) }
        )
    )
}