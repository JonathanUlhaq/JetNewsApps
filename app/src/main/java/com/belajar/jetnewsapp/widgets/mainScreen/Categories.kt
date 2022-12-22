package com.belajar.jetnewsapp.widgets.mainScreen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.belajar.jetnewsapp.components.CategoryBar


@Composable
fun Categories(
    category: List<String>,
    selected: MutableState<Boolean>,
    indexSelected: MutableState<Int>,
    categorySelect:MutableState<String>

) {
    LazyRow(modifier = Modifier
        .padding(start = 30.dp),
        content = {
            itemsIndexed(category) { index, item ->

                selected.value = indexSelected.value == index
                CategoryBar(
                    indexed = selected.value,
                    category = item
                ) {
                    indexSelected.value = index
                    categorySelect.value = item
                }
            }
        })
}