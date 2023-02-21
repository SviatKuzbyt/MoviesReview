package com.example.moviesreview.data.repositories

import android.content.Context
import com.example.moviesreview.data.database.MoviesDataBase
import com.example.moviesreview.data.dataclasses.ListItemData

class HomeRepository(context: Context) {
    val dao = MoviesDataBase.getInstance(context).dao()

     fun getFilms(isTop: Boolean): List<ListItemData>{
         val list = dao.getListData(isTop)
         list.forEach {
             it.date = cutYearFromDate(it.date)
         }
         return list
     }

    private fun cutYearFromDate(date: String): String{
        val length = date.length
        return date.subSequence(length-5, length-1).toString()
    }
}