package com.example.moviesreview.ui.elements.adapters

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesreview.R
import com.example.moviesreview.data.elements.ShortListData
import com.example.moviesreview.ui.activities.detail.DetailActivity

class FilmListAdapter(private var dataSet: List<ShortListData>, private val context: Context) :
    RecyclerView.Adapter<FilmListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val listDescription: TextView = view.findViewById(R.id.listDescription)
        val listDetailText: TextView = view.findViewById(R.id.listDetailText)
        val listTypeFilm: TextView = view.findViewById(R.id.listTypeFilm)
        val listImage: ImageView = view.findViewById(R.id.listImage)
        val listCardView: CardView = view.findViewById(R.id.listCardView)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.film_list_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        //set data
        viewHolder.listDescription.text = dataSet[position].name
        viewHolder.listDetailText.text = dataSet[position].details
        viewHolder.listTypeFilm.text = dataSet[position].type
        viewHolder.listImage.setImageBitmap(dataSet[position].image)

        //opening DetailActivity with animation and sending film id
        viewHolder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("id", dataSet[position].id)

            val options = ActivityOptions.makeSceneTransitionAnimation(
                context as Activity?, viewHolder.listCardView, "poster"
            )
            context.startActivity(intent, options.toBundle())
        }
    }
    override fun getItemCount() = dataSet.size

    fun updateData(newData: List<ShortListData>) {
        notifyItemRangeRemoved(0, itemCount)
        dataSet = newData
        notifyItemRangeInserted(0, itemCount)
    }
}