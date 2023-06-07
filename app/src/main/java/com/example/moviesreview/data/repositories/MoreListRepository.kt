package com.example.moviesreview.data.repositories

import android.content.Context
import com.example.moviesreview.data.database.MoviesDataBase
import com.example.moviesreview.data.elements.ShortListData
import com.example.moviesreview.data.elements.getShortListData

const val OPEN_TOP = 1
const val OPEN_FILMS = 2
const val OPEN_SERIALS = 3
const val OPEN_CATEGORY = 4

class MoreListRepository(private val context: Context) {
    private val dao = MoviesDataBase.getInstance(context).dao()
    fun getData(mode: Int, category: String?): List<ShortListData>{
        return when(mode){
            OPEN_TOP -> getTop()
            OPEN_FILMS -> getFilms()
            OPEN_SERIALS -> getSerials()
            else -> getListDataCategory(category)
        }
    }

    private fun getTop() =
        getShortListData(dao.getTopList(), context)
    private fun getFilms() =
        getShortListData(dao.getTypeList("film"), context)
    private fun getSerials() =
        getShortListData(dao.getTypeList("serial"), context)
    private fun getListDataCategory(kind: String?) =
        getShortListData(dao.getListDataCategory("%${kind}%"), context)
}