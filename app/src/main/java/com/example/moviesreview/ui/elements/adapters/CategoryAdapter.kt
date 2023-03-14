package com.example.moviesreview.ui.elements.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesreview.R
import com.example.moviesreview.data.elements.CategoryData
import com.example.moviesreview.data.repositories.OPEN_CATEGORITY
import com.example.moviesreview.ui.activities.category.MoreListActivity

class CategoryAdapter(
    private val dataSet: List<CategoryData>,
    private val context: Context,
):
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val categoryText: TextView
        val categoryIcon: View
        init {
            categoryText = view.findViewById(R.id.categoryText)
            categoryIcon = view.findViewById(R.id.categoryIcon)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.category_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.categoryText.text = dataSet[position].name
        viewHolder.categoryIcon.setBackgroundResource(dataSet[position].icon)

        viewHolder.itemView.setOnClickListener {
            val intent = Intent(context, MoreListActivity::class.java)
            intent.putExtra("mode", OPEN_CATEGORITY)
            intent.putExtra("kind", dataSet[position].name)
            context.startActivity(intent)
        }
    }
    override fun getItemCount() = dataSet.size
}