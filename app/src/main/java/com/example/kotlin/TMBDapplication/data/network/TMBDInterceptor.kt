/**
 * This file contains the definition of the TMBDInterceptor class, which is an OkHttp Interceptor
 * responsible for adding an authorization header to outgoing HTTP requests.
 *
 * @file TMBDInterceptor.kt
 */

package com.example.kotlin.TMBDapplication.data.network

import okhttp3.Interceptor
import okhttp3.Response

/**
 * The `TMBDInterceptor` class is an OkHttp Interceptor used to add an authorization header to
 * outgoing HTTP requests. It includes an API key (Bearer token) to authenticate and authorize access
 * to The Movie Database (TMDb) API.
 */
class TMBDInterceptor : Interceptor {
    /**
     * Intercepts the HTTP request and adds an authorization header with the Bearer token.
     *
     * @param chain The interceptor chain for processing the request and response.
     * @return A modified HTTP response after adding the authorization header.
     */
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            // Add your authorization header here
            .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmZjhkZDc1NmUzMmI4YWNlZjYyZmQ2YzMwZmQwY2NmOSIsInN1YiI6IjY0ZWI5MzhiZTg5NGE2MDEzYmIxNjNjZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.6cGDTI8wql15qnVZErrd_6QRNaiRAi74pRD0LfOzVZM")
            .build()
        return chain.proceed(request)
    }
}
