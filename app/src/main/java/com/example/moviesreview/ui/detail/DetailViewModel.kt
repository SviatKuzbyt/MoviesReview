package com.example.moviesreview.ui.detail

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.lifecycle.*
import com.example.moviesreview.data.repositories.DetailData
import com.example.moviesreview.data.repositories.DetailRepository
import com.example.moviesreview.data.repositories.MainInformation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(application: Application, id: Int): ViewModel()   {
    val imagePoster = MutableLiveData<Drawable?>()
    val label = MutableLiveData<String>()
    val link = MutableLiveData<String>()
    val trailerLink = MutableLiveData<String>()
    val isFollowed = MutableLiveData<Boolean>()
    val mainInformation = MutableLiveData<List<MainInformation>>()
    val description = MutableLiveData<String>()
    val error = MutableLiveData<String>()

    private var repository = DetailRepository(id, application)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                loadData()
            }
            catch (e: Exception){
                error.postValue("Error: ${e.message}")
            }
        }
    }

    private fun loadData() {
        val information = repository.getInformation()
        postData(information)
    }

    private fun postData(information: DetailData){
        imagePoster.postValue(information.image)
        label.postValue(information.name)
        link.postValue(information.link)
        trailerLink.postValue(information.linkTrailer)
        isFollowed.postValue(information.isFollowed)
        mainInformation.postValue(information.mainInformation)
        description.postValue(information.descriptor)
    }

    fun updateFollowed() = viewModelScope.launch(Dispatchers.IO){
        try {
            val newFollow = !isFollowed.value!!
            repository.updateFollowed(newFollow)
            isFollowed.postValue(newFollow)
        } catch (e: Exception){
            error.postValue("Error: ${e.message}")
        }
    }
}