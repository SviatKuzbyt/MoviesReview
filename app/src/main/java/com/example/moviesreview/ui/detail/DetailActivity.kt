package com.example.moviesreview.ui.detail

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Rect
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moviesreview.R
import com.example.moviesreview.ui.elements.adapters.MainInformationAdapter
import jp.wasabeef.glide.*
import jp.wasabeef.glide.transformations.BlurTransformation

class DetailActivity : AppCompatActivity() {
    lateinit var scrollView: ScrollView
    lateinit var textLabel: TextView
    lateinit var backButtonBackground: Button
    lateinit var imageBackground: ImageView
    lateinit var imagePoster: ImageView
    lateinit var buttonTrailer: Button
    lateinit var buttonLink: Button
    lateinit var buttonFollow: Button
    lateinit var recyclerMainInformation: RecyclerView
    lateinit var textDescription: TextView
    lateinit var toolbarDetail: androidx.appcompat.widget.Toolbar
    lateinit var backButtonToolbar: Button
    lateinit var textToolbar: TextView

    lateinit var viewModel: DetailViewModel

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val id = intent.getIntExtra("id", 1)
        viewModel = ViewModelProvider(this, DetailViewModelFactory(application, id))[DetailViewModel::class.java]

        toolbarDetail = findViewById(R.id.toolbarDetail)
        setSupportActionBar(toolbarDetail)

        backButtonBackground = findViewById(R.id.backButtonBackground)
        setBackButton(backButtonBackground)

        backButtonToolbar = findViewById(R.id.backButtonToolbar)
        setBackButton(backButtonToolbar)

        scrollView = findViewById(R.id.scrollview)
        val rect = Rect()
        scrollView.setOnScrollChangeListener { _, _, _, _, _ ->
            if(backButtonBackground.getGlobalVisibleRect(rect)){
                if(toolbarDetail.isVisible)
                    toolbarDetail.visibility = View.GONE
            }
            else if(toolbarDetail.isGone)
                toolbarDetail.visibility = View.VISIBLE
        }

        imageBackground = findViewById(R.id.imageBackground)

        Glide.with(this).load(R.drawable.poster3)
            .apply(RequestOptions.bitmapTransform(BlurTransformation(12, 3)))
            .into(imageBackground)

        textLabel = findViewById(R.id.textLabel)
        textToolbar = findViewById(R.id.textToolbar)
        viewModel.label.observe(this){
            setText(textLabel, it)
            setText(textToolbar, it)
        }

        buttonLink = findViewById(R.id.buttonLink)
        setLinkButton(buttonLink, viewModel.link)

        buttonTrailer = findViewById(R.id.buttonTrailer)
        setLinkButton(buttonTrailer, viewModel.trailerLink)

        textDescription = findViewById(R.id.textDescription)
        viewModel.description.observe(this){
            setText(textDescription, it)
        }

        recyclerMainInformation = findViewById(R.id.recyclerMainInformation)
        recyclerMainInformation.layoutManager = LinearLayoutManager(this)
        viewModel.mainInformation.observe(this){
            val adapter = MainInformationAdapter(it)
            recyclerMainInformation.adapter = adapter
        }
    }

    private fun setBackButton(button: Button){
        button.setOnClickListener {
            finish()
        }
    }

    private fun setText(textView: TextView, text: String){
        textView.text = text
    }

    private fun setLinkButton(button: Button, link: MutableLiveData<String>){
        button.setOnClickListener {
            try {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(link.value)))
            } catch (e: Exception){
                Toast.makeText(this, "App don't founded for this action", Toast.LENGTH_LONG).show()
            }
        }
    }

}