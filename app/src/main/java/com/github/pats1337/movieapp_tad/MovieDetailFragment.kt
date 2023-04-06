package com.github.pats1337.movieapp_tad

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.pats1337.movieapp_tad.databinding.MovieDetailsBinding
import com.google.gson.Gson
import org.json.JSONException

class MovieDetailFragment : Fragment() {

    private val currentMovieId: MovieDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movie_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Film", "${currentMovieId.movieId}")
        val jsonString = Util.getJSONFromAssets(requireContext(), "movies.json")
        Log.d("FilmFragment", "$jsonString")
        val movie = Gson().fromJson(jsonString, Movies::class.java)
        val currentMovie = movie.movies.find { it.id == currentMovieId.movieId }!!
        val movieDetailsView: ConstraintLayout = view.findViewById(R.id.card_detail)
        val id: TextView = movieDetailsView.findViewById(R.id.movie_id)
        val title: TextView = movieDetailsView.findViewById(R.id.movie_title)
        val cover: ImageView = movieDetailsView.findViewById(R.id.movie_cover)
        val release: TextView = movieDetailsView.findViewById(R.id.movie_releaseDate)
        val rating: TextView = movieDetailsView.findViewById(R.id.movie_rating)
        val description: TextView = movieDetailsView.findViewById(R.id.movie_description)
        id.text = currentMovie.id.toString()
        title.text = currentMovie.title
        // Временное решение для доступа к локальным картинкам по имени файла, что бы не сохранять resId, который может пересоздаться
        cover.setImageURI(Uri.parse("android.resource://" + BuildConfig.APPLICATION_ID + "/drawable/${currentMovie.cover}"))
        release.text = currentMovie.releaseDate.toString()
        rating.text = currentMovie.rating
        description.text = currentMovie.description
    }

}