package com.example.moviesreview.data.posters

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import java.io.File
import java.io.FileInputStream


fun loadImageFromStorage(fileName: String, folderName: String): Bitmap? {
    return try {
        val file = File(folderName, fileName)
        BitmapFactory.decodeStream(FileInputStream(file))
    } catch (e: Exception) {
        Log.e("loadImageFromStorage", e.message.toString() + fileName)
        null
    }
}