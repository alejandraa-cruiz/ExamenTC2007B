package com.example.kotlin.TMBDapplication.data.network

import retrofit2.http.GET
import retrofit2.http.Query

interface TMBDAPIService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page:Int = 1
    ): com.example.kotlin.TMBDapplication.data.network.model.Result
}