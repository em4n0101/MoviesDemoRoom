package com.alexbar.moviesdemoroom.api

import com.alexbar.moviesdemoroom.api.Movie

data class MovieResponse(
    val results: List<Movie>
)