package com.example.kotlin.TMBDapplication.domain

import com.example.kotlin.TMBDapplication.data.TMBDRepository

class PopularMoviesRequirement {
    private val repository = TMBDRepository()
    suspend operator fun invoke(
        page: Int
    ) = repository.getPopularMovies(page)
}