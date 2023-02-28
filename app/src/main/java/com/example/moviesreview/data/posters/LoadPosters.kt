package com.example.moviesreview.data.posters

import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.moviesreview.data.DataStore
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.net.URL


class LoadPosters(private val context: Context) {
    private val posterList = arrayOf(
        Posters("poster0.jpg", "https://github.com/SviatKuzbyt/MoviesReview/blob/main/files%20for%20project/Posters/poster0.jpg?raw=true"),
        Posters("poster1.jpg", "https://github.com/SviatKuzbyt/MoviesReview/blob/main/files%20for%20project/Posters/poster1.jpg?raw=true"),
        Posters("poster2.jpg", "https://github.com/SviatKuzbyt/MoviesReview/blob/main/files%20for%20project/Posters/poster2.jpg?raw=true"),
        Posters("poster3.jpg", "https://github.com/SviatKuzbyt/MoviesReview/blob/main/files%20for%20project/Posters/poster3.jpg?raw=true"),
        Posters("poster4.jpg", "https://github.com/SviatKuzbyt/MoviesReview/blob/main/files%20for%20project/Posters/poster4.jpg?raw=true")
    )

    suspend fun saveFolder(){
        val cw = ContextWrapper(context)
        val directory: File = cw.getDir("posters", Context.MODE_PRIVATE)
        DataStore(context).setPosterFolder(directory.absolutePath)
    }

    fun getPosters() = try {
        posterList.forEach {
            saveImage(it.name, loadImage(it.link))
        }
        null
    } catch (e: Exception){
        e.message
    }

    private fun loadImage(link: String): Bitmap{
        val url = URL(link)
        return BitmapFactory.decodeStream(url.openConnection().getInputStream())
    }

    private fun saveImage(name: String, image: Bitmap){
        val cw = ContextWrapper(context)
        val directory: File = cw.getDir("posters", Context.MODE_PRIVATE)
        val myPath = File(directory, name)
        var fos: FileOutputStream? = null

        try {
            fos = FileOutputStream(myPath)
            image.compress(Bitmap.CompressFormat.PNG, 100, fos)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            try {
                fos?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}

data class Posters(
    val name: String,
    val link: String
)