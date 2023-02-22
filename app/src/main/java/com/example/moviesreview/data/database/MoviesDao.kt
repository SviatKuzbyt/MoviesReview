package com.example.moviesreview.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.moviesreview.data.filmlist.FullListItemData

@Dao
interface MoviesDao {
    //temp
    @Query("SELECT * FROM Movies")
    fun getData(): List<Movies>
    @Insert
    fun addData(data: Movies)

    @Query("SELECT id, name, image, date, country, kind, type FROM Movies WHERE isTop=:isTop")
    fun getListData(isTop: Boolean): List<FullListItemData>

    @Query("SELECT * FROM Movies WHERE id=:id LIMIT 1")
    fun getInformation(id: Int): Movies

    @Query("UPDATE movies SET followed=:isFollowed WHERE id=:id")
    fun updateFollowed(isFollowed: Boolean, id: Int)

}