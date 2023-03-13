package com.example.moviesreview.data.repositories

import android.content.Context
import com.example.moviesreview.data.database.MoviesDataBase
import com.example.moviesreview.data.elements.ConvertList

import com.example.moviesreview.data.elements.ShortListItemData

class HomeRepository(context: Context) {
    private val dao = MoviesDataBase.getInstance(context).dao()
    private val convertList = ConvertList(context)

    fun getData(): List<HomeListData>{
        val descriptions = listOf("Top", "Films", "Serials")
        val lists = listOf(getTopList(), getFilmList(), getSerialList())
        val modes = listOf(OPEN_TOP, OPEN_FILMS, OPEN_SERIALS)

        return convertList(descriptions, lists, modes)
    }

    private fun getTopList() = convertList.getShortListItemData(
            dao.getTopLimitList()
        )

    private fun getFilmList() = convertList.getShortListItemData(
        dao.getTypeLimitList("film")
    )

    private fun getSerialList() = convertList.getShortListItemData(
        dao.getTypeLimitList("serial")
    )

    private fun convertList(
        descriptions: List<String>,
        lists: List<List<ShortListItemData>>,
        modes: List<Int>,
    ): List<HomeListData>{
        val homeListData = mutableListOf<HomeListData>()
        for (i in descriptions.indices){
            homeListData.add(
                HomeListData(
                    descriptions[i],
                    lists[i],
                    modes[i]))
        }
        return homeListData
    }
}

data class HomeListData(
    val description: String,
    val list: List<ShortListItemData>,
    val openMode: Int
)