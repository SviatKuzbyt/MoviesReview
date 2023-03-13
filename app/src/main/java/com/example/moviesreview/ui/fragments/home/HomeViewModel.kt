package com.example.moviesreview.ui.fragments.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.moviesreview.data.elements.ShortListItemData
import com.example.moviesreview.data.repositories.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(application: Application): AndroidViewModel(application) {
    val topFilmList = MutableLiveData<List<ShortListItemData>>()
    val otherFilmList = MutableLiveData<List<ShortListItemData>>()
    val error = MutableLiveData<String>()
    private val repository = HomeRepository(application)

//    init {
//        viewModelScope.launch(Dispatchers.IO){
//            try {
//                loadTopFilmList()
//                loadOtherFilmList()
//            } catch (e: Exception){
//                error.postValue("Error: ${e.message}")
//            }
//        }
//    }
//
//    private fun loadTopFilmList(){
//        topFilmList.postValue(repository.getFilms(true))
//    }
//
//    private fun loadOtherFilmList(){
//        otherFilmList.postValue(repository.getFilms(false))
//    }
}