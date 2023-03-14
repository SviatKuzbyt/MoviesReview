package com.example.moviesreview.ui.activities.category

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesreview.R
import com.example.moviesreview.data.repositories.OPEN_FILMS
import com.example.moviesreview.data.repositories.OPEN_SERIALS
import com.example.moviesreview.data.repositories.OPEN_TOP
import com.example.moviesreview.ui.elements.adapters.FilmListAdapter
import com.example.moviesreview.ui.elements.makeToastError

class MoreListActivity : AppCompatActivity() {

    private val categoryToolbar: androidx.appcompat.widget.Toolbar by lazy { findViewById(R.id.categoryToolbar) }
    private val categoryRecycler: RecyclerView by lazy { findViewById(R.id.categoryRecycler) }
    private val mode by lazy {intent.getIntExtra("mode", 1)}
    private val kind by lazy { intent.getStringExtra("kind")}
    private val viewModel by viewModels<MoreListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_list)
        setRecycleView()
        setToolBar()
        setErrorToast()
    }

    private fun setRecycleView(){
        viewModel.loadData(mode, kind)
        viewModel.list.observe(this){
            categoryRecycler.layoutManager = LinearLayoutManager(this)
            categoryRecycler.adapter = FilmListAdapter(it, this)
        }
    }

    private fun setToolBar(){
        categoryToolbar.title = getToolBarTitle()
        setSupportActionBar(categoryToolbar)
        categoryToolbar.setNavigationOnClickListener { finish() }
    }

    private fun setErrorToast(){
        viewModel.error.observe(this){
            makeToastError(it, this)
        }
    }

    private fun getToolBarTitle(): String{
        return when(mode){
            OPEN_TOP -> getString(R.string.top)
            OPEN_FILMS -> getString(R.string.films)
            OPEN_SERIALS -> getString(R.string.serials)
            else -> kind ?: ""
        }
    }
}