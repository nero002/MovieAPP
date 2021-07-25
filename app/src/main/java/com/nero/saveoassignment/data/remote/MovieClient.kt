package com.nero.saveoassignment.data.remote

import com.nero.saveoassignment.data.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieClient {

    @GET("shows")
    suspend fun movieList(
        @Query("page") page: Int
    ): MovieResponse


}