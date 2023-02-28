package com.example.moviesreview.data.repositories

import android.content.Context
import com.example.moviesreview.data.DataStore
import com.example.moviesreview.data.database.MoviesDataBase
import com.example.moviesreview.data.filmlist.ConvertList

import com.example.moviesreview.data.filmlist.ShortListItemData

class HomeRepository(private val context: Context) {
    private val dao = MoviesDataBase.getInstance(context).dao()
    private lateinit var postersFolder: String

    suspend fun getPosterFolder(){
        postersFolder = DataStore(context).getPostersFolder()
    }

    fun getFilms(isTop: Boolean): List<ShortListItemData> {
        return ConvertList(postersFolder).getShortListItemData(dao.getListData(isTop))
    }
}