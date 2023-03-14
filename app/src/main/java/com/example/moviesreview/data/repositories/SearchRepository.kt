package com.example.moviesreview.data.repositories

import android.content.Context
import com.example.moviesreview.data.database.MoviesDataBase
import com.example.moviesreview.data.elements.ShortListData
import com.example.moviesreview.data.elements.getShortListData

class SearchRepository(private val context: Context) {
    private val dao = MoviesDataBase.getInstance(context).dao()

    fun getResults(text: String): List<ShortListData>{
        val textTrim = text.trim()

        return if (textTrim.isEmpty())
            emptyList()
        else
            loadData(textTrim)
    }

    private fun loadData(text: String): List<ShortListData>{
        val list = dao.getListDataSearch("%${text}%")
        return if (list.isNotEmpty())
            getShortListData(list, context)
        else
            emptyList()
    }
}