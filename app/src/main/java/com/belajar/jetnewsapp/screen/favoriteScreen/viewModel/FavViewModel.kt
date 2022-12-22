package com.belajar.jetnewsapp.screen.favoriteScreen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belajar.jetnewsapp.models.favoriteModel.FavoriteModel
import com.belajar.jetnewsapp.repositories.FavRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavViewModel @Inject constructor(private val repo: FavRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<List<FavoriteModel>>(emptyList())
    val uiState = _uiState.asStateFlow()

    fun deleteAll() {
        viewModelScope.launch {
            repo.deleteAll()
        }
    }

    fun getAllData() {
        viewModelScope.launch {
            repo.getAllFavorite().distinctUntilChanged().collect { list ->
                if (list.isEmpty()) {
                    _uiState.value = emptyList()
                } else {
                    _uiState.value = list
                }
            }
        }
    }

    init {
        getAllData()
    }

    fun getDataByTitle(title: String) {
        viewModelScope.launch {
            repo.getFavbyTitle(title).distinctUntilChanged().collect { item ->
                if (item.isEmpty()) {
                    _uiState.value = emptyList()
                } else {
                    _uiState.value = item
                }
            }
        }
    }

    fun addFavorite(fav:FavoriteModel) {
        viewModelScope.launch {
            repo.addFavorite(fav)
        }
    }

    fun deleteFavorite(fav:FavoriteModel) {
        viewModelScope.launch {
            repo.deleteFavorite(fav)
        }
    }

}