package com.savinoordine.beerboxcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.savinoordine.beerboxcompose.ui.detail.BeerDetailScreen
import com.savinoordine.beerboxcompose.ui.list.BeerListScreen
import com.savinoordine.beerboxcompose.ui.theme.BeerBoxComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeerBoxComposeTheme {
                BeerBoxApp()
            }
        }
    }

    companion object {
        // route
        const val BEER_LIST_ROUTE = "BEER_LIST_ROUTE"
        const val BEER_DETAIL_ROUTE = "BEER_LIST_ROUTE"
    }
}


@Composable
fun BeerBoxApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MainActivity.BEER_LIST_ROUTE
    ) {
        composable(
            route = MainActivity.BEER_LIST_ROUTE
        ) {
            BeerListScreen(navController = navController)
        }

        composable(
            route = "${MainActivity.BEER_DETAIL_ROUTE}/{beerId}",  // use {} for param
            arguments = listOf(navArgument("beerId") {
                type = NavType.IntType
            })
        ) {
            BeerDetailScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BeerBoxComposeTheme {
        BeerBoxApp()
    }
}