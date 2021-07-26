package com.nero.saveoassignment.views.ui.home.rvVertical

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nero.saveoassignment.data.model.MovieResponseItem
import com.nero.saveoassignment.data.remote.MovieClickListener
import com.nero.saveoassignment.databinding.ItemLayoutBinding

class MovieViewHolder(
    private val itemView: View,
    private val movieClickListener: MovieClickListener
) : RecyclerView.ViewHolder(itemView) {
    private val binding = ItemLayoutBinding.bind(itemView)

    fun setMovieData(movieRepository: MovieResponseItem) {

        binding.apply {

            Glide.with(ivMoviePoster).load(movieRepository.image.original).into(ivMoviePoster)

            cvMovie.setOnClickListener {

                movieClickListener.onMovieClicked(
                    movieRepository
                )
            }
        }


    }
}