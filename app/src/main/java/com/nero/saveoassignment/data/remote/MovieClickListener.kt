package com.nero.saveoassignment.data.remote

import com.nero.saveoassignment.data.model.MovieResponseItem

interface MovieClickListener {
    fun onMovieClicked(movieResponse: MovieResponseItem)
}
