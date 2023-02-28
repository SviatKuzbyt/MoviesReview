package com.example.moviesreview.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.moviesreview.ui.dataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class DataStore(val context: Context) {
    private val postersFolder = stringPreferencesKey("postersFolder")

    suspend fun getPostersFolder():String{
        return  context.dataStore.data.map {
            it[postersFolder] ?: ""
        }.first()
    }

    suspend fun setPosterFolder(nameFolder: String){
        context.dataStore.edit {
            it[postersFolder] = nameFolder
        }
    }
}