package com.example.moviesreview.data.repositories

import android.content.Context
import com.example.moviesreview.data.database.MoviesDataBase

import com.example.moviesreview.data.elements.ShortListData
import com.example.moviesreview.data.elements.getShortListData

class HomeRepository(private val context: Context) {
    private val dao = MoviesDataBase.getInstance(context).dao()

    fun getData(): List<HomeListData>{
        val descriptions = listOf("Top", "Films", "Serials")
        val lists = listOf(getTopList(), getFilmList(), getSerialList())
        val modes = listOf(OPEN_TOP, OPEN_FILMS, OPEN_SERIALS)
        return convertList(descriptions, lists, modes)
    }

    private fun getTopList() =
        getShortListData(dao.getTopLimitList(), context)
    private fun getFilmList() =
        getShortListData(dao.getTypeLimitList("film"), context)
    private fun getSerialList() =
        getShortListData(dao.getTypeLimitList("serial"), context)

    private fun convertList(
        descriptions: List<String>,
        lists: List<List<ShortListData>>,
        modes: List<Int>,
    ): List<HomeListData>{
        return descriptions.indices.map { i ->
            HomeListData(descriptions[i], lists[i], modes[i])
        }
    }
}

data class HomeListData(
    val description: String,
    val list: List<ShortListData>,
    val openMode: Int
)