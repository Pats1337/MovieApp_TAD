package com.github.pats1337.movieapp_tad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class MovieDetailFragment : Fragment() {

    private val movie: MovieDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movie_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieDetailsView: ConstraintLayout = view.findViewById(R.id.card_detail)
        val movie: Movie = movie.movieArg
        val id: TextView = movieDetailsView.findViewById(R.id.movie_id)
        val title: TextView = movieDetailsView.findViewById(R.id.movie_title)
        val cover: ImageView = movieDetailsView.findViewById(R.id.movie_cover)
        val release: TextView = movieDetailsView.findViewById(R.id.movie_releaseDate)
        val rating: TextView = movieDetailsView.findViewById(R.id.movie_rating)
        val description: TextView = movieDetailsView.findViewById(R.id.movie_description)
        id.setText(movie.id)
        title.setText(movie.title)
        cover.setImageResource(movie.cover)
        release.setText(movie.releaseDate)
        rating.setText(movie.rating)
        description.setText(movie.description)
    }

}