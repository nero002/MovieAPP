package com.nero.saveoassignment.views.ui.home.rvVertical

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.nero.saveoassignment.R
import com.nero.saveoassignment.data.model.MovieResponseItem
import com.nero.saveoassignment.data.remote.MovieClickListener
import com.nero.saveoassignment.utils.DiffUtils

class MovieAdapter(private val itemClickListener: MovieClickListener) :
    PagingDataAdapter<MovieResponseItem, MovieViewHolder>(
        DiffUtils.diffUtil
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MovieViewHolder(view, itemClickListener)

    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        getItem(position)?.let { holder.setMovieData(it) }
    }

}

