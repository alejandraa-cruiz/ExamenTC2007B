/**
 * This file contains the definition of the PopularMoviesAdapter class, which is a RecyclerView Adapter
 * responsible for populating a list of popular movie items in the user interface.
 *
 * @file PopularMoviesAdapter.kt
 */

package com.example.kotlin.TMBDapplication.framework.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.TMBDapplication.databinding.MovieCardLayoutBinding
import com.example.kotlin.TMBDapplication.domain.model.Result
import com.example.kotlin.TMBDapplication.framework.adapters.viewholders.PopularMoviesViewHolder

/**
 * The `PopularMoviesAdapter` class is a RecyclerView Adapter designed for populating a list of
 * popular movie items within the user interface.
 */
class PopularMoviesAdapter : RecyclerView.Adapter<PopularMoviesViewHolder>() {

    // Declaration of a list of movie data
    var data: ArrayList<Result> = ArrayList()

    // Declaration of a property for the application context
    lateinit var context: Context

    /**
     * Custom constructor for initializing the list of movie data and the application context.
     *
     * @param basicData The list of movie data.
     * @param context The context of the application.
     */
    fun PopularMoviesAdapter(basicData: List<Result>, context: Context) {
        this.data = basicData as ArrayList<Result>
        this.context = context
    }

    /**
     * Binds the data of a list item to a row view (ViewHolder).
     *
     * @param holder The ViewHolder representing the row.
     * @param position The position of the item in the list.
     */
    override fun onBindViewHolder(holder: PopularMoviesViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, context)
    }

    /**
     * Creates a new ViewHolder that represents an item in the list.
     *
     * @param parent The parent view group in which the item will be displayed.
     * @param viewType The type of view.
     * @return A new `PopularMoviesViewHolder` instance.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMoviesViewHolder {
        // Inflate the row view layout and associate it with a binding object
        val binding = MovieCardLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularMoviesViewHolder(binding)
    }

    /**
     * Returns the total number of items in the data list.
     *
     * @return The number of items in the data list.
     */
    override fun getItemCount(): Int {
        return data.size
    }
}
