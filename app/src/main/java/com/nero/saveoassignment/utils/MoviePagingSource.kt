package com.nero.saveoassignment.utils


import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.nero.saveoassignment.data.model.MovieResponseItem
import com.nero.saveoassignment.data.remote.MovieClient
import com.nero.saveoassignment.utils.Constants.START_PAGE


class MoviePagingSource(
    private val movieClient: MovieClient
) : PagingSource<Int, MovieResponseItem>() {
    override fun getRefreshKey(state: PagingState<Int, MovieResponseItem>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieResponseItem> {
        val postion = params.key ?: START_PAGE
        Log.d("hello","asd" )
        return try {
            val response = movieClient.movieList(postion)
            LoadResult.Page(
                data = response,
                prevKey = if (postion == START_PAGE) null else postion - 1,
                nextKey = if (response.isEmpty()) null else postion + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}