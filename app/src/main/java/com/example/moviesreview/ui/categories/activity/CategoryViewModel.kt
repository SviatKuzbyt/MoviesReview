package com.example.moviesreview.ui.categories.activity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.moviesreview.data.elements.ShortListItemData
import com.example.moviesreview.data.repositories.getListDataCategory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoryViewModel(private val application: Application): AndroidViewModel(application) {
    val list = MutableLiveData<List<ShortListItemData>>()
    val error = MutableLiveData<String>()

    fun loadData(kind: String, type: String) = viewModelScope.launch(Dispatchers.IO){
        try {
            list.postValue(
                getListDataCategory(kind, type, application)
            )
        } catch (e: Exception){
            error.postValue(e.message)
        }

    }

}