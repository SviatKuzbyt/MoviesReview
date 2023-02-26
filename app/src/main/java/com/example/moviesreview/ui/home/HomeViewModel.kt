package com.example.moviesreview.ui.home

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.moviesreview.data.filmlist.ShortListItemData
import com.example.moviesreview.data.repositories.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(application: Application): AndroidViewModel(application) {
    val topFilmList = MutableLiveData<List<ShortListItemData>>()
    val otherFilmList = MutableLiveData<List<ShortListItemData>>()
    val error = MutableLiveData<String>()
    private val repository = HomeRepository(application)

    init {
        loadTopFilmList()
        loadOtherFilmList()
        Log.v("VM bad work" ,"is")
    }

    fun loadTopFilmList()= viewModelScope.launch(Dispatchers.IO){
        try {
            topFilmList.postValue(repository.getFilms(true))
        } catch (e: Exception){
            error.postValue("Error: ${e.message}")
        }
    }

    fun loadOtherFilmList()= viewModelScope.launch(Dispatchers.IO) {
        try {
            otherFilmList.postValue(repository.getFilms(false))
        } catch (e: Exception) {
            error.postValue("Error: ${e.message}")
        }
    }
}