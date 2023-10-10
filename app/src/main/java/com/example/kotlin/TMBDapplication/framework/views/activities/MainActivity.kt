/**
 * This file contains the definition of the MainActivity class, which represents the main activity
 * for displaying a list of popular movies in the user interface.
 *
 * @file MainActivity.kt
 */

package com.example.kotlin.TMBDapplication.framework.views.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.TMBDapplication.databinding.ActivityMainBinding
import com.example.kotlin.TMBDapplication.domain.model.Result
import com.example.kotlin.TMBDapplication.framework.adapters.PopularMoviesAdapter
import com.example.kotlin.TMBDapplication.framework.viewmodel.MainViewModel

/**
 * The `MainActivity` class is the main activity of the application, responsible for displaying a list
 * of popular movies in the user interface.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val adapter: PopularMoviesAdapter = PopularMoviesAdapter()

    /**
     * Called when the activity is created. Initializes the binding, triggers the retrieval of popular
     * movie data, and sets up observers for LiveData.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        viewModel.getPopularMovies()
        initializeObservers()
    }

    /**
     * Initializes the view binding for this activity.
     */
    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    /**
     * Initializes observers for LiveData to react to changes in the popular movie data.
     */
    private fun initializeObservers() {
        viewModel.movieResponseLiveData.observe(this) { result ->
            setUpRecyclerView(result.results)
        }
    }

    /**
     * Sets up the RecyclerView to display a list of popular movies.
     *
     * @param dataForList The list of movie data to be displayed.
     */
    private fun setUpRecyclerView(dataForList: List<Result>) {
        binding.newRecyclerView.setHasFixedSize(true)

        // Configure a LayoutManager for the RecyclerView (you can choose between LinearLayoutManager or GridLayoutManager)
        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        binding.newRecyclerView.layoutManager = linearLayoutManager

        // Configure the RecyclerView adapter with movie data
        adapter.PopularMoviesAdapter(dataForList, this)
        binding.newRecyclerView.adapter = adapter
    }
}
