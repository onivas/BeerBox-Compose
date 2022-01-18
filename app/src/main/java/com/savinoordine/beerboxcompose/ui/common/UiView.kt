package com.savinoordine.beerboxcompose.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LinearLoader() {
    LinearProgressIndicator(
        modifier = Modifier
            .fillMaxWidth()
            .height(3.dp),
        color = Color.Red
    )
}