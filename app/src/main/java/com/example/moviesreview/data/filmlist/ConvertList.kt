package com.example.moviesreview.data.filmlist

class ConvertList {
    fun getShortListItemData(list: List<FullListItemData>): List<ShortListItemData> {
        return list.map {
            ShortListItemData(
                it.id,
                it.name,
                it.image,
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