package com.example.moviesreview.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesreview.R
import com.example.moviesreview.data.filmlist.ShortListItemData
import com.example.moviesreview.ui.elements.adapters.FilmListAdapter

class HomeFragment : Fragment() {

    private val viewModel by viewModels<HomeViewModel>()
    lateinit var searchEditText: EditText
    lateinit var topFilmsRecycle: RecyclerView
    lateinit var otherFilmsRecycle: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        topFilmsRecycle = view.findViewById(R.id.topFilmsRecycle)
        setUpRecyclerView(topFilmsRecycle, viewModel.topFilmList)

        otherFilmsRecycle = view.findViewById(R.id.otherFilmsRecycle)
        setUpRecyclerView(otherFilmsRecycle, viewModel.otherFilmList)

        viewModel.error.observe(viewLifecycleOwner){
            Toast.makeText(activity, it, Toast.LENGTH_LONG).show()
        }
    }

    private fun setUpRecyclerView(recyclerView: RecyclerView, list: LiveData<List<ShortListItemData>>) {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        list.observe(viewLifecycleOwner) {
            val adapter = FilmListAdapter(it, requireActivity())
            recyclerView.adapter = adapter
        }
    }
}