package com.example.moviesreview.ui.activities.category

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesreview.R
import com.example.moviesreview.ui.elements.FilmListAdapter
import com.example.moviesreview.ui.elements.makeToastError

class CategoryActivity : AppCompatActivity() {

    private val categoryToolbar: androidx.appcompat.widget.Toolbar by lazy { findViewById(R.id.categoryToolbar) }
    private val categoryRecycler: RecyclerView by lazy { findViewById(R.id.categoryRecycler) }
    private val kind by lazy { intent.getStringExtra("kind") ?: "" }
    private val viewModel by viewModels<CategoryViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        setRecycleView()
        setToolBar()
        setErrorToast()
    }

    private fun setRecycleView(){
        viewModel.loadData(kind)
        viewModel.list.observe(this){
            categoryRecycler.layoutManager = LinearLayoutManager(this)
            categoryRecycler.adapter = FilmListAdapter(it, this)
        }
    }

    private fun setToolBar(){
        categoryToolbar.title = kind
        setSupportActionBar(categoryToolbar)
        categoryToolbar.setNavigationOnClickListener { finish() }
    }

    private fun setErrorToast(){
        viewModel.error.observe(this){
            makeToastError(it, this)
        }
    }
}