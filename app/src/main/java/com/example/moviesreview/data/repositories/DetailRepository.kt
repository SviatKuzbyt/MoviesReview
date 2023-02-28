package com.example.moviesreview.data.repositories

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.example.moviesreview.R
import com.example.moviesreview.data.DataStore
import com.example.moviesreview.data.database.Movies
import com.example.moviesreview.data.database.MoviesDataBase
import com.example.moviesreview.data.posters.loadImageFromStorage

class DetailRepository(private val id: Int, private val context: Context) {
    private val dao = MoviesDataBase.getInstance(context).dao()
    private lateinit var postersFolder: String

    fun getInformation(): DetailData{
        return convertToDetailData(dao.getInformation(id))
    }

    private fun convertToDetailData(movies: Movies) = DetailData(
            movies.name,
            loadImageFromStorage(movies.image, postersFolder),
            movies.link,
            movies.linkTrailer,
            movies.followed,
            makeListOfMainInformation(movies),
            movies.description
        )

    suspend fun getPosterFolder(){
        postersFolder = DataStore(context).getPostersFolder()
    }


    private fun makeListOfMainInformation(movies: Movies) = listOf(
            MainInformation(context.getString(R.string.rating) + ':', movies.mark.toString()),
            MainInformation(context.getString(R.string.date) + ':', movies.date),
            MainInformation(context.getString(R.string.country) + ':', movies.country),
            MainInformation(context.getString(R.string.genre) + ':', movies.kind),
            MainInformation(context.getString(R.string.time) + ':', movies.duration),
            MainInformation(context.getString(R.string.cast) + ':', movies.actors),
        )

    fun updateFollowed(isFollowed: Boolean){
        dao.updateFollowed(isFollowed, id)
    }
}

data class DetailData(
    val name: String,
    val image: Bitmap?,
    val link: String,
    val linkTrailer: String,
    var isFollowed: Boolean,
    val mainInformation: List<MainInformation>,
    val descriptor: String
)

data class MainInformation(
    val label: String,
    val information: String
)