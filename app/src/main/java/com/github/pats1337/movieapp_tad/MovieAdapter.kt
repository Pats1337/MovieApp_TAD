package com.github.pats1337.movieapp_tad

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(
    val context: Context, val movieList: ArrayList<Movie>, val onClickListener: OnClickListener
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

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
            R.layout.recycler_item, parent, false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = movieList[position]
        holder.id.text = item.id.toString()
        holder.title.text = item.title
        // Временное решение для доступа к локальным картинкам по имени файла, что бы не сохранять resId, который может пересоздаться
        holder.cover.setImageURI(Uri.parse("android.resource://" + BuildConfig.APPLICATION_ID + "/drawable/${item.cover}"))
        holder.release.text = item.releaseDate.toString()
        holder.rating.text = item.rating
        holder.description.text = item.description
        holder.itemView.setOnClickListener {
            onClickListener.onClick(item.id)
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class OnClickListener(val clickListener: (currentId: Int) -> Unit) {
        fun onClick(currentId: Int) = clickListener(currentId)
    }

}