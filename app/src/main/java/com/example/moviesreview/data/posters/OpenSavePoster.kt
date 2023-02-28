package com.example.moviesreview.data.posters

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import java.io.InputStream


fun loadPoster(fileName: String, context: Context): Drawable? {
    return try {
        val ims: InputStream = context.assets.open("posters/$fileName")
        return Drawable.createFromStream(ims, null)
        }
    catch (e: Exception) {
        Log.e("loadImageFromStorage", e.message.toString() + fileName)
        null
    }
}