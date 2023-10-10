/**
 * This file contains the definition of the TMBDAPIService interface, which defines the API endpoints
 * for accessing popular movies from The Movie Database (TMDb).
 *
 * @file TMBDAPIService.kt
 */

package com.example.kotlin.TMBDapplication.data.network

import com.example.kotlin.TMBDapplication.domain.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * The `TMBDAPIService` interface defines the API endpoints for retrieving popular movies from
 * The Movie Database (TMDb).
 */
interface TMBDAPIService {
    /**
     * Fetches a list of popular movies from TMDb.
     *
     * @param page The page number of popular movies to fetch (default is 1).
     * @return A `MovieResponse` object containing a list of popular movies.
     */
    @GET("movie/popular/")
    suspend fun getPopularMovies(
        @Query("page") page: Int = 1
    ): MovieResponse
}
