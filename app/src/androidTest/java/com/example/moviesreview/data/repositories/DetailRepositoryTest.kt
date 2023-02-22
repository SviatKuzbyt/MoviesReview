package com.example.moviesreview.data.repositories

import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import org.junit.Test

internal class DetailRepositoryTest{
    lateinit var detailRepository: DetailRepository

    @Before
    fun setup() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        detailRepository = DetailRepository(1, appContext)
    }

    @Test
    fun checkGetInformation(){
        println("RESULT ${
            detailRepository.getInformation()
        }")
    }
}