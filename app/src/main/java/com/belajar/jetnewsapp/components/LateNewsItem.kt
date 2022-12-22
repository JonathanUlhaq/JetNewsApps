package com.belajar.jetnewsapp.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.belajar.jetnewsapp.models.newsModel.Article

@Composable
fun LateNewsItem(
    news:Article,
    modifier: Modifier
) {
    Card(
        modifier = modifier
            .width(321.dp)
            .height(200.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box{
            AsyncImage(model = news.urlToImage,
                contentDescription = "image",
                contentScale = ContentScale.Crop)
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(0.3F)))
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 20.dp, end = 20.dp)
            ) {
                Text(text = "Author: ${news.publishedAt}",
                    style = MaterialTheme.typography.body2,
                    color = Color.White)
                news.title?.let {
                    Text(text = it,
                        style = MaterialTheme.typography.h3,
                        color = Color.White)
                }
            }
        }
    }
    }