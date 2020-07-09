package com.geektech.youtubeparcer.network

import com.geektech.youtubeparcer.model.PlayList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeApi {
    @GET("v3/playlists")
    fun fetchAllPlaylist(
        @Query("key") apiKey: String,
        @Query("part") part: String,
        @Query ("channelId") channelId: String,
        @Query ("maxResult") maxResult: String
    ): Call<PlayList>
}