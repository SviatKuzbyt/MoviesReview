package com.example.moviesreview.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.moviesreview.R
import com.example.moviesreview.data.database.MoviesDataBase
import com.google.android.material.bottomnavigation.BottomNavigationView

val Context.dataStore by preferencesDataStore(name = "dataStore")

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainBottomNavigation = findViewById<BottomNavigationView>(R.id.mainBottomNavigation)
        val navController = findNavController(R.id.mainFrameLayout)
        mainBottomNavigation.setupWithNavController(navController)
    }

}