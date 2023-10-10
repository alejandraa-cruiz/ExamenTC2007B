package com.example.kotlin.TMBDapplication.data.network

import okhttp3.Interceptor
import okhttp3.Response

class TMBDInterceptor:Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmZjhkZDc1NmUzMmI4YWNlZjYyZmQ2YzMwZmQwY2NmOSIsInN1YiI6IjY0ZWI5MzhiZTg5NGE2MDEzYmIxNjNjZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.6cGDTI8wql15qnVZErrd_6QRNaiRAi74pRD0LfOzVZM") // Add your authorization header here
            .build()
        return chain.proceed(request)
    }
}