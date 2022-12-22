package com.belajar.jetnewsapp.repositories

import com.belajar.jetnewsapp.models.newsModel.News
import com.belajar.jetnewsapp.network.NewsAPI
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val api: NewsAPI) {
    suspend fun getNews(search: String): News = api.getNews(search)
}