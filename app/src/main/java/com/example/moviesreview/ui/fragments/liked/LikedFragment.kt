package com.example.moviesreview.ui.fragments.liked

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesreview.R
import com.example.moviesreview.ui.activities.isChangeLikedFilmList
import com.example.moviesreview.ui.elements.adapters.FilmListAdapter
import com.example.moviesreview.ui.elements.makeToastError

class LikedFragment : Fragment() {

    private val viewModel by viewModels<LikedViewModel>()
    lateinit var filmListAdapter: FilmListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_liked, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerLiked = view.findViewById<RecyclerView>(R.id.recyclerLiked)
        recyclerLiked.layoutManager = LinearLayoutManager(activity)

        viewModel.list.observe(viewLifecycleOwner){
            if(::filmListAdapter.isInitialized)
                filmListAdapter.updateData(it)
            else{
                filmListAdapter = FilmListAdapter(it, requireContext())
                recyclerLiked.adapter = filmListAdapter
            }
        }

        viewModel.error.observe(viewLifecycleOwner){
            makeToastError(it, activity)
        }
    }

    override fun onResume() {
        super.onResume()
        if (isChangeLikedFilmList){
            viewModel.getList()
            isChangeLikedFilmList = false
        }
    }
}