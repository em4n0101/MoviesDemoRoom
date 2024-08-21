package com.alexbar.moviesdemoroom.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.alexbar.moviesdemoroom.api.Movie
import com.alexbar.moviesdemoroom.utils.Constants.MOVIES_TABLE
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Upsert
    suspend fun upsertMovie(movie: Movie)

    @Query("SELECT * FROM $MOVIES_TABLE")
    fun getAllMovies(): Flow<List<Movie>>

    @Query("SELECT * FROM $MOVIES_TABLE ORDER BY title ASC")
    fun sortByTitle(): Flow<List<Movie>>

    @Delete
    suspend fun deleteMovie(movie: Movie)

    @Query("SELECT * FROM $MOVIES_TABLE ORDER BY title ASC")
    fun sortByName(): Flow<List<Movie>>

    @Query("SELECT * FROM $MOVIES_TABLE ORDER BY vote_average DESC")
    fun sortByVoteAverage(): Flow<List<Movie>>
}
