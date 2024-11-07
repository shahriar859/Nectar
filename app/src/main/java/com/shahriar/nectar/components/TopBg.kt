package com.shahriar.nectar.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.shahriar.nectar.R

@Composable
fun TopBg(navController: NavController) {
    val focusManager = LocalFocusManager.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.3f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.topbg),
            contentScale = ContentScale.Crop,
            contentDescription = "Top Image",
            modifier = Modifier.fillMaxWidth()
        )

        IconButton(
            onClick = {
                focusManager.clearFocus()
                navController.popBackStack()
            },
            modifier = Modifier
                .padding(top = 50.dp, start = 5.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "Back Icon"
            )
        }
    }
}