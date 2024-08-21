package com.alexbar.moviesdemoroom.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexbar.moviesdemoroom.api.ApiService
import com.alexbar.moviesdemoroom.api.Movie
import com.alexbar.moviesdemoroom.api.Sort
import com.alexbar.moviesdemoroom.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val repository: MovieRepository,
    private val apiService: ApiService
) : ViewModel() {

    private val _moviesStateFlow = MutableStateFlow<List<Movie>>(emptyList())
    val moviesStateFlow: StateFlow<List<Movie>> = _moviesStateFlow

    private val _favoriteMoviesStateFlow = MutableStateFlow<List<Movie>>(emptyList())
    val favoriteMoviesStateFlow: StateFlow<List<Movie>> = _favoriteMoviesStateFlow

    init {
        fetchPopularMovies()
    }

    fun fetchPopularMovies() {
        viewModelScope.launch {
            try {
                val response = apiService.getPopularMovies()
                val movies = response.results
                _moviesStateFlow.emit(movies)
            } catch (e: Exception) {

            }
        }
    }


    fun insertMovie(movie: Movie) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertMovie(movie)
        }
    }

    fun deleteMovie(movie: Movie) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteMovie(movie)
        }
    }

    fun getFavoriteMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getMovies().collectLatest {
                _favoriteMoviesStateFlow.tryEmit(it)
            }
        }
    }

    fun sortBy(sort: Sort) {
        viewModelScope.launch(Dispatchers.IO) {
            when (sort) {
                Sort.NONE -> repository.getMovies().collectLatest {
                    _favoriteMoviesStateFlow.value = it
                }
                Sort.NAME -> repository.sortMoviesByName().collectLatest {
                    _favoriteMoviesStateFlow.value = it
                }
                Sort.VOTE_AVERAGE -> repository.sortMoviesByVoteAverage().collectLatest {
                    _favoriteMoviesStateFlow.value = it
                }
            }
        }
    }
}
