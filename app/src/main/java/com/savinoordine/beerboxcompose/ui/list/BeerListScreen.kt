package com.savinoordine.beerboxcompose.ui.list

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.savinoordine.beerboxcompose.domain.BeerLight

@Composable
fun BeerListScreen(viewModel: BeerListViewModel = hiltViewModel()) {
    val beers = viewModel.state.observeAsState(initial = emptyList()).value

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        items(beers) { beer ->
            BeerItemCell(beer)
        }
    }
}

@Composable
fun BeerItemCell(beer: BeerLight) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(4.dp)
            .clickable {

            },
        elevation = 4.dp,
    ) {
        Log.d(">>>", beer.imageUrl)
        Row(horizontalArrangement = Arrangement.Start,
            modifier = Modifier.clickable {

            }) {
            Image(
                painter = rememberImagePainter(data = beer.imageUrl),
                modifier = Modifier
                    .size(88.dp)
                    .fillMaxHeight()
                    .align(Alignment.CenterVertically)
                    .padding(4.dp),
                contentDescription = null
            )
            Column(
                modifier = Modifier.padding(
                    start = 8.dp,
                )
            ) {
                Text(text = beer.name)
                Text(text = beer.tagline)
                Text(
                    color = Color.DarkGray,
                    text = "More info"
                )//stringResource(R.string))
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BeerItemCell(
        BeerLight(
            0, "Peroni", "Buonissima", "bevila in compagnia", ""
        )
    )
}