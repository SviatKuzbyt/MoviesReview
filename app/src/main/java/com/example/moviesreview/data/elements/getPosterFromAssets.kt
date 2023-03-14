package com.example.moviesreview.data.elements

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
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

fun getPosterFromAssetsInLowQuality(fileName: String, context: Context): Bitmap? {
    return try {
        val ims: InputStream = context.assets.open("posters/$fileName")
        val options = BitmapFactory.Options()
        options.inSampleSize = 2
        return BitmapFactory.decodeStream(ims, null, options)
    }
    catch (e: Exception) {
        null
    }
}