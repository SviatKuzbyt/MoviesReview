package com.example.moviesreview.data.posters

import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


internal class LoadPostersTest{
    lateinit var loadPosters: LoadPosters

    @Before
    fun setup() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        loadPosters = LoadPosters(appContext)
    }

    @Test
    fun checkLoadImages(): Unit = runBlocking {
        launch {
            loadPosters.getPosters()
        }
    }

    @Test
    fun checkSetFolder(): Unit = runBlocking {
        launch {
            loadPosters.saveFolder()
        }
    }
}