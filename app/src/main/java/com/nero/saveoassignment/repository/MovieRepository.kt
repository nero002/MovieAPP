package com.nero.saveoassignment.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.nero.saveoassignment.data.remote.MovieClient
import com.nero.saveoassignment.utils.MoviePagingSource
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieClient: MovieClient) {


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