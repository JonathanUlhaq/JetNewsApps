package com.belajar.jetnewsapp.screen.favoriteScreen.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.FabPosition
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.belajar.jetnewsapp.components.FavoriteItem
import com.belajar.jetnewsapp.components.TopBar
import com.belajar.jetnewsapp.navigation.NavRoute
import com.belajar.jetnewsapp.screen.favoriteScreen.viewModel.FavViewModel
import com.belajar.jetnewsapp.widgets.mainScreen.ButtonNav

@Composable
fun FavScreen(
    navController: NavController,
    vm: FavViewModel
) {

    val uiState = vm.uiState.collectAsState().value

    Scaffold (
        floatingActionButton = {
            ButtonNav(navController,1)
        },
        floatingActionButtonPosition = FabPosition.Center
            ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Favorite",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h3)
            Spacer(modifier = Modifier.height(20.dp))
            LazyColumn(content = {
                itemsIndexed(uiState) { index, item ->
                    FavoriteItem(article = item) {
                        navController.navigate(NavRoute.DetailNews.route +"/${item.search}/${item.index}")
                    }
                }
            })
        }
    }

}