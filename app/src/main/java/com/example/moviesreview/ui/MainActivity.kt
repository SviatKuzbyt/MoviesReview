package com.example.moviesreview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.moviesreview.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainBottomNavigation = findViewById<BottomNavigationView>(R.id.mainBottomNavigation)
        val navController = findNavController(R.id.mainFrameLayout)
        mainBottomNavigation.setupWithNavController(navController)
        Log.v("imageID", R.drawable.poster0.toString() )
        Log.v("imageID", R.drawable.poster1.toString() )
        Log.v("imageID", R.drawable.poster2.toString() )
        Log.v("imageID", R.drawable.poster3.toString() )
        Log.v("imageID", R.drawable.poster4.toString() )

    }
}


//bottomNavigationView = findViewById(R.id.bottomNavigationView)
//navController = findNavController(R.id.fragmentContainerSettings)
//bottomNavigationView.setupWithNavController(navController)