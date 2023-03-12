package com.example.moviesreview.data.repositories

import android.content.Context
import com.example.moviesreview.data.database.MoviesDataBase
import com.example.moviesreview.data.elements.ConvertList
import com.example.moviesreview.data.elements.ShortListItemData

fun getListDataCategory(kind: String, context: Context): List<ShortListItemData> {
    val convertList = ConvertList(context)
    val dao = MoviesDataBase.getInstance(context).dao()
    val list = dao.getListDataCategory("%${kind}%")
    return convertList.getShortListItemData(list)
}