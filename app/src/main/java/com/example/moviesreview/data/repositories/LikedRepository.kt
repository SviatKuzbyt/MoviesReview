package com.example.moviesreview.data.repositories

import android.content.Context
import com.example.moviesreview.data.database.MoviesDataBase
import com.example.moviesreview.data.elements.ConvertList

class LikedRepository(context: Context) {
    private val dao = MoviesDataBase.getInstance(context).dao()
    private val convertList = ConvertList(context)

    fun getLikedFilms() = convertList.getShortListItemData(
        dao.getLikedFilms()
    )
}