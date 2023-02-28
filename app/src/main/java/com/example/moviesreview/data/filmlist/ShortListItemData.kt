package com.example.moviesreview.data.filmlist

import android.graphics.Bitmap

data class ShortListItemData(
    val id: Int,
    val name: String,
    val image: Bitmap?,
    val details: String,
    val type: String
)