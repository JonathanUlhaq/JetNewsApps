package com.belajar.jetnewsapp.models.newsModel

data class News(
    val articles: List<Article>? = null,
    val status: String? = null,
    val totalResults: Int? = null
)