package com.example.moviesreview.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 1, entities = [Movies::class])
abstract class MoviesDataBase: RoomDatabase() {
    abstract fun dao(): MoviesDao

    companion object {
        @Volatile private var instance: MoviesDataBase? = null
        fun getInstance(context: Context): MoviesDataBase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): MoviesDataBase {
            return Room.databaseBuilder(context, MoviesDataBase::class.java, "movies-db")
                .createFromAsset("moviesDB.db")
                .build()
        }
    }
}