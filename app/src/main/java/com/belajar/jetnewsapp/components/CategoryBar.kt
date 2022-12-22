package com.belajar.jetnewsapp.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CategoryBar(
    indexed: Boolean,
    category: String,
    onClick: () -> Unit
) {

    val backgroundColor by animateColorAsState(targetValue = if (indexed) MaterialTheme.colors.primary else Color.White)
    val fontColor by animateColorAsState(targetValue = if (indexed) Color.White else Color.Black)

    IconButton(
        onClick = { onClick.invoke() },
        modifier = Modifier
            .padding(end = 16.dp)) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .border(0.5.dp, Color.LightGray, RoundedCornerShape(16.dp)),
            color = backgroundColor
        ) {
            Text(
                text = category,
                style = MaterialTheme.typography.subtitle2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
                color = fontColor
            )
        }
    }
}