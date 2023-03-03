package com.example.moviesreview.data.elements

import android.content.Context
import android.graphics.drawable.Drawable
import java.io.InputStream

fun getPosterFromAssets(fileName: String, context: Context): Drawable? {
    return try {
        val ims: InputStream = context.assets.open("posters/$fileName")
        return Drawable.createFromStream(ims, null)
        }
    catch (e: Exception) {
        null
    }
}