package com.github.pats1337.movieapp_tad

data class Movies(
    val movies: ArrayList<Movie>
)

data class Movie(
    val id: Int,
    val title: String,
    val cover: String,
    val releaseDate: Int,
    val rating: String,
    val description: String
) {

}
