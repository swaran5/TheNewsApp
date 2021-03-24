package com.example.thenewsapp.Model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EndPoints {
    @GET("everything")
    fun getNews(
        @Query("q") tesla : String,
        @Query("from") date : String,
        @Query("sortBy") sortBy : String,
        @Query("apikey") key: String
    ): Call<News>

}