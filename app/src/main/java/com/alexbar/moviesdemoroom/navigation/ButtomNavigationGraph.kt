package com.alexbar.moviesdemoroom.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alexbar.moviesdemoroom.screens.TrendingMovies
import com.alexbar.moviesdemoroom.viewmodel.MoviesViewModel

@Composable
fun BottomNavigationGraph(
    navController: NavHostController,
    viewModel: MoviesViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screens.TrendingMoviesScreen.route
    ) {
        composable(route = Screens.TrendingMoviesScreen.route) {
            TrendingMovies(viewModel)
        }

        composable(route = Screens.FavoritesMoviesScreen.route) {
            Text("FavoritesMoviesScreen")
        }

    }
}
