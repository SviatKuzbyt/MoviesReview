package com.example.moviesreview.ui.activities.search

import android.animation.ObjectAnimator
import android.content.Context
import android.os.Bundle
import android.transition.Fade
import android.view.View
import android.view.Window
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesreview.R
import com.example.moviesreview.ui.elements.SearchEditText
import com.example.moviesreview.ui.elements.FilmListAdapter
import com.example.moviesreview.ui.elements.makeToastError

class SearchActivity : AppCompatActivity() {

    private val viewModel by viewModels<SearchViewModel>()
    private val buttonCloseSearch: Button by lazy { findViewById(R.id.buttonCloseSearch) }
    private val clearSearchText: Button by lazy { findViewById(R.id.clearSearchText) }
    private val textSearch: SearchEditText by lazy { findViewById(R.id.textSearch) }
    private val recycleSearch: RecyclerView by lazy { findViewById(R.id.recycleSearch) }
    private lateinit var recycleAdapter: FilmListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setOpenAnimation()
        setContentView(R.layout.activity_search)
        setSearchEditText()
        setRecycleSearch()

        buttonCloseSearch.setOnClickListener {
            finishAfterTransition()
        }

        viewModel.error.observe(this){
            makeToastError(it, this)
        }
    }

    private fun setOpenAnimation(){
        with(window) {
            requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
            enterTransition = Fade().apply { duration = 200 }
        }
    }

    private fun setSearchEditText(){
        textSearch.requestFocus()

        textSearch.setOnEditorActionListener { _, _, _ ->
            viewModel.searchFilms(textSearch.text.toString())
            closeKeyboard()
            textSearch.clearFocus()
            true
        }

        textSearch.setOnFocusChangeListener { _, focus ->
            clearSearchText.visibility = when (focus) {
                true -> View.VISIBLE
                else -> View.INVISIBLE
            }
        }

        clearSearchText.setOnClickListener {
            textSearch.setText("")
        }
    }

    private fun closeKeyboard(){
        this.currentFocus?.let { view ->
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    private fun setRecycleSearch(){
        recycleSearch.layoutManager = LinearLayoutManager(this)

        viewModel.list.observe(this){
            if(::recycleAdapter.isInitialized){
                recycleAdapter.updateData(it)
            } else{
                firstLoadAnimation()
                recycleAdapter = FilmListAdapter(it, this)
                recycleSearch.adapter = recycleAdapter
            }
        }
    }

    private fun firstLoadAnimation(){
        ObjectAnimator.ofFloat(recycleSearch, View.ALPHA, 0f, 1f).apply {
            duration = 200
            start()
        }
    }
}