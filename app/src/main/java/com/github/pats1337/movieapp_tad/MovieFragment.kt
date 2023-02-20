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
        val movieRecycler = view.findViewById<RecyclerView>(R.id.movie_recycler)
        val adapter = MovieAdapter(listener, viewModel.movieList)
        movieRecycler.layoutManager = LinearLayoutManager(requireContext())
        movieRecycler.adapter = adapter
    }

    private val listener = MovieAdapter.OnClickListener { movie ->
        findNavController().navigate(MovieFragmentDirections.actionMovieFragmentToMovieDetailFragment(movie))
    }

}