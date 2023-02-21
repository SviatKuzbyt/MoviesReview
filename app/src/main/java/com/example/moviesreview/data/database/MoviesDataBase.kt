package com.example.moviesreview.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(version = 1, entities = [Movies::class])
abstract class MoviesDataBase: RoomDatabase() {
    abstract fun dao(): MoviesDao
}