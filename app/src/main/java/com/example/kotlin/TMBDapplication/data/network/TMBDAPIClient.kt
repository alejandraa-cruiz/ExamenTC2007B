package com.example.kotlin.TMBDapplication.data.network

import com.example.kotlin.TMBDapplication.domain.model.Result

class TMBDAPIClient {
    private lateinit var api: TMBDAPIService
    suspend fun getPopularMovies(page:Int = 1): Result?{
        api = NetworkModuleDI()
        return try{
            api.getPopularMovies(page)}
        catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }
}