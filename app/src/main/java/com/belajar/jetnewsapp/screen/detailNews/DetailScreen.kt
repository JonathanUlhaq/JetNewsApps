package com.belajar.jetnewsapp.screen.detailNews

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.FabPosition
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.belajar.jetnewsapp.components.TopBar
import com.belajar.jetnewsapp.widgets.detailScreen.Content
import com.belajar.jetnewsapp.widgets.detailScreen.DetailFAB
import com.belajar.jetnewsapp.widgets.detailScreen.DetailImage
import com.belajar.jetnewsapp.widgets.detailScreen.TitleBox

@Composable
fun DetailScreen(
    navController: NavController,
    index: Int,
    category: String,
    vm: DetailNewsViewModel
) {
    val context = LocalContext.current
    vm.getAllNews(category, context)

    val scrollState = rememberScrollState()

    val isNotEmpty = remember {
        mutableStateOf(false)
    }



    val uiState = vm.uiState.collectAsState().value
    val news = uiState.articles?.get(index)

    val colors by animateColorAsState(targetValue = if (isNotEmpty.value) MaterialTheme.colors.primary else Color.LightGray)

    news?.title?.let { vm.getFavByTitle(it,isNotEmpty) }
    Scaffold(
        drawerBackgroundColor = Color.Transparent,
        backgroundColor = Color.Transparent,
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            if (news != null) {
                DetailFAB(news, isNotEmpty, vm, context, colors,index,news.publishedAt!!,category)
            }
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = Color.Black
        ) {
            Box(
                Modifier.padding(it)
            ) {
                DetailImage(news)
                Column {
                    if (news != null) {
                        TopBar(
                            title = "",
                            isHomeScreen = false,
                            color = Color.Transparent,
                            navController = navController
                        ) {}
                        Spacer(modifier = Modifier.height(80.dp))
                        Box {
                            Content(scrollState, news)
                            TitleBox(news)
                        }
                    }


                }
            }

        }
    }
}

