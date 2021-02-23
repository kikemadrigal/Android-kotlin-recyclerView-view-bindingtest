package es.tipolisto.musiclistplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import es.tipolisto.musiclistplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //Para el view binding:
    // 1.Si es mayor del API 23 ponemos en el app/gradle  buildFeatures{ viewBinding=true }
    // Si es mayor de 21 ponemos en app/gradle
    private lateinit var binding:ActivityMainBinding
    val listSongs= listOf<Song>(
        Song("titutlo1", "artista1", 500, "https://images.pexels.com/photos/1447092/pexels-photo-1447092.png?cs=srgb&dl=pexels-thanhhoa-tran-1447092.jpg&fm=jpg"),
        Song("titutlo2", "artista2", 500, "https://images.pexels.com/photos/414171/pexels-photo-414171.jpeg?cs=srgb&dl=pexels-pixabay-414171.jpg&fm=jpg"),
        Song("titutlo3", "artista3", 500, "https://images.pexels.com/photos/132037/pexels-photo-132037.jpeg?cs=srgb&dl=pexels-pok-rie-132037.jpg&fm=jpg"),
        Song("titutlo4", "artista4", 500, "https://images.unsplash.com/photo-1516825926085-d40d553ac06e?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val textviewTitle=findViewById<TextView>(R.id.textViewTitleMainActivity)

        textviewTitle.setText("MainActivity")

        initRecycler();
    }

    fun initRecycler() {
        val recyclerViewListSongs = findViewById<RecyclerView>(R.id.recyclerViewListSongs)
        recyclerViewListSongs.layoutManager=LinearLayoutManager(this)
        val adapter=ListSongAdapter(listSongs)
        recyclerViewListSongs.adapter=adapter
    }
}