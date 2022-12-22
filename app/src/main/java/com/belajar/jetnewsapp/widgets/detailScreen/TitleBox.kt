package com.belajar.jetnewsapp.widgets.detailScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.belajar.jetnewsapp.models.newsModel.Article


@Composable
fun TitleBox(news: Article) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
    ) {
        Surface(
            color = Color.LightGray.copy(0.9F),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .width(300.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {

                Text(
                    text = news.publishedAt!!,
                    style = MaterialTheme.typography.body2
                )

                Text(
                    text = news.title!!,
                    style = MaterialTheme.typography.h3
                )

                Text(
                    text = "Published by ${news.author!!}",
                    style = MaterialTheme.typography.subtitle2,
                    fontSize = 12.sp
                )

            }
        }
    }
}