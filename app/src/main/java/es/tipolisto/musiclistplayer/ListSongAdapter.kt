package es.tipolisto.musiclistplayer

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

//1. Creamos una clase dentro de otra (sin definir por el momento) que xtienda de ReciclerView.ViewHolder, fíjate en el rollo de los viewa
//2. Se crea una clase que se inicialize con una lista de onjetos de una clase y que herede de RecyclerView.Adapter, como

class ListSongAdapter(val listSong:List<Song>):RecyclerView.Adapter<ListSongAdapter.SongHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return SongHolder(layoutInflater.inflate(R.layout.item_recycler_view_main_activity, parent,false))
    }

    override fun getItemCount(): Int {
       return listSong.size
    }

    override fun onBindViewHolder(holder: SongHolder, position: Int) {
        holder.render(listSong[position])
    }
    class SongHolder(val view: View):RecyclerView.ViewHolder(view){
        fun render(song: Song){
            view.findViewById<TextView>(R.id.textVTileiewItemReciclerMain).text=song.songTile
            view.findViewById<TextView>(R.id.textArtistViewItemReciclerMain).text=song.songArtist
            view.findViewById<TextView>(R.id.textLocationViewItemReciclerMain).text=song.songlocation.toString()
            Picasso.get().load(song.image).into(view.findViewById<ImageView>(R.id.imageViewItemRecyclerViewMain))
        }
    }

}

