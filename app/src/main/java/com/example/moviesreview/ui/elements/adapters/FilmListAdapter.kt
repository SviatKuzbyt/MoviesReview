package com.example.moviesreview.ui.elements.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesreview.R
import com.example.moviesreview.data.filmlist.ShortListItemData
import com.example.moviesreview.ui.detail.DetailActivity

class FilmListAdapter (private val dataSet: List<ShortListItemData>, private val context: Context) :
    RecyclerView.Adapter<FilmListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val listDescription: TextView
        val listDetailText: TextView
        val listTypeFilm: TextView
        val listImage: ImageView
        init {
            listDescription = view.findViewById(R.id.listDescription)
            listDetailText = view.findViewById(R.id.listDetailText)
            listTypeFilm = view.findViewById(R.id.listTypeFilm)
            listImage = view.findViewById(R.id.listImage)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.film_list_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.listDescription.text = dataSet[position].name
        viewHolder.listDetailText.text = dataSet[position].details
        viewHolder.listTypeFilm.text = dataSet[position].type

        viewHolder.listImage.setImageDrawable(dataSet[position].image)
        viewHolder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("id", dataSet[position].id)
            context.startActivity(intent)
        }
    }
    override fun getItemCount() = dataSet.size
}