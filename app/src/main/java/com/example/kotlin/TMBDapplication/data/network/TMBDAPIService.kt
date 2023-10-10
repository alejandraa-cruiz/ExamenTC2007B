package com.example.kotlin.TMBDapplication.data.network

import com.example.kotlin.TMBDapplication.domain.model.MovieResponse
import com.example.kotlin.TMBDapplication.domain.model.Result
import retrofit2.http.GET
import retrofit2.http.Query

interface TMBDAPIService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page:Int = 1
    ): MovieResponse
}