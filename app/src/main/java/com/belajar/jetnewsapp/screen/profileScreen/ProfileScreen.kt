package com.belajar.jetnewsapp.screen.profileScreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.belajar.jetnewsapp.widgets.mainScreen.ButtonNav
import com.belajar.jetnewsapp.widgets.profileScreen.Profile

@Composable
fun ProfileScreen(
    navController: NavController
) {
    Scaffold(
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            ButtonNav(navController = navController, contentIndex = 2)
        }
    ) {
        Profile(Modifier.padding(it))
    }
}
