package com.example.kotlin.TMBDapplication.data

import com.example.kotlin.TMBDapplication.data.network.TMBDAPIClient

class TMBDRepository (){
    private val apiTMBD = TMBDAPIClient()
    suspend fun  getPopularMovies(page:Int = 1): com.example.kotlin.TMBDapplication.data.network.model.Result? = apiTMBD.getPopularMovies(page)
}