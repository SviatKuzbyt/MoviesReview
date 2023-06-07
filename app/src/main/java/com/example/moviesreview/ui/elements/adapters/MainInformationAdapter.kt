package com.example.moviesreview.ui.elements.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesreview.R
import com.example.moviesreview.data.repositories.MainInformation

class MainInformationAdapter(private val dataSet: List<MainInformation>) :
    RecyclerView.Adapter<MainInformationAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val informationLabelText: TextView = view.findViewById(R.id.informationLabelText)
        val informationContentText: TextView = view.findViewById(R.id.informationContentText)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.main_information_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.informationLabelText.text = dataSet[position].label
        viewHolder.informationContentText.text = dataSet[position].information
    }

    override fun getItemCount() = dataSet.size
}