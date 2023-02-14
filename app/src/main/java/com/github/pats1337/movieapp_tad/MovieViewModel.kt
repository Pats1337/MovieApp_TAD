package com.github.pats1337.movieapp_tad

import androidx.lifecycle.ViewModel

class MovieViewModel : ViewModel() {
    val movieList = listOf(
        Movie(
            R.string.id1,
            R.string.title1,
            R.drawable.cover1,
            R.string.releaseDate1,
            R.string.rating1,
            R.string.description1
        ),
        Movie(
            R.string.id2,
            R.string.title2,
            R.drawable.cover2,
            R.string.releaseDate2,
            R.string.rating2,
            R.string.description2
        ),
        Movie(
            R.string.id3,
            R.string.title3,
            R.drawable.cover3,
            R.string.releaseDate3,
            R.string.rating3,
            R.string.description3
        )
    )
}