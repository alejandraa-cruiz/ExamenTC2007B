package com.example.kotlin.TMBDapplication.framework.views.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.TMBDapplication.databinding.ActivityMainBinding
import com.example.kotlin.TMBDapplication.domain.model.Result
import com.example.kotlin.TMBDapplication.framework.adapters.PopularMoviesAdapter
import com.example.kotlin.TMBDapplication.framework.viewmodel.MainViewModel

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val adapter : PopularMoviesAdapter = PopularMoviesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        viewModel.getPopularMovies()
        initializeObservers()
    }


    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initializeObservers() {
        // Observa los cambios en el LiveData pokedexObjectLiveData y llama a setUpRecyclerView() cuando cambia
        viewModel.movieResponseLiveData.observe(this) { result ->
            setUpRecyclerView(result.results)
        }
    }

    private fun setUpRecyclerView(dataForList: List<Result>){
        binding.newRecyclerView.setHasFixedSize(true)

        // Configura un LayoutManager para el RecyclerView (puedes elegir entre LinearLayoutManager o GridLayoutManager)
        //LINEAR VIEW
        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false)



        binding.newRecyclerView.layoutManager = linearLayoutManager
        // Configura el adaptador del RecyclerView con los datos de Pokémon
        adapter.PopularMoviesAdapter(dataForList, this)
        binding.newRecyclerView.adapter = adapter
    }
}