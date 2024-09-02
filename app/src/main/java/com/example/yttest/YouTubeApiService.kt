package com.example.yttest

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeApiService {
    @GET("playlists")
    fun getPlaylists(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("key") apiKey: String
    ): Call<YouTubeResponse>
}
