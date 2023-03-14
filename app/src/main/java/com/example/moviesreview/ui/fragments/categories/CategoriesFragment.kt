package com.example.moviesreview.ui.fragments.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesreview.R
import com.example.moviesreview.data.elements.CategoryData
import com.example.moviesreview.ui.elements.adapters.CategoryAdapter

class CategoriesFragment : Fragment() {
    private val listCategory by lazy {listOf(
        CategoryData("Comedy", R.drawable.comedy_ic),
        CategoryData("Drama", R.drawable.drama_ic),
        CategoryData("Sci-fi", R.drawable.scifi_ic),
        CategoryData("Action", R.drawable.action_ic),
        CategoryData("Crime", R.drawable.crime_ic),
        CategoryData("Romance", R.drawable.romance_ic),
        CategoryData("Thriller", R.drawable.thriller_ic)
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
        val recycleFilmsCategory = view.findViewById<RecyclerView>(R.id.recycleCategories)
        recycleFilmsCategory.layoutManager = LinearLayoutManager(activity)
        recycleFilmsCategory.adapter = CategoryAdapter(listCategory, requireActivity())
    }
}