/**
 * This file contains the definition of the MainViewModel class, which is a ViewModel responsible for
 * managing the retrieval of popular movie data and handling the associated LiveData.
 *
 * @file MainViewModel.kt
 */

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

/**
 * The `MainViewModel` class is a ViewModel that manages the retrieval of popular movie data from the
 * repository and provides this data through LiveData for use in the user interface.
 */
class MainViewModel : ViewModel() {
    // LiveData to observe changes in the popular movie data
    val movieResponseLiveData = MutableLiveData<MovieResponse>()

    // An instance of the PopularMoviesRequirement class to fetch popular movies
    private val popularMoviesRequirement = PopularMoviesRequirement()

    /**
     * Initiates the retrieval of popular movie data from the repository.
     */
    fun getPopularMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            // Retrieve popular movie data
            val result: MovieResponse? = popularMoviesRequirement(1)
            Log.d("Salida", result.toString())

            if (result != null) {
                // Update the LiveData with the retrieved data on the main thread
                CoroutineScope(Dispatchers.Main).launch {
                    movieResponseLiveData.postValue(result!!)
                }
            }
        }
    }
}
