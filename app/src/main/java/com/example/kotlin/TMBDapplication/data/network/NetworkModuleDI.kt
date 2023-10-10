package com.example.kotlin.TMBDapplication.data.network

import com.example.kotlin.TMBDapplication.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModuleDI {
    private val gsonFactory: GsonConverterFactory = GsonConverterFactory.create()


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