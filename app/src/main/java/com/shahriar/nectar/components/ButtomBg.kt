package com.shahriar.nectar.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.shahriar.nectar.R

@Composable
fun BottomBg() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.bottombg),
            contentScale = ContentScale.Crop,
            contentDescription = "Bottom Image",
            modifier = Modifier.fillMaxSize()
                .align(Alignment.BottomCenter)
        )
    }
}