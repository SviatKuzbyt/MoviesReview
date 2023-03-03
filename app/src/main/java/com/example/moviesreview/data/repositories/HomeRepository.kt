package com.example.moviesreview.data.repositories

import android.content.Context
import com.example.moviesreview.data.database.MoviesDataBase
import com.example.moviesreview.data.elements.ConvertList

import com.example.moviesreview.data.elements.ShortListItemData

class HomeRepository(private val context: Context) {
    private val dao = MoviesDataBase.getInstance(context).dao()

    fun getFilms(isTop: Boolean): List<ShortListItemData> {
        return ConvertList(context).getShortListItemData(dao.getListData(isTop))
    }
}