package com.nero.saveoassignment.views.ui.home.rvHorizontal

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nero.saveoassignment.data.model.MovieResponseItem
import com.nero.saveoassignment.data.remote.MovieClickListener
import com.nero.saveoassignment.databinding.HorizontalMovieItemViewBinding

class HorizontalMovieViewHolder(
    private val itemView: View,
    private val movieClickListener: MovieClickListener
) : RecyclerView.ViewHolder(itemView) {

    val binding = HorizontalMovieItemViewBinding.bind(itemView)

    fun setMovieData(movieRepository: MovieResponseItem) {
        binding.apply {

            Glide.with(ivMoviePosterHorizontal).load(movieRepository.image.original).into(ivMoviePosterHorizontal)



        }


    }
}