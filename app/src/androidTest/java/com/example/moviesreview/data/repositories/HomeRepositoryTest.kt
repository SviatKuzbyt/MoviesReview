package com.example.moviesreview.data.repositories

import androidx.test.platform.app.InstrumentationRegistry
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
    fun getTopFilms(){
        val list = homeRepository.getFilms(true)
        println("Result: $list")
    }

    @Test
    fun getOtherList(){
        val list = homeRepository.getFilms(false)
        println("Result: $list")
    }
}