package com.example.kotlin.TMBDapplication.data

import com.example.kotlin.TMBDapplication.data.network.TMBDAPIClient
import com.example.kotlin.TMBDapplication.domain.model.MovieResponse
import com.example.kotlin.TMBDapplication.domain.model.Result

class TMBDRepository (){
    private val apiTMBD = TMBDAPIClient()
    suspend fun  getPopularMovies(page:Int = 1): MovieResponse? = apiTMBD.getPopularMovies(page)
}