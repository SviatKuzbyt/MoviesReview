package com.example.moviesreview.ui.fragments.liked

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesreview.R
import com.example.moviesreview.ui.activities.isChangeLikedFilmList
import com.example.moviesreview.ui.elements.FilmListAdapter
import com.example.moviesreview.ui.elements.makeToastError


class LikedFragment : Fragment() {

    private val viewModel by viewModels<LikedViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_liked, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (isChangeLikedFilmList){
            viewModel.getList()
            isChangeLikedFilmList = false
        }

        val recyclerLiked = view.findViewById<RecyclerView>(R.id.recyclerLiked)
        recyclerLiked.layoutManager = LinearLayoutManager(activity)

        viewModel.list.observe(viewLifecycleOwner){
            recyclerLiked.adapter = FilmListAdapter(it, requireContext())
        }

        viewModel.error.observe(viewLifecycleOwner){
            makeToastError(it, activity)
        }
    }
}