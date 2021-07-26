package com.nero.saveoassignment.views.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.transition.ChangeBounds
import com.bumptech.glide.Glide
import com.nero.saveoassignment.R
import com.nero.saveoassignment.databinding.FragmentMovieDetailsBinding
import com.nero.saveoassignment.utils.formatHourMinutes
import org.jsoup.Jsoup


class MovieDetailsFragment : Fragment() {

    private lateinit var navController: NavController
    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding get() = _binding!!

    var menu: Menu? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false);

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        /*
        * setting up the data from response
        * */
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