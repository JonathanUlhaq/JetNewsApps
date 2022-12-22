package com.belajar.jetnewsapp.repositories

import com.belajar.jetnewsapp.data.FavDAO
import com.belajar.jetnewsapp.models.favoriteModel.FavoriteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FavRepository @Inject constructor(private val dao:FavDAO) {
    fun getAllFavorite():Flow<List<FavoriteModel>> = dao.getAllFav().flowOn(Dispatchers.IO).conflate()
    fun getFavbyTitle(title:String):Flow<List<FavoriteModel>> = dao.getAllFavbyTitle(title).flowOn(Dispatchers.IO).conflate()
    suspend fun addFavorite(fav:FavoriteModel) = dao.addFavorite(fav)
    suspend fun deleteAll() = dao.deleteAll()
    suspend fun deleteFavorite(fav: FavoriteModel) = dao.deleteFavorite(fav)
    }