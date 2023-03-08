package com.example.moviesreview.data.repositories

import android.content.Context
import com.example.moviesreview.data.database.MoviesDataBase
import com.example.moviesreview.data.elements.ConvertList
import com.example.moviesreview.data.elements.ShortListItemData

class SearchRepository(context: Context) {
    private val dao = MoviesDataBase.getInstance(context).dao()
    private val convertList = ConvertList(context)

    fun getResults(searchName: String): List<ShortListItemData>{
        val text = searchName.trim()
        if (text.isEmpty())
            return emptyList()

        val list = dao.getListDataSearch("%${text}%")
        return if (list.isNotEmpty())
            convertList.getShortListItemData(list)
        else
            emptyList()
    }
}