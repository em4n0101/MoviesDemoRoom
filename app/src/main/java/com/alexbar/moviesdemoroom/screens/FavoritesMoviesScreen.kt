package com.alexbar.moviesdemoroom.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.alexbar.moviesdemoroom.api.Movie
import com.alexbar.moviesdemoroom.viewmodel.MoviesViewModel

@Composable
fun FavoritesMovies(viewModel: MoviesViewModel) {
    val movies = remember { mutableStateListOf<Movie>() }

    LaunchedEffect(Unit) {
        viewModel.getFavoriteMovies()
        viewModel.favoriteMoviesStateFlow.collect { movieList ->
            movies.clear()
            movies.addAll(movieList)
        }
    }

    Surface {
        Column {
            FilterMenu(onSortOptionSelected = { sortOption ->
                viewModel.sortBy(sortOption)
            })
            LazyColumn {
                items(movies) { movie ->
                    MovieItem(movie, viewModel, true)
                }
            }
        }
    }
}