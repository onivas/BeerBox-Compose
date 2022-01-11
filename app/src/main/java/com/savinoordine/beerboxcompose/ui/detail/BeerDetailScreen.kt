package com.savinoordine.beerboxcompose.ui.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter

@Composable
fun BeerDetailScreen(viewModel: BeerDetailViewModel = hiltViewModel()) {
    val beer = viewModel.state.observeAsState().value

    Scaffold(
        modifier = Modifier
            .fillMaxWidth()
            .requiredHeightIn(
                min = 250.dp, max = 500.dp
            )
    ) {
        beer?.let { value ->
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    modifier = Modifier.height(150.dp),
                    painter = rememberImagePainter(data = value.imageUrl),
                    contentDescription = null
                )
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = value.name,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = value.tagline,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic,
                        fontSize = 12.sp
                    )
                    Text(
                        text = value.description,
                        fontSize = 15.sp,
                        color = Color.Blue,
                        modifier = Modifier
                            .padding(4.dp)
                            .border(
                                border = BorderStroke(width = 2.dp, color = Color.Blue),
                                shape = RectangleShape
                            )
                            .padding(8.dp)
                    )
                }

            }

        } ?: run {
            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(3.dp),
                color = Color.Red
            )
        }
    }
}


@Preview
@Composable
fun DetailPreview() {
    BeerDetailScreen()
}