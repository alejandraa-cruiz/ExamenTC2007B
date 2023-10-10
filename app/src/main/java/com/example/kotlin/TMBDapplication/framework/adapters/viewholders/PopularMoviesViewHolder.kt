package com.example.kotlin.TMBDapplication.framework.adapters.viewholders


import android.content.Context
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.kotlin.TMBDapplication.databinding.MovieCardLayoutBinding
import com.example.kotlin.TMBDapplication.domain.model.Result

class PopularMoviesViewHolder(private val binding: MovieCardLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Result, context: Context){
            binding.movieName.text = item.title
            val urlImage = "https://image.tmdb.org/t/p/original${item.poster_path}"
            //Log.d("Salida",urlImage)
            val requestOptions =  RequestOptions()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .priority(Priority.HIGH)

            Glide.with(context).load(urlImage)
                .apply(requestOptions)
                .into(binding.movieImage)
        }




}