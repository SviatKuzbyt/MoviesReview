package com.example.moviesreview.data.elements

import android.content.Context
import android.graphics.Bitmap

fun getShortListData(list: List<FullListItemData>, context: Context): List<ShortListData> {
    return list.map {
        ShortListData(
            it.id,
            it.name,
            getPosterFromAssetsInLowQuality(it.image, context),
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


data class FullListItemData(
    val id: Int,
    val name: String,
    val image: String,
    val date: String,
    val country: String,
    val kind: String,
    val type: String,
)

data class ShortListData(
    val id: Int,
    val name: String,
    val image: Bitmap?,
    val details: String,
    val type: String
)