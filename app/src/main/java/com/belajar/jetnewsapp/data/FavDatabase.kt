package com.belajar.jetnewsapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.belajar.jetnewsapp.models.favoriteModel.FavoriteModel


@Database(entities = [FavoriteModel::class], version = 4)
abstract class FavDatabase:RoomDatabase() {
    abstract fun favDAO():FavDAO
}