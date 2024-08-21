package com.alexbar.moviesdemoroom.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alexbar.moviesdemoroom.api.Movie

@Database(entities = [Movie::class], version = 1)
abstract class MovieDatabase: RoomDatabase() {
    abstract val dao: MovieDao
}