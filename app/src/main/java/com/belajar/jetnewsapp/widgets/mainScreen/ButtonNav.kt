package com.belajar.jetnewsapp.widgets.mainScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.belajar.jetnewsapp.components.NavItem
import com.belajar.jetnewsapp.navigation.NavRoute


@Composable
fun ButtonNav(
    navController: NavController,
    contentIndex: Int
) {

    val icon = listOf(
        Icons.Outlined.Home,
        Icons.Outlined.Favorite,
        Icons.Outlined.Face
    )

    val text = listOf(
        "Home",
        "Favorite",
        "Profile"
    )

    val clicked = remember {
        mutableStateOf(false)
    }

    val indexed = remember {
        mutableStateOf(contentIndex)
    }


    Surface(
        color = Color.White,
        shape = RoundedCornerShape(30.dp),
        elevation = 5.dp
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 20.dp, end = 4.dp, top = 16.dp, bottom = 8.dp)
        ) {

            icon.forEachIndexed { index, imageVector ->
                clicked.value = indexed.value == index

                NavItem(
                    desc = text[index],
                    imageVector = imageVector,
                    onClick = {
                        when (text[index]) {
                            "Home" -> {
                                navController.navigate(NavRoute.Home.route) {
                                    popUpTo(0)
                                }
                            }
                            "Favorite" -> {
                                navController.navigate(NavRoute.Favorite.route) {
                                    popUpTo(0)
                                }
                            }
                            else -> {
                                navController.navigate(NavRoute.Profile.route) {
                                    popUpTo(0)
                                }
                            }
                        }
//                        indexed.value = index
                    },
                    clickable = clicked.value
                )
                Spacer(modifier = Modifier.width(30.dp))
            }

        }
    }
}