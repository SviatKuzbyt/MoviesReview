package com.example.moviesreview.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MoviesDao {
    //temp
    @Query("SELECT * FROM Movies")
    fun getData(): List<Movies>

    @Insert
    fun addData(data: Movies)
}