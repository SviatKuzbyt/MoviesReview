package com.example.moviesreview.data.dataclasses

data class ListItemData(
    val id: Int,
    val name: String,
    val image: Int,
    var date: String,
    val country: String,
    val kind: String,
    val type: String,
)