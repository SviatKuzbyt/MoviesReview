package com.example.moviesreview.ui.detail

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.lifecycle.*
import com.example.moviesreview.data.repositories.DetailRepository
import com.example.moviesreview.data.repositories.MainInformation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DetailViewModel(application: Application, private val id: Int): ViewModel()   {
    val imagePoster = MutableLiveData<Drawable?>()
    val label = MutableLiveData<String>()
    val link = MutableLiveData<String>()
    val trailerLink = MutableLiveData<String>()
    val isFollowed = MutableLiveData<Boolean>()
    val mainInformation = MutableLiveData<List<MainInformation>>()
    val description = MutableLiveData<String>()

    private val repository = DetailRepository(id, application)

    init {
        loadData()
    }

    private fun loadData() = viewModelScope.launch(Dispatchers.IO){
        val information = repository.getInformation()

        imagePoster.postValue(information.image)
        label.postValue(information.name)
        link.postValue(information.link)
        trailerLink.postValue(information.linkTrailer)
        isFollowed.postValue(information.isFollowed)
        mainInformation.postValue(information.mainInformation)
        description.postValue(information.descriptor)
    }

    fun updateFollowed(isFollowed: Boolean) = viewModelScope.launch(Dispatchers.IO){
        repository.updateFollowed(isFollowed)
    }

    fun getId() = id
}

