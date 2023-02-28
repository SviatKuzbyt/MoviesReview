package com.example.moviesreview.data.filmlist

import android.graphics.drawable.Drawable

data class ShortListItemData(
    val id: Int,
    val name: String,
    val image: Drawable?,
    val details: String,
    val type: String
)