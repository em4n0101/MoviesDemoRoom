package com.alexbar.moviesdemoroom.repository

import com.alexbar.moviesdemoroom.api.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun insertMovie(movie: Movie)
    suspend fun deleteMovie(movie: Movie)
    suspend fun getMovies(): Flow<List<Movie>>
    suspend fun sortMoviesByName(): Flow<List<Movie>>
    suspend fun sortMoviesByVoteAverage(): Flow<List<Movie>>
}
