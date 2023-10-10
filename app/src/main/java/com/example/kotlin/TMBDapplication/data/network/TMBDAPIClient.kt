/**
 * This file contains the definition of the TMBDAPIClient class, which is responsible for
 * making API requests to retrieve popular movies from The Movie Database (TMDb) using the TMBDAPIService.
 *
 * @file TMBDAPIClient.kt
 */

package com.example.kotlin.TMBDapplication.data.network

import com.example.kotlin.TMBDapplication.domain.model.MovieResponse

/**
 * The `TMBDAPIClient` class facilitates making API requests to obtain popular movies from The Movie Database (TMDb).
 * It utilizes the `TMBDAPIService` interface for making network calls.
 */
class TMBDAPIClient {
    private lateinit var api: TMBDAPIService

    /**
     * Retrieves a list of popular movies from TMDb.
     *
     * @param page The page number of popular movies to fetch (default is 1).
     * @return A `MovieResponse` object containing a list of popular movies, or `null` if an error occurs.
     */
    suspend fun getPopularMovies(page: Int = 1): MovieResponse? {
        // Create an instance of the TMBDAPIService
        api = NetworkModuleDI()

        return try {
            // Make an API call to fetch popular movies
            api.getPopularMovies(page)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
