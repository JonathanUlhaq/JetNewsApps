package com.belajar.jetnewsapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import retrofit2.http.GET
import androidx.room.Query
import com.belajar.jetnewsapp.models.favoriteModel.FavoriteModel
import kotlinx.coroutines.flow.Flow

@Dao
interface FavDAO {
    @Query("SELECT * FROM fav_tb")
    fun getAllFav():Flow<List<FavoriteModel>>

    @Query("SELECT * FROM fav_tb WHERE title = :title")
    fun getAllFavbyTitle(title:String):Flow<List<FavoriteModel>>

    @Query("DELETE FROM fav_tb")
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorite(fav:FavoriteModel)

    @Delete
    suspend fun deleteFavorite(fav:FavoriteModel)

}
