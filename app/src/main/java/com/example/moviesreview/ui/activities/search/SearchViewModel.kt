package com.example.moviesreview.ui.activities.search

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.moviesreview.data.elements.ShortListItemData
import com.example.moviesreview.data.repositories.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel(application: Application): AndroidViewModel(application) {
    val list = MutableLiveData<List<ShortListItemData>>()
    val error = MutableLiveData<String>()
    private val repository = SearchRepository(application)

    fun searchFilms(searchText: String) = viewModelScope.launch(Dispatchers.IO) {
        try {
            val result = repository.getResults(searchText)
            if (result.isEmpty()) {
                throw NoSuchElementException("Nothing found")
            } else {
                list.postValue(result)
            }
        } catch (e: NoSuchElementException) {
            error.postValue(e.message)
        } catch (e: Exception) {
            error.postValue("Something went wrong")
        }
    }
}