package com.alexbar.moviesdemoroom.api

import com.alexbar.moviesdemoroom.utils.Constants.API_GET_MOVIES
import com.alexbar.moviesdemoroom.utils.Constants.API_KEY
import com.alexbar.moviesdemoroom.utils.Constants.API_LANGUAGE
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(API_GET_MOVIES)
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = API_LANGUAGE,
        @Query("page") page: Int = 1
    ): MovieResponse
}
