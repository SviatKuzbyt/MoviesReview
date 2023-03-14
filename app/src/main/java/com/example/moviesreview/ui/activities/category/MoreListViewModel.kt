package com.example.moviesreview.ui.activities.category

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.moviesreview.data.elements.ShortListData
import com.example.moviesreview.data.repositories.MoreListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoreListViewModel(application: Application): AndroidViewModel(application) {
    val list = MutableLiveData<List<ShortListData>>()
    val error = MutableLiveData<String>()
    private val repository = MoreListRepository(application)

    fun loadData(mode: Int, kind: String?) = viewModelScope.launch(Dispatchers.IO){
        try {
            list.postValue(
                repository.getData(mode, kind)
            )
        } catch (e: Exception){
            error.postValue(e.message)
        }

    }
}