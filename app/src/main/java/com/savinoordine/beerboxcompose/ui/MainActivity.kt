package com.savinoordine.beerboxcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.savinoordine.beerboxcompose.navigation.MAIN_ROUTE
import com.savinoordine.beerboxcompose.navigation.mainGraph
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

}


@Composable
fun BeerBoxApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MAIN_ROUTE
    ) {
        mainGraph(navController = navController)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BeerBoxComposeTheme {
        BeerBoxApp()
    }
}