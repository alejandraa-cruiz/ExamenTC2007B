package com.example.kotlin.TMBDapplication.domain

import com.example.kotlin.TMBDapplication.data.TMBDRepository
import com.example.kotlin.TMBDapplication.domain.model.MovieResponse

class PopularMoviesRequirement {
    private val repository = TMBDRepository()
    suspend operator fun invoke(
        page: Int
    ) :MovieResponse? = repository.getPopularMovies(page)
}