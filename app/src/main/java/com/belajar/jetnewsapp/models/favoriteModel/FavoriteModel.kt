package com.belajar.jetnewsapp.models.favoriteModel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fav_tb")
data class FavoriteModel(
    @PrimaryKey
    @ColumnInfo(name ="title")
    val title:String,
    @ColumnInfo(name ="author")
    val author:String,
    @ColumnInfo(name ="desc")
    val desc:String,
    @ColumnInfo(name ="image")
    val image:String,
    @ColumnInfo(name ="index")
    val index:Int,
    @ColumnInfo(name ="publishedAt")
    val publishedAt:String,
    @ColumnInfo(name ="search")
    val search:String
)
