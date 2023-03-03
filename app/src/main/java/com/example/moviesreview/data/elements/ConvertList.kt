package com.example.moviesreview.data.elements

import android.content.Context
import android.graphics.drawable.Drawable

class ConvertList(private val context: Context) {

    fun getShortListItemData(list: List<FullListItemData>): List<ShortListItemData> {
        return list.map {
            ShortListItemData(
                it.id,
                it.name,
                getPosterFromAssets(it.image, context),
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

data class FullListItemData(
    val id: Int,
    val name: String,
    val image: String,
    val date: String,
    val country: String,
    val kind: String,
    val type: String,
)

data class ShortListItemData(
    val id: Int,
    val name: String,
    val image: Drawable?,
    val details: String,
    val type: String
)