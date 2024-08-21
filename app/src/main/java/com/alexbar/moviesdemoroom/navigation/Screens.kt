package com.alexbar.moviesdemoroom.navigation

sealed class Screens(val route: String) {
    object TrendingMoviesScreen : Screens("trending_movies_screen")
    object FavoritesMoviesScreen : Screens("favorites_movies_screen")
}
