package com.belajar.jetnewsapp.screen.homeScreen.viewModel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belajar.jetnewsapp.models.newsModel.News
import com.belajar.jetnewsapp.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: Repository):ViewModel() {
    private val _uiState = MutableStateFlow(News())
    val uiState = _uiState.asStateFlow()

    fun getAllNews(search:String,context:Context) {
        viewModelScope.launch {
            try {
                    _uiState.value =   repository.getNews(search)

            } catch (e:Exception) {
                Toast.makeText(context,"Waktu request habis", Toast.LENGTH_SHORT).show()
            }
        }
    }
}