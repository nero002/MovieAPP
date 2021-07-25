package com.nero.saveoassignment.data.remote

import android.os.Bundle
import com.nero.saveoassignment.data.model.MovieResponseItem
import java.util.*

interface MovieClickListener {
    fun onMovieClicked(movieResponse: MovieResponseItem)
}
