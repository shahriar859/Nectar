package com.shahriar.nectar.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.shahriar.nectar.R

@Composable
fun CustomDivider(){
    HorizontalDivider(
        color = colorResource(id = R.color.nectar_gray_color),
        thickness = 1.dp,
        modifier = Modifier
            .fillMaxWidth()
    )
}