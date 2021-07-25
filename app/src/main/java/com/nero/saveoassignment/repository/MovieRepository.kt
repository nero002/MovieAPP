package com.nero.saveoassignment.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.nero.moviereview.utils.Resource
import com.nero.saveoassignment.data.model.MovieResponse
import com.nero.saveoassignment.data.remote.MovieClient
import com.nero.saveoassignment.utils.Constants.START_PAGE
import com.nero.saveoassignment.utils.MoviePagingSource
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieClient: MovieClient) {

    suspend fun getMovies(): Resource<MovieResponse> {
        val response = try {
            movieClient.movieList(START_PAGE)
        } catch (e: Exception) {
            return Resource.Error("${e.localizedMessage}")
        }
        return Resource.Success(response)
    }

    fun getSearchResults() =
        Pager(
            config = PagingConfig(
                pageSize = 10,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { MoviePagingSource(movieClient) }
        ).liveData
}