package com.savinoordine.beerboxcompose.ui.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
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
import com.savinoordine.beerboxcompose.domain.Beer
import com.savinoordine.beerboxcompose.ui.common.LinearLoader

@ExperimentalMaterialApi
@Composable
fun BeerDetailScreen(viewModel: BeerDetailViewModel = hiltViewModel()) {
    val scaffoldState = rememberBottomSheetScaffoldState()
    val beer = viewModel.state.observeAsState().value

    BottomSheetScaffold(
        modifier = Modifier
            .fillMaxWidth(),
        scaffoldState = scaffoldState,
        sheetPeekHeight = 80.dp,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetContent = {  //content inside the bottom sheet
            BottomSheetView(beer)
        }
    ) { // main content of the view
        beer?.let { value -> DetailBeerView(value) }
            ?: run { LinearLoader() }
    }
}

@Composable
fun DetailBeerView(value: Beer) {
    Row(modifier = Modifier.fillMaxWidth()) {
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
}

@Composable
fun BottomSheetView(beer: Beer?) {
    Column(
        modifier = Modifier
            .height(300.dp)
            .fillMaxWidth()
            .background(
                color = Color.Yellow,
                shape = MaterialTheme.shapes.large,
            )
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = rememberImagePainter(data = beer?.imageUrl),
            contentDescription = null
        )
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun DetailPreview() {
    BeerDetailScreen()
}