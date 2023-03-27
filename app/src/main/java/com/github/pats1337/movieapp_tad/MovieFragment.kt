package com.github.pats1337.movieapp_tad


import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.pats1337.movieapp_tad.Util.getJSONFromAssets
import com.google.gson.Gson
import org.json.JSONException


class MovieFragment : Fragment() {
    private val viewModel: MovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.movie_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            val jsonString = getJSONFromAssets(requireContext(), "movies.json")
            val movie = Gson().fromJson(jsonString, Movies::class.java)
            val movieRecycler = view.findViewById<RecyclerView>(R.id.movie_recycler)
            movieRecycler.layoutManager = LinearLayoutManager(requireContext())

            val adapter = MovieAdapter(requireContext(), movie.movies, listener)
            movieRecycler.adapter = adapter

        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    private val listener = MovieAdapter.OnClickListener { currentId ->
        findNavController().navigate(
            MovieFragmentDirections.actionMovieFragmentToMovieDetailFragment(
                currentId
            )
        )
    }

}