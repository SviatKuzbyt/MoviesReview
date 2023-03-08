package com.example.moviesreview.ui.categories.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesreview.R
import com.example.moviesreview.data.elements.CategoryData
import com.example.moviesreview.ui.elements.CategoryAdapter

class CategoriesFragment : Fragment() {
    private val listFilmCategory by lazy {listOf(
        CategoryData("Comedy", R.drawable.comedy_ic, "film"),
        CategoryData("Drama", R.drawable.drama_ic, "film"),
        CategoryData("Sci-fi", R.drawable.scifi_ic, "film"),
        CategoryData("Action", R.drawable.action_ic, "film"),
        CategoryData("Detective", R.drawable.detective_ic, "film"),
        CategoryData("Horror", R.drawable.horror_ic, "film")
    )}

    private val listSerialCategory by lazy {listOf(
        CategoryData("Comedy", R.drawable.comedy_ic, "serial"),
        CategoryData("Drama", R.drawable.drama_ic, "serial"),
        CategoryData("Sci-fi", R.drawable.scifi_ic, "serial"),
        CategoryData("Action", R.drawable.action_ic, "serial")
    )}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycleFilmsCategory = view.findViewById<RecyclerView>(R.id.recycleFilmsCategory)
        recycleFilmsCategory.layoutManager = LinearLayoutManager(activity)
        recycleFilmsCategory.adapter = CategoryAdapter(listFilmCategory, requireActivity())

        val recycleSerialsCategory = view.findViewById<RecyclerView>(R.id.recycleSerialsCategory)
        recycleSerialsCategory.layoutManager = LinearLayoutManager(activity)
        recycleSerialsCategory.adapter = CategoryAdapter(listSerialCategory, requireActivity())
    }
}