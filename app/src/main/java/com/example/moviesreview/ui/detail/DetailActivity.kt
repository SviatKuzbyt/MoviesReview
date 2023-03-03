package com.example.moviesreview.ui.detail

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Fade
import android.view.View
import android.view.Window
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
import com.example.moviesreview.ui.elements.MainInformationAdapter
import jp.wasabeef.glide.*
import jp.wasabeef.glide.transformations.BlurTransformation

class DetailActivity : AppCompatActivity() {
    private lateinit var viewModel: DetailViewModel

    private val scrollView: ScrollView by lazy { findViewById(R.id.scrollview) }
    private val toolbarDetail: androidx.appcompat.widget.Toolbar by lazy { findViewById(R.id.toolbarDetail) }
    private val imagePoster: ImageView by lazy { findViewById(R.id.imagePoster) }
    private val imageBackground: ImageView by lazy { findViewById(R.id.imageBackground) }
    private val backButtonBackground: Button by lazy { findViewById(R.id.backButtonBackground) }
    private val textLabel: TextView by lazy { findViewById(R.id.textLabel) }
    private val buttonLink: Button by lazy { findViewById(R.id.buttonLink) }
    private val buttonTrailer: Button by lazy { findViewById(R.id.buttonTrailer) }
    private val buttonFollow: Button by lazy { findViewById(R.id.buttonFollow) }
    private val recyclerMainInformation: RecyclerView by lazy { findViewById(R.id.recyclerMainInformation) }
    private val textDescription: TextView by lazy { findViewById(R.id.textDescription) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupWindowAnimations()
        setContentView(R.layout.activity_detail)
        setupViewModel()
        setupViews()
    }

    private fun setupWindowAnimations() {
        with(window) {
            requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
            enterTransition = Fade().apply { duration = 300 }
            sharedElementEnterTransition = ChangeBounds().apply { duration = 500 }
        }
    }

    private fun setupViews() {
        setSupportActionBar(toolbarDetail)

        val rect = Rect()
        scrollView.setOnScrollChangeListener { _, _, _, _, _ ->
            if(backButtonBackground.getGlobalVisibleRect(rect)){
                if(toolbarDetail.isVisible)
                    toolbarDetail.visibility = View.GONE
            }
            else if(toolbarDetail.isGone)
                toolbarDetail.visibility = View.VISIBLE
        }

        recyclerMainInformation.layoutManager = LinearLayoutManager(this)

        toolbarDetail.setNavigationOnClickListener { finishAfterTransition() }
        backButtonBackground.setOnClickListener { finishAfterTransition() }

        setLinkButton(buttonLink, viewModel.link)
        setLinkButton(buttonTrailer, viewModel.trailerLink)
        buttonFollow.setOnClickListener { viewModel.updateFollowed() }

        viewModel.error.observe(this) { Toast.makeText(this, it, Toast.LENGTH_LONG).show() }
    }

    private fun setupViewModel() {
        viewModel =
            ViewModelProvider(this,
                DetailViewModelFactory(application, intent.getIntExtra("id", 1))
            )[DetailViewModel::class.java]

        viewModel.label.observe(this){
            textLabel.text = it
            toolbarDetail.title = it
        }

        viewModel.description.observe(this){
            textDescription.text = it
        }

        viewModel.mainInformation.observe(this) {
            recyclerMainInformation.adapter = MainInformationAdapter(it)
        }

        viewModel.isFollowed.observe(this) {
            buttonFollow.background = ContextCompat.getDrawable(this, if (it) R.drawable.follow_checked_ic else R.drawable.followed_ic)
        }

        viewModel.imagePoster.observe(this) {
            imagePoster.setImageDrawable(it)
            blurBackground(imageBackground, it)
        }
    }

    private fun blurBackground(imageView: ImageView, image: Drawable?){
        Glide.with(this).load(image)
            .apply(RequestOptions.bitmapTransform(BlurTransformation(12, 3)))
            .into(imageView)
    }

    private fun setLinkButton(button: Button, link: MutableLiveData<String>) {
        button.setOnClickListener {
            try {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(link.value)))
            } catch (e: Exception) {
                Toast.makeText(this, "App don't founded for this action", Toast.LENGTH_LONG).show()
            }
        }
    }
}