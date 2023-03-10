package com.example.moviesreview.data.database

import androidx.room.Dao
import androidx.room.Query
import com.example.moviesreview.data.elements.FullListItemData

@Dao
interface MoviesDao {
    @Query("SELECT * FROM Movies")
    fun getData(): List<Movies>

    @Query("SELECT id, name, image, date, country, kind, type FROM Movies WHERE isTop=1 LIMIT 3")
    fun getTopLimitList(): List<FullListItemData>

    @Query("SELECT id, name, image, date, country, kind, type FROM Movies WHERE isTop=1")
    fun getTopList(): List<FullListItemData>
    @Query("SELECT id, name, image, date, country, kind, type FROM Movies WHERE type=:type LIMIT 3")
    fun getTypeLimitList(type: String): List<FullListItemData>

    @Query("SELECT id, name, image, date, country, kind, type FROM Movies WHERE type=:type")
    fun getTypeList(type: String): List<FullListItemData>

    @Query("SELECT * FROM Movies WHERE id=:id LIMIT 1")
    fun getInformation(id: Int): Movies

    @Query("UPDATE movies SET followed=:isFollowed WHERE id=:id")
    fun updateFollowed(isFollowed: Boolean, id: Int)

    @Query("SELECT id, name, image, date, country, kind, type FROM Movies WHERE name LIKE :search")
    fun getListDataSearch(search: String): List<FullListItemData>

    @Query("SELECT id, name, image, date, country, kind, type FROM Movies WHERE kind LIKE :kind")
    fun getListDataCategory(kind: String): List<FullListItemData>

    @Query("SELECT id, name, image, date, country, kind, type FROM Movies WHERE followed=1")
    fun getLikedFilms(): List<FullListItemData>
}