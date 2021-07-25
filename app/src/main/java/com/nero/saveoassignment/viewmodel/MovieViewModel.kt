package com.nero.saveoassignment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.nero.saveoassignment.data.model.MovieResponseItem
import com.nero.saveoassignment.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val movieRepository: MovieRepository) :
    ViewModel() {

    private var movieData = MutableLiveData<List<MovieResponseItem>>(listOf())

    fun movie(): MutableLiveData<List<MovieResponseItem>> {
        viewModelScope.launch {

            val result = movieRepository.getMovies()
            movieData.value = result.data!!
        }
        return movieData


    }

    val movie = movieRepository.getSearchResults().cachedIn(viewModelScope)

}