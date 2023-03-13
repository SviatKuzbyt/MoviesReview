package com.example.moviesreview.data.repositories

import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert
import org.junit.Before
import org.junit.Test

internal class HomeRepositoryTest{
    lateinit var homeRepository: HomeRepository
    @Before
    fun setup() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        homeRepository = HomeRepository(appContext)
    }

    @Test
    fun checkGetHomeList(){
        val list = homeRepository.getData()
        Assert.assertNotEquals(list, emptyList<HomeListData>())
        println("RESULT: $list")
    }

}