package com.example.moviesreview.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movies(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val image: String,
    val followed: Boolean,
    val link: String,
    val linkTrailer: String,
    val mark: Float,
    val date: String,
    val country: String,
    val kind: String,
    val duration: String,
    val actors: String,
    val description: String,
    val type: String,
    val isTop: Boolean
)