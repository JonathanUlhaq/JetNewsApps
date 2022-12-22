package com.belajar.jetnewsapp.network

import com.belajar.jetnewsapp.models.newsModel.News
import com.belajar.jetnewsapp.utils.Const
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface NewsAPI {
    @GET("everything")
    suspend fun getNews(
        @Query("q")q:String,
        @Query("sortby")sortBy:String = "popularity",
        @Query("apiKey")apiKey:String = Const.API_KEY
    ):News
}