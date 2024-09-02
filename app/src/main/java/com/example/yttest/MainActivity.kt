package com.example.yttest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val API_KEY = "AIzaSyAc11WCkQLBz-vmpn8hcg22uie9a4LMoug"  // Replace with your actual API key
    private val CHANNEL_ID = "UCGbshtvS9t-8CW11W7TooQg"  // Muse Asia channel ID

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/youtube/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(YouTubeApiService::class.java)
        val call = service.getPlaylists("snippet", CHANNEL_ID, API_KEY)

        call.enqueue(object : Callback<YouTubeResponse> {
            override fun onResponse(call: Call<YouTubeResponse>, response: Response<YouTubeResponse>) {
                if (response.isSuccessful) {
                    val playlists = response.body()?.items ?: emptyList()
                    recyclerView.adapter = PlaylistAdapter(playlists)
                }
            }

            override fun onFailure(call: Call<YouTubeResponse>, t: Throwable) {
                // Handle error
            }
        })
    }
}
