package com.belajar.jetnewsapp.widgets.detailScreen

import android.content.Context
import android.widget.Toast
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import com.belajar.jetnewsapp.models.favoriteModel.FavoriteModel
import com.belajar.jetnewsapp.models.newsModel.Article
import com.belajar.jetnewsapp.screen.detailNews.DetailNewsViewModel


@Composable
fun DetailFAB(
    news: Article?,
    isNotEmpty: MutableState<Boolean>,
    vm: DetailNewsViewModel,
    context: Context,
    colors: Color,
    index:Int,
    publish:String,
    search:String
) {
    FloatingActionButton(
        backgroundColor = Color.White,
        onClick = {
            if (news != null) {
                if (isNotEmpty.value) {
                    vm.deleteFavorite(
                        FavoriteModel(
                            title = news.title!!,
                            author = news.author!!,
                            desc = news.description!!,
                            image = news.urlToImage!!,
                            index = index,
                            publish,
                            search
                        )
                    )
                    Toast.makeText(context, "Berhasil dihapus", Toast.LENGTH_SHORT).show()
                } else {
                    vm.addFavorite(
                        FavoriteModel(
                            title = news.title!!,
                            author = news.author!!,
                            desc = news.description!!,
                            image = news.urlToImage!!,
                            index = index,
                            publish,
                            search
                        )
                    )
                    Toast.makeText(context, "Berhasil ditambahkan", Toast.LENGTH_SHORT).show()
                }
            }
        }) {
        Icon(
            imageVector = if (isNotEmpty.value) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
            contentDescription = "Favorite",
            tint = colors
        )
    }
}