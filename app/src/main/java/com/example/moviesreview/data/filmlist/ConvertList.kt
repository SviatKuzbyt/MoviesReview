package com.example.moviesreview.data.filmlist

import android.content.Context
import com.example.moviesreview.data.DataStore
import com.example.moviesreview.data.posters.loadImageFromStorage

class ConvertList(private val postersFolder: String) {


    fun getShortListItemData(list: List<FullListItemData>): List<ShortListItemData> {
        return list.map {
            ShortListItemData(
                it.id,
                it.name,
                loadImageFromStorage(it.image, postersFolder),
                makeDetailText(it),
                it.type
            )
        }
    }


    private fun makeDetailText(listItem: FullListItemData): String {
        return "${cutYearFromDate(listItem.date)}, ${listItem.country}, ${listItem.kind}"
    }

    private fun cutYearFromDate(date: String): String {
        return date.takeLast(4)
    }
}