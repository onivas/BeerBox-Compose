package com.savinoordine.beerboxcompose.ui.detail

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun BeerDetailScreen(viewModel: BeerDetailViewModel = hiltViewModel()) {
    val beer = viewModel.state.observeAsState().value

    beer?.let { value ->
        Scaffold(
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeightIn(
                    min = 250.dp, max = 500.dp
                )
        ) {
            Text(text = value.name)
        }
    } ?: run {/* TODO */ }
}


@Preview
@Composable
fun DetailPreview() {
    BeerDetailScreen()
}