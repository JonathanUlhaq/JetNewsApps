package com.belajar.jetnewsapp.screen.homeScreen.view

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.Top
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.belajar.jetnewsapp.components.TopBar
import com.belajar.jetnewsapp.navigation.NavRoute
import com.belajar.jetnewsapp.screen.homeScreen.viewModel.HomeViewModel
import com.belajar.jetnewsapp.screen.homeScreen.viewModel.MainViewModel
import com.belajar.jetnewsapp.utils.StatePercent
import com.belajar.jetnewsapp.widgets.mainScreen.*

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HomeScreen(
    vm: MainViewModel,
    homeVm: HomeViewModel,
    navController: NavController
) {

    val search = remember {
        mutableStateOf("")
    }

    val selected = remember {
        mutableStateOf(false)
    }

    val categoryText = remember {
        mutableStateOf("Healthy")
    }

    val statePercent = remember {
        mutableStateOf<Float?>(null)
    }

    val visible = remember {
        mutableStateOf(false)
    }

    if (statePercent.value != null) {
        visible.value = statePercent.value!! > 1
    }

    val indexSelected = remember {
        mutableStateOf(0)
    }

    val context = LocalContext.current
    val keyobard = LocalSoftwareKeyboardController.current

    val lazyState = rememberLazyListState()



    vm.getAllNews("Indonesia", context)
    val viewPagerState = vm.uiState.collectAsState().value
    val homeState = homeVm.uiState.collectAsState().value

    if (search.value.isNotEmpty()) {
        categoryText.value = search.value
    }

    homeVm.getAllNews(categoryText.value, context)

    Scaffold(
        topBar = {
            TopBar(
                title = "",
                isHomeScreen = true,
                search = search,
                color = Color.White,
                navController = navController
            ) {
                keyobard?.hide()
            }
        },
        floatingActionButton = {
            ButtonNav(navController,0)
        },
        floatingActionButtonPosition = FabPosition.Center,

    ) {
        Column(Modifier.padding(it)) {
            Spacer(modifier = Modifier.height(24.dp))
            AnimatedVisibility(
                visible = search.value.isEmpty(),
                enter = expandIn(tween(700), expandFrom = TopStart),
                exit = shrinkOut(tween(700), shrinkTowards = TopStart)
            ) {
                Column {

                    AnimatedVisibility(
                        visible = !visible.value,
                        enter = expandIn(tween(700), expandFrom = TopStart),
                        exit = shrinkOut(tween(700), shrinkTowards = TopStart)
                    ) {
                       Column {
                           SeeRow()
                           if (viewPagerState.articles != null) {
                               NewsViewPager(viewPagerState.articles)
                           } else {
                               Surface(
                                   modifier = Modifier
                                       .fillMaxWidth()
                                       .wrapContentWidth(CenterHorizontally),
                                   color = Color.Transparent
                               ) {
                                   CircularProgressIndicator()
                               }
                           }
                           Spacer(modifier = Modifier.height(24.dp))
                       }
                    }


                    Categories(vm.listCategory(), selected, indexSelected, categorySelect = categoryText)

                    Spacer(modifier = Modifier.height(24.dp))
                }
            }

            NewsList(homeState,lazyState, percent = statePercent) {
                navController.navigate(NavRoute.DetailNews.route +"/${categoryText.value}/${it}")
            }
        }
    }
}






