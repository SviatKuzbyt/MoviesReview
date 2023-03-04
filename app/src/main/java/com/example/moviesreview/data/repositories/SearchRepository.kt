package com.example.moviesreview.data.repositories

import android.content.Context
import com.example.moviesreview.data.database.MoviesDataBase
import com.example.moviesreview.data.elements.ConvertList
import com.example.moviesreview.data.elements.FullListItemData
import com.example.moviesreview.data.elements.ShortListItemData

class SearchRepository(context: Context) {
    private val dao = MoviesDataBase.getInstance(context).dao()
    private val convertList = ConvertList(context)

    fun getResults(searchName: String): List<ShortListItemData>{
        val list = dao.getSearchListData("%${searchName}%")
        return if(list != emptyList<FullListItemData>())
            convertList.getShortListItemData(list)
        else
            return emptyList()
    }
}