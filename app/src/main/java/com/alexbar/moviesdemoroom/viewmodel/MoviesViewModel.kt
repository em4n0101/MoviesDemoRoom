package com.alexbar.moviesdemoroom.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexbar.moviesdemoroom.api.ApiService
import com.alexbar.moviesdemoroom.api.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val apiService: ApiService
) : ViewModel() {

    private val _moviesStateFlow = MutableStateFlow<List<Movie>>(emptyList())
    val moviesStateFlow: StateFlow<List<Movie>> = _moviesStateFlow

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
}
