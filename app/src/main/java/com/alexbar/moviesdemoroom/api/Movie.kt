package com.alexbar.moviesdemoroom.api

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alexbar.moviesdemoroom.utils.Constants.MOVIES_TABLE

@Entity(tableName = MOVIES_TABLE)
data class Movie(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val overview: String,
    val vote_average: Double,
    val poster_path: String?
)

enum class Sort {
    NONE,
    NAME,
    VOTE_AVERAGE
}
