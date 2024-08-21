package com.alexbar.moviesdemoroom.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun BottomNavigationGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screens.TrendingMoviesScreen.route
    ) {
        composable(route = Screens.TrendingMoviesScreen.route) {
            Text("TrendingMoviesScreen")
        }

        composable(route = Screens.FavoritesMoviesScreen.route) {
            Text("FavoritesMoviesScreen")
        }

    }
}
