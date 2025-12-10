package com.example.lab_week_13

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.lab_week_13.R

class DetailsActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_RELEASE = "extra_release"
        const val EXTRA_OVERVIEW = "extra_overview"
        const val EXTRA_POSTER = "extra_poster"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val title = intent.getStringExtra(EXTRA_TITLE)
        val releaseDate = intent.getStringExtra(EXTRA_RELEASE)
        val overview = intent.getStringExtra(EXTRA_OVERVIEW)
        val posterPath = intent.getStringExtra(EXTRA_POSTER)

        val titleText: TextView = findViewById(R.id.title_text)
        val releaseText: TextView = findViewById(R.id.release_text)
        val overviewText: TextView = findViewById(R.id.overview_text)
        val poster: ImageView = findViewById(R.id.movie_poster)

        titleText.text = title
        releaseText.text = releaseDate
        overviewText.text = overview

        if (posterPath != null) {
            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w185/$posterPath")
                .placeholder(R.mipmap.ic_launcher)
                .fitCenter()
                .into(poster)
        }
    }
}