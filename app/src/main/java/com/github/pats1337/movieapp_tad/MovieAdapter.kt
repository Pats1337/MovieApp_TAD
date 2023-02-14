package com.github.pats1337.movieapp_tad

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(private val filmList: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id: TextView = itemView.findViewById(R.id.movie_id)
        val title: TextView = itemView.findViewById(R.id.movie_title)
        val cover: ImageView = itemView.findViewById(R.id.movie_cover)
        val release: TextView = itemView.findViewById(R.id.movie_releaseDate)
        val rating: TextView = itemView.findViewById(R.id.movie_rating)
        val description: TextView = itemView.findViewById(R.id.movie_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.recycler_item,
            parent,
            false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = filmList[position]
        holder.id.setText(item.id)
        holder.title.setText(item.title)
        holder.cover.setImageResource(item.cover)
        holder.release.setText(item.releaseDate)
        holder.rating.setText(item.rating)
        holder.description.setText(item.description)
    }

    override fun getItemCount(): Int {
        return filmList.size
    }

}