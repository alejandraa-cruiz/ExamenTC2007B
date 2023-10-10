/**
 * This file contains the definition of the PopularMoviesViewHolder class, which is a RecyclerView
 * ViewHolder responsible for displaying popular movie items in the UI.
 *
 * @file PopularMoviesViewHolder.kt
 */

package com.example.kotlin.TMBDapplication.framework.adapters.viewholders

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.kotlin.TMBDapplication.databinding.MovieCardLayoutBinding
import com.example.kotlin.TMBDapplication.domain.model.Result

/**
 * The `PopularMoviesViewHolder` class is a RecyclerView ViewHolder designed for displaying popular
 * movie items within the user interface.
 *
 * @param binding The data binding for the movie card layout.
 */
class PopularMoviesViewHolder(private val binding: MovieCardLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    /**
     * Binds movie data to the ViewHolder to populate the UI.
     *
     * @param item The `Result` object representing a movie.
     * @param context The context used for loading images.
     */
    fun bind(item: Result, context: Context) {
        binding.movieName.text = item.title
        binding.movieDescription.text = item.overview
        val urlImage = "https://image.tmdb.org/t/p/original${item.poster_path}"

        // Define the image loading options
        val requestOptions = RequestOptions()
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .fitCenter()
            .priority(Priority.HIGH)

        // Load the movie image using Glide with the specified options
        Glide.with(context).load(urlImage)
            .apply(requestOptions)
            .into(binding.movieImage)
    }
}
