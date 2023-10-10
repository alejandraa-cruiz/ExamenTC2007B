package com.example.kotlin.TMBDapplication.data.network

class TMBDAPIClient {
    private lateinit var api: TMBDAPIService
    suspend fun getPopularMovies(page:Int = 1): com.example.kotlin.TMBDapplication.data.network.model.Result?{
        api = NetworkModuleDI()
        return try{
            api.getPopularMovies(page)}
        catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }
}