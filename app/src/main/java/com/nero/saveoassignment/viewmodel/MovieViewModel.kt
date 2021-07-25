package com.nero.saveoassignment.viewmodel

import androidx.lifecycle.ViewModel
import com.nero.saveoassignment.repository.MovieRepository
import javax.inject.Inject

class MovieViewModel @Inject constructor(private val movieRepository: MovieRepository) :
    ViewModel() {


}