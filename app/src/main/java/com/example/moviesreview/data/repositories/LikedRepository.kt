package com.example.moviesreview.data.repositories

import android.content.Context
import com.example.moviesreview.data.database.MoviesDataBase
import com.example.moviesreview.data.elements.getShortListData

class LikedRepository(private val context: Context) {
    private val dao = MoviesDataBase.getInstance(context).dao()

    fun getLikedFilms() = getShortListData(
        dao.getLikedFilms(), context
    )
}