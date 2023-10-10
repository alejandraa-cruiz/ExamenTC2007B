/**
 * This file contains the definition of the NetworkModuleDI object, which is responsible for
 * configuring and providing an instance of the TMBDAPIService interface using Retrofit.
 *
 * @file NetworkModuleDI.kt
 */

package com.example.kotlin.TMBDapplication.data.network

import com.example.kotlin.TMBDapplication.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * The NetworkModuleDI object is a singleton that provides an instance of the TMBDAPIService
 * using Retrofit and OkHttpClient.
 */
object NetworkModuleDI {
    private val gsonFactory: GsonConverterFactory = GsonConverterFactory.create()

    /**
     * Creates and configures an instance of the TMBDAPIService using Retrofit and OkHttpClient.
     *
     * @return An instance of TMBDAPIService for making API requests to The Movie Database (TMDb).
     */
    operator fun invoke(): TMBDAPIService {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(TMBDInterceptor())
            .build()

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonFactory)
            .build()
            .create(TMBDAPIService::class.java)
    }
}
