package com.example.moviesreview.ui.fragments.liked

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.moviesreview.data.elements.ShortListData
import com.example.moviesreview.data.repositories.LikedRepository
import com.example.moviesreview.ui.elements.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
class LikedViewModel(application: Application): AndroidViewModel(application) {
    private val repository = LikedRepository(application)
    val list = MutableLiveData<List<ShortListData>>()
    val error = SingleLiveEvent<String>()

    fun getList() = viewModelScope.launch(Dispatchers.IO){
        try {
            list.postValue(repository.getLikedFilms())
        } catch (e: Exception){
            error.postValue(e.message)
        }
    }
}