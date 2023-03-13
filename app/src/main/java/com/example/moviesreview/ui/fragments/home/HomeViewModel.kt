package com.example.moviesreview.ui.fragments.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.moviesreview.data.repositories.HomeListData
import com.example.moviesreview.data.repositories.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(application: Application): AndroidViewModel(application) {
    val homeList = MutableLiveData<List<HomeListData>>()
    val error = MutableLiveData<String>()
    private val repository = HomeRepository(application)

    init {
        loadData()
    }

    private fun loadData() = viewModelScope.launch(Dispatchers.IO){
        try {
            homeList.postValue(repository.getData())
        } catch (e: Exception){
            error.postValue(e.message)
        }
    }
}