package com.example.moviesreview.data.database

import androidx.test.platform.app.InstrumentationRegistry
import com.example.moviesreview.data.elements.FullListItemData
import org.junit.Assert
import org.junit.Before
import org.junit.Test

internal class MoviesDataBaseTest{
    lateinit var dao: MoviesDao
    @Before
    fun setup() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val dataBase = MoviesDataBase.getInstance(appContext)
        dao = dataBase.dao()
    }

    @Test
    fun checkGetData(){
        val records = dao.getData()
        Assert.assertNotEquals(records, emptyList<Movies>())
        println("RESULT: $records")
    }

    @Test
    fun checkGetInformation(){
        val record = dao.getInformation(2)
        println("RESULT: $record")
    }

    @Test
    fun checkUpdateFollowed(){
        val oldRecord = dao.getInformation(1)
        val followed = !oldRecord.followed

        dao.updateFollowed(followed, 1)
        val newRecord = dao.getInformation(1)
        Assert.assertNotEquals(oldRecord.followed, newRecord.followed)
    }

    @Test
    fun checkGetSearchList(){
        val record = dao.getListDataSearch("%Hango%")
        Assert.assertNotEquals(record, emptyList<FullListItemData>())
    }
}