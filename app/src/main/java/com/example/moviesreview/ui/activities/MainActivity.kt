package com.example.moviesreview.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.moviesreview.R
import com.google.android.material.bottomnavigation.BottomNavigationView

var isChangeLikedFilmList = true
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainBottomNavigation = findViewById<BottomNavigationView>(R.id.mainBottomNavigation)
        val navController = findNavController(R.id.mainFrameLayout)
        mainBottomNavigation.setupWithNavController(navController)
    }
}