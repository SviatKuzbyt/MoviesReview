package com.example.moviesreview.data.filmlist

import android.content.Context
import com.example.moviesreview.data.posters.loadPoster

class ConvertList(private val context: Context) {


    fun getShortListItemData(list: List<FullListItemData>): List<ShortListItemData> {
        return list.map {
            ShortListItemData(
                it.id,
                it.name,
                loadPoster(it.image, context),
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