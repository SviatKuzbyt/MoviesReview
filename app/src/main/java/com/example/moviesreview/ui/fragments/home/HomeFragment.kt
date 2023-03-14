package com.example.moviesreview.ui.fragments.home

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesreview.R
import com.example.moviesreview.ui.activities.search.SearchActivity
import com.example.moviesreview.ui.elements.adapters.HomeListAdapter
import com.example.moviesreview.ui.elements.makeToastError

class HomeFragment : Fragment() {
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeRecycle = view.findViewById<RecyclerView>(R.id.homeRecycle)
        homeRecycle.layoutManager = LinearLayoutManager(activity)

        viewModel.homeList.observe(viewLifecycleOwner){
            homeRecycle.adapter = HomeListAdapter(it, requireActivity())
        }

        viewModel.error.observe(viewLifecycleOwner){
            makeToastError(it, activity)
        }

        val searchTextClick = view.findViewById<TextView>(R.id.searchTextClick)
        searchTextClick.setOnClickListener{
            startActivity(
                Intent(activity, SearchActivity::class.java),
                ActivityOptions.makeSceneTransitionAnimation(activity).toBundle()
            )
        }
    }
}