package com.nero.saveoassignment.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navArgs
import com.bumptech.glide.Glide
import com.nero.saveoassignment.databinding.ActivityDetailsBinding
import com.nero.saveoassignment.databinding.ActivityMovieBinding
import com.nero.saveoassignment.databinding.FragmentMovieDetailsBinding
import com.nero.saveoassignment.utils.formatHourMinutes
import com.nero.saveoassignment.views.ui.MovieDetailsFragmentArgs
import org.jsoup.Jsoup

class DetailsActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val args by navArgs<MovieDetailsFragmentArgs>()
        val movieResponse = args.movieDetailsArgs
        val summary: String = Jsoup.parse(movieResponse.summary).text()

        binding.apply {
            tvMovieName.text = movieResponse.name
            tvTime.text =
                movieResponse.runtime.formatHourMinutes() + " | " + movieResponse.premiered
            tvSynopsisData.text = summary

            try {
                tvDrama.text = movieResponse.genres[0]
                tvCrime.text = movieResponse.genres[1]
                tvMystry.text = movieResponse.genres[2]
            } catch (e: Exception) {

            }
            Glide.with(ivMovieThumbnail).load(movieResponse.image.original).into(ivMovieThumbnail)

            tvReview10.text = "Reviews :" + movieResponse.rating.average.toString()
            tvRatings.rating = movieResponse.rating.average.toFloat().div(2) ?: 0.0f
            tvRatingNumber.text = movieResponse.rating.average.toString()

        }
    }
}