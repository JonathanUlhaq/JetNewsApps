package com.belajar.jetnewsapp.widgets.detailScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.belajar.jetnewsapp.models.newsModel.Article


@Composable
fun DetailImage(news: Article?) {
    if (news != null) {
        AsyncImage(
            model = news.urlToImage,
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
    }
}