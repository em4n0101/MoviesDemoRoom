package com.alexbar.moviesdemoroom.repository

import com.alexbar.moviesdemoroom.api.Movie
import com.alexbar.moviesdemoroom.database.MovieDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieRepositoryImpl  @Inject constructor(
    private val dao: MovieDao
) : MovieRepository {

    override suspend fun insertMovie(movie: Movie) {
        withContext(Dispatchers.IO) {
            dao.upsertMovie(movie)
        }
    }

    override suspend fun deleteMovie(movie: Movie) {
        withContext(Dispatchers.IO) {
            dao.deleteMovie(movie)
        }
    }

    override suspend fun getMovies(): Flow<List<Movie>> {
        return withContext(Dispatchers.IO) {
            dao.getAllMovies()
        }
    }

    override suspend fun sortMoviesByName(): Flow<List<Movie>> {
        return withContext(Dispatchers.IO) {
            dao.sortByName()
        }
    }

    override suspend fun sortMoviesByVoteAverage(): Flow<List<Movie>> {
        return withContext(Dispatchers.IO) {
            dao.sortByVoteAverage()
        }
    }

}