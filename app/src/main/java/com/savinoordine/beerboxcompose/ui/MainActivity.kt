package com.savinoordine.beerboxcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
            BeerListScreen()
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