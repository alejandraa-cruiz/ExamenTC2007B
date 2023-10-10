/**
 * This file contains the definition of the PopularMoviesRequirement class, which is responsible
 * for managing the retrieval of popular movies from The Movie Database (TMDb) through the TMBDRepository.
 *
 * @file PopularMoviesRequirement.kt
 */

package com.example.kotlin.TMBDapplication.domain

import com.example.kotlin.TMBDapplication.data.TMBDRepository
import com.example.kotlin.TMBDapplication.domain.model.MovieResponse

/**
 * The `PopularMoviesRequirement` class serves as a high-level component responsible for fetching
 * popular movies from The Movie Database (TMDb) by utilizing the `TMBDRepository`.
 */
class PopularMoviesRequirement {
    private val repository = TMBDRepository()

    /**
     * Retrieves a list of popular movies from TMDb.
     *
     * @param page The page number of popular movies to fetch.
     * @return A `MovieResponse` object containing a list of popular movies, or `null` if an error occurs.
     */
    suspend operator fun invoke(page: Int): MovieResponse? = repository.getPopularMovies(page)
}
