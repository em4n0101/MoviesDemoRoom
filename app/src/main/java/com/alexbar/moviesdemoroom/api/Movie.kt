package com.alexbar.moviesdemoroom.api

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val vote_average: Double,
    val poster_path: String?
)
