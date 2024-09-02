package com.example.yttest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PlaylistAdapter(private val playlists: List<PlaylistItem>) :
    RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.playlist_item, parent, false)
        return PlaylistViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        val playlist = playlists[position]
        holder.title.text = playlist.snippet.title
        Glide.with(holder.itemView.context).load(playlist.snippet.thumbnails.default.url).into(holder.thumbnail)
    }

    override fun getItemCount(): Int = playlists.size

    class PlaylistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val thumbnail: ImageView = itemView.findViewById(R.id.thumbnail)
    }
}
