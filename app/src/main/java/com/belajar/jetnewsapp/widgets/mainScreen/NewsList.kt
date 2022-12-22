package com.belajar.jetnewsapp.widgets.mainScreen

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.belajar.jetnewsapp.components.NewsItem
import com.belajar.jetnewsapp.models.newsModel.Article
import com.belajar.jetnewsapp.models.newsModel.News
import com.belajar.jetnewsapp.utils.StatePercent


@Composable
fun NewsList(
    homeState: News,
    state: LazyListState,
    percent: MutableState<Float?>,
    onClick:(Int) -> Unit
) {

        percent.value = homeState.articles?.let {
        StatePercent().percent(
        it.size,
        state.firstVisibleItemIndex,
        state.layoutInfo.visibleItemsInfo.size
    )
    }

    if (homeState.articles != null) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            content = {
                itemsIndexed(homeState.articles) { index,item ->
                    NewsItem(article = item) {
                        onClick.invoke(index)
                    }
                }
            },
            state = state
        )
    } else {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally),
            color = Color.Transparent
        ) {
            CircularProgressIndicator()
        }
    }
}