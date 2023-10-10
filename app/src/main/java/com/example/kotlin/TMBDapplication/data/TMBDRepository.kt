/**
 * This file contains the definition of the TMBDRepository class, which serves as a repository for
 * accessing popular movies from The Movie Database (TMDb) using the TMBDAPIClient.
 *
 * @file TMBDRepository.kt
 */

package com.example.kotlin.TMBDapplication.data

import com.example.kotlin.TMBDapplication.data.network.TMBDAPIClient
import com.example.kotlin.TMBDapplication.domain.model.MovieResponse

/**
 * The `TMBDRepository` class is responsible for retrieving popular movies from The Movie Database (TMDb).
 * It uses the `TMBDAPIClient` to make API requests and obtain movie data.
 *
 * @constructor Creates an instance of `TMBDRepository`.
 */
class TMBDRepository {
    private val apiTMBD = TMBDAPIClient()

    /**
     * Retrieves a list of popular movies from TMDb.
     *
     * @param page The page number of popular movies to fetch (default is 1).
     * @return A `MovieResponse` object containing a list of popular movies, or `null` if an error occurs.
     * @throws [NetworkException] in case of a network error.
     */
    suspend fun getPopularMovies(page: Int = 1): MovieResponse? = apiTMBD.getPopularMovies(page)
}
