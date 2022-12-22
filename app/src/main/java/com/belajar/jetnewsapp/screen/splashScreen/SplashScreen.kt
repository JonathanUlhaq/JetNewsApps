package com.belajar.jetnewsapp.screen.splashScreen

import android.view.animation.OvershootInterpolator
import com.belajar.jetnewsapp.R
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.belajar.jetnewsapp.navigation.NavRoute
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
) {
    val scale = remember {
        Animatable(0F)
    }

    LaunchedEffect(key1 = true, block = {
        scale.animateTo(
            targetValue = 0.8F,
            animationSpec = tween(
                2000,
                easing = {
                    OvershootInterpolator(0.8F)
                        .getInterpolation(it)
                },
            )
        )
        delay(1000)
        navController.navigate(NavRoute.Home.route)
    })
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .scale(scale.value),
    ) {
        Surface(
            shape = CircleShape,
            modifier = Modifier
                .size(230.dp),
            color = Color.Transparent
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(1.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Info",
                    modifier = Modifier.size(100.dp),
                    tint = MaterialTheme.colors.primary
                )

                Text(
                    text = "News is news",
                    color = Color.LightGray,
                    style = MaterialTheme.typography.h3
                )
            }
        }
    }
}