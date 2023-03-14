package com.example.moviesreview.data.repositories

import androidx.test.platform.app.InstrumentationRegistry
import com.example.moviesreview.data.elements.ShortListData
import org.junit.Assert
import org.junit.Test

internal class SearchRepositoryTest{
    @Test
    fun checkGetResults(){
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val searchRepository = SearchRepository(appContext)
        val list = searchRepository.getResults("an")

        Assert.assertNotEquals(list, emptyList<ShortListData>())
        println("RESULT: $list")
    }
}