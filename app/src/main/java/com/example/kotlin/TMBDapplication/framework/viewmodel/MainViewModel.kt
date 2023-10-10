package com.example.kotlin.TMBDapplication.framework.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.TMBDapplication.domain.PopularMoviesRequirement
import com.example.kotlin.TMBDapplication.domain.model.MovieResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel(){
    val movieResponseLiveData = MutableLiveData<MovieResponse>()
    private val PopularMoviesRequirement = PopularMoviesRequirement()
    fun getPopularMovies(){
        viewModelScope.launch(Dispatchers.IO) {
            val result: MovieResponse? = PopularMoviesRequirement(1)
            Log.d("Salida", result.toString())
            if (result != null){
                CoroutineScope(Dispatchers.Main).launch {
                    movieResponseLiveData.postValue(result!!)
                }
            }
        }
    }
}