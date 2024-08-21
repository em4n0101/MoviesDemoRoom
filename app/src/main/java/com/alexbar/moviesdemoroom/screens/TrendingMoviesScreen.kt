package com.alexbar.moviesdemoroom.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.alexbar.moviesdemoroom.viewmodel.MoviesViewModel

@Composable
fun TrendingMovies(viewModel: MoviesViewModel) {
    val favoriteMovies = viewModel.favoriteMoviesStateFlow.collectAsState(initial = emptyList())
    val movies = viewModel.moviesStateFlow.collectAsState(initial = emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchPopularMovies()
    }

    Surface {
        LazyColumn {
            items(movies.value) { movie ->
                MovieItem(movie, viewModel, favoriteMovies.value.contains(movie))
            }
        }
    }
}