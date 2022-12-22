package com.belajar.jetnewsapp.widgets.mainScreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SeeRow() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp)
    ) {
        Text(text = "Latest News",
            style = MaterialTheme.typography.h1,
            fontSize = 18.sp)

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "See All",
                style = MaterialTheme.typography.subtitle2)
            Spacer(modifier = Modifier.width(12.dp))
            Icon(imageVector = Icons.Default.KeyboardArrowRight ,
                contentDescription = "right" )
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}