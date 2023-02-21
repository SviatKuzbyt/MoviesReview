package com.example.moviesreview.data.database

import android.content.Context
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.example.moviesreview.data.temp.InitDataBase
import org.junit.Assert
import org.junit.Before
import org.junit.Test

internal class MoviesDataBaseTest{
    lateinit var dao: MoviesDao
    @Before
    fun setup() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val dataBase = Room.databaseBuilder(appContext, MoviesDataBase::class.java, "Movies").build()
        dao = dataBase.dao()
    }

    @Test
    fun checkInsertData(){
        val initDataBase = InitDataBase(dao)
        initDataBase.addRecords()
    }

    @Test
    fun checkGetData(){
        val records = dao.getData()
        Assert.assertNotEquals(records, emptyList<Movies>())
        println("RESULT: $records")
    }
}