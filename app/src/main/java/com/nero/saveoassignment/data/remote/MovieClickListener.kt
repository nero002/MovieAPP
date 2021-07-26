package com.nero.saveoassignment.data.remote

import androidx.annotation.NonNull
import com.nero.saveoassignment.data.model.MovieResponseItem
import com.nero.saveoassignment.databinding.HorizontalMovieItemViewBinding
import com.nero.saveoassignment.databinding.ItemLayoutBinding

interface MovieClickListener {
    fun onMovieClicked(movieResponse: MovieResponseItem)
}
