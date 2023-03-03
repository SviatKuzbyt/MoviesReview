package com.example.moviesreview.data.repositories

import android.content.Context
import android.graphics.drawable.Drawable
import com.example.moviesreview.R
import com.example.moviesreview.data.database.Movies
import com.example.moviesreview.data.database.MoviesDataBase
import com.example.moviesreview.data.elements.getPosterFromAssets

class DetailRepository(private val id: Int, private val context: Context) {
    private val dao = MoviesDataBase.getInstance(context).dao()

    fun getInformation(): DetailData{
        return convertToDetailData(dao.getInformation(id))
    }

    private fun convertToDetailData(movies: Movies) = DetailData(
            movies.name,
            getPosterFromAssets(movies.image, context),
            movies.link,
            movies.linkTrailer,
            movies.followed,
            makeListOfMainInformation(movies),
            movies.description
        )

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
    val image: Drawable?,
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