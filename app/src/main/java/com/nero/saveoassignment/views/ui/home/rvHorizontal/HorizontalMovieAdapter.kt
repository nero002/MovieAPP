package com.nero.saveoassignment.views.ui.home.rvHorizontal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nero.saveoassignment.R
import com.nero.saveoassignment.data.model.MovieResponseItem
import com.nero.saveoassignment.data.remote.MovieClickListener


class HorizontalMovieAdapter(
    private val movieList: MutableList<MovieResponseItem>,
    private val itemClickListener: MovieClickListener
) : RecyclerView.Adapter<HorizontalMovieViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalMovieViewHolder {
        val view: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.horizontal_movie_item_view, parent, false)
        return HorizontalMovieViewHolder(view, itemClickListener)
    }

    override fun onBindViewHolder(holder: HorizontalMovieViewHolder, position: Int) {
        val movieList = movieList[position]
        holder.setMovieData(movieList)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

}



