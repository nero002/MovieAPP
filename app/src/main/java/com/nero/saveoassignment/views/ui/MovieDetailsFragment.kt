package com.nero.saveoassignment.views.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.nero.saveoassignment.R
import com.nero.saveoassignment.databinding.FragmentHomeBinding
import com.nero.saveoassignment.databinding.FragmentMovieDetailsBinding
import com.nero.saveoassignment.viewmodel.MovieViewModel

class MovieDetailsFragment : Fragment() {

    private lateinit var navController: NavController
    private val viewModel: MovieViewModel by viewModels()
    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        val args by navArgs<MovieDetailsFragmentArgs>()
        val movieResponse = args.movieDetailsArgs

        binding.apply {
            tvMovieName.text = movieResponse.name
            tvTime.text = movieResponse.runtime.toString()
            tvSysnopsis.text = movieResponse.name
            tvSynopsisData.text = movieResponse.summary


            try {
                tvDrama.text = movieResponse.genres[0]
                tvCrime.text = movieResponse.genres[1].toString()
                tvMystry.text = movieResponse.genres[2]
            } catch (e: Exception) {

            }
            Glide.with(ivMovieThumbnail).load(movieResponse.image.original).into(ivMovieThumbnail)
        }

    }
}