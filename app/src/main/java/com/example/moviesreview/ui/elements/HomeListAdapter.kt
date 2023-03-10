package com.example.moviesreview.ui.elements

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesreview.R
import com.example.moviesreview.data.repositories.HomeListData

class HomeListAdapter(
    private val dataSet: List<HomeListData>,
    private val context: Context,
):
    RecyclerView.Adapter<HomeListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val description: TextView
        val recycle: RecyclerView
        val moreText: TextView
        init {
            description = view.findViewById(R.id.homeListDescription)
            recycle = view.findViewById(R.id.homeListRecycle)
            moreText = view.findViewById(R.id.homeListMore)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.home_list_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.description.text = dataSet[position].description

        viewHolder.recycle.layoutManager = LinearLayoutManager(context)
        viewHolder.recycle.adapter = FilmListAdapter(dataSet[position].list, context)
    }
    override fun getItemCount() = dataSet.size
}