package com.example.kotlin.TMBDapplication.framework.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.TMBDapplication.databinding.MovieCardLayoutBinding
import com.example.kotlin.TMBDapplication.domain.model.Result
import com.example.kotlin.TMBDapplication.framework.adapters.viewholders.PopularMoviesViewHolder

class PopularMoviesAdapter: RecyclerView.Adapter<PopularMoviesViewHolder>() {

    // Declaración de una lista de datos de Pokémon
    var data: ArrayList<Result> = ArrayList()

    // Declaración de una propiedad para el contexto de la aplicación
    lateinit var context: Context

    // Constructor personalizado para inicializar la lista de datos y el contexto
    fun PopularMoviesAdapter(basicData: List<Result>, context: Context){
        this.data = basicData as ArrayList<Result>
        this.context = context
    }

    // Enlaza los datos de un elemento de la lista con una vista de fila (ViewHolder)
    override fun onBindViewHolder(holder: PopularMoviesViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, context)
    }

    // Crea un nuevo ViewHolder que representa un elemento de la lista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMoviesViewHolder {
        // Infla el diseño de la vista de fila y lo asocia con un objeto de vinculación (binding)
        val binding = MovieCardLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularMoviesViewHolder(binding)
    }

    // Devuelve la cantidad total de elementos en la lista de datos
    override fun getItemCount(): Int {
        return data.size
    }
}