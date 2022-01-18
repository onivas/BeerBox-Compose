package com.savinoordine.beerboxcompose.ui.list

import androidx.compose.foundation.Image
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.savinoordine.beerboxcompose.domain.BeerLight
import com.savinoordine.beerboxcompose.navigation.BEER_DETAIL_ROUTE
import com.savinoordine.beerboxcompose.ui.common.LinearLoader

@Composable
fun BeerListScreen(
    viewModel: BeerListViewModel = hiltViewModel(),
    navController: NavController
) {
    val beers = viewModel.state.observeAsState(initial = emptyList()).value

    when (beers.size) {
        0 -> LinearLoader()
        else -> {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                items(beers) { beer ->
                    BeerItemCell(beer) {
                        navController.navigate("${BEER_DETAIL_ROUTE}/${beer.id}")
                    }
                }
            }
        }
    }
}

@Composable
fun BeerItemCell(beer: BeerLight, onBeerClicked: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(4.dp)
            .clickable {
                onBeerClicked(beer.id)
            },
        elevation = 4.dp,
    ) {

        Row(horizontalArrangement = Arrangement.Start) {
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
                modifier = Modifier
                    .padding(
                        start = 8.dp,
                    )
                    .height(88.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start,

                ) {
                Text(text = beer.name)
                Text(
                    text = beer.tagline,
                    fontStyle = FontStyle.Italic,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                )
                Text(
                    color = Color.Blue,
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
            0,
            "Peroni",
            "Buonissima Buonissima Buonissima Buonissima Buonissima Buonissima Buonissima Buonissima Buonissima",
            "bevila in compagnia",
            ""
        )
    ) {
        // np
    }
}