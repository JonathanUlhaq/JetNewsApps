package com.belajar.jetnewsapp.screen.detailNews

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belajar.jetnewsapp.models.favoriteModel.FavoriteModel
import com.belajar.jetnewsapp.models.newsModel.News
import com.belajar.jetnewsapp.repositories.FavRepository
import com.belajar.jetnewsapp.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailNewsViewModel @Inject constructor(private val repository: Repository,private val favRepo:FavRepository): ViewModel() {
    private val _uiState = MutableStateFlow(News())
    val uiState = _uiState.asStateFlow()

    fun addFavorite(fav:FavoriteModel) {
        viewModelScope.launch {
            favRepo.addFavorite(fav)
        }
    }

    fun deleteAll() {
        viewModelScope.launch {
            favRepo.deleteAll()
        }
    }

    fun deleteFavorite(fav:FavoriteModel) {
        viewModelScope.launch {
            favRepo.deleteFavorite(fav)
        }
    }

    fun getFavByTitle(title:String,isNotEmpty:MutableState<Boolean>) {
        viewModelScope.launch {
            favRepo.getFavbyTitle(title).distinctUntilChanged().collect {
                item ->
                isNotEmpty.value = !item.isEmpty()
            }
        }
    }

    fun getAllNews(search:String,context: Context) {
        viewModelScope.launch {
            try {
                _uiState.value =   repository.getNews(search)

            } catch (e:Exception) {
                Toast.makeText(context,"Waktu request habis", Toast.LENGTH_SHORT).show()
            }
        }
    }
}