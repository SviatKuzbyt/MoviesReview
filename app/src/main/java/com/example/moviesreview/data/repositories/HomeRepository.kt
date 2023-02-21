package com.example.moviesreview.data.repositories

import android.content.Context
import com.example.moviesreview.data.database.MoviesDataBase
import com.example.moviesreview.data.filmlist.ConvertList

import com.example.moviesreview.data.filmlist.ShortListItemData

class HomeRepository(context: Context) {
    private val dao = MoviesDataBase.getInstance(context).dao()

    fun getFilms(isTop: Boolean): List<ShortListItemData> {
        return ConvertList().getShortListItemData(dao.getListData(isTop))
    }
}