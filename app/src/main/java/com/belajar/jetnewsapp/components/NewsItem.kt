package com.belajar.jetnewsapp.components

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.belajar.jetnewsapp.models.newsModel.Article

@Composable
fun NewsItem(
    article: Article,
    onClick:() -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(128.dp)
            .padding(bottom = 8.dp, start = 15.dp, end = 15.dp )
            .clickable {
                       onClick.invoke()
            },
        shape = RoundedCornerShape(8.dp)
    ) {
        Box {
            AsyncImage(model = article.urlToImage,
                contentDescription = "image news",
                contentScale = ContentScale.Crop)

            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(0.4F)))
            
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(CenterHorizontally),
                    color = Color.Transparent
                ) {
                    article.title?.let {
                        Text(text = it,
                            style = MaterialTheme.typography.h3,
                            fontSize = 14.sp,
                            color = Color.White)
                    }
                }

                Spacer(modifier = Modifier.weight(1F))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    article.author?.let {
                        Text(text = it,
                            style = MaterialTheme.typography.subtitle2,
                            color = Color.White)
                    }
                    Spacer(modifier = Modifier.weight(1F))
                    article.publishedAt?.let {
                        Text(text = it,
                            style = MaterialTheme.typography.subtitle2,
                            color = Color.White)
                    }
                }
            }
        }
    }
}