package com.belajar.jetnewsapp.widgets.detailScreen

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.belajar.jetnewsapp.models.newsModel.Article


@Composable
fun Content(
    scorllState: ScrollState,
    news: Article
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 40.dp),
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(top = 80.dp, start = 15.dp, end = 15.dp)
                .verticalScroll(scorllState, enabled = true)
        ) {


            (0..3).forEach {
                Text(
                    text = news.description!!,
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Justify
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = news.content!!,
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Justify
                )
            }

        }
    }
}

