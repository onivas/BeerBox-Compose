package com.savinoordine.beerboxcompose.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.savinoordine.beerboxcompose.ui.detail.BeerDetailScreen
import com.savinoordine.beerboxcompose.ui.list.BeerListScreen

// routes
const val MAIN_ROUTE = "MAIN_ROUTE"
const val BEER_LIST_ROUTE = "BEER_LIST_ROUTE"
const val BEER_DETAIL_ROUTE = "BEER_LIST_ROUTE"

@ExperimentalMaterialApi
fun NavGraphBuilder.mainGraph(navController: NavController) {
    navigation(startDestination = BEER_LIST_ROUTE, route = MAIN_ROUTE) {
        composable(
            route = BEER_LIST_ROUTE
        ) {
            BeerListScreen(navController = navController)
        }

        composable(
            route = "${BEER_DETAIL_ROUTE}/{beerId}",  // use {} for param
            arguments = listOf(navArgument("beerId") {
                type = NavType.IntType
            })
        ) {
            BeerDetailScreen()
        }
    }
}