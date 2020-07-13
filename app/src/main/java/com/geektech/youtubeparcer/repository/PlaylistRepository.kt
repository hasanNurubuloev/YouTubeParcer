package com.geektech.youtubeparcer.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.geektech.youtubeparcer.model.PlayList
import com.geektech.youtubeparcer.network.RetrofitClient
import com.geektech.youtubeparcer.network.YouTubeApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaylistRepository {

    val channelId = "UCuVpbMt4yu4I9eAey3khnGg"
    val apiKey = "AIzaSyCKf-0P4bFVs2KW11i9HB7ubO13f8iizcE"
    val part = "snippet,contentDetails"
    val maxResult = "50"

    private var apiService: YouTubeApi? = null
    fun fetchYoutubePlaylist(): LiveData<PlayList> {
        apiService = RetrofitClient.create()

        val data = MutableLiveData<PlayList>()
        apiService?.fetchAllPlaylist(apiKey, part, channelId, maxResult)
            ?.enqueue(object : Callback<PlayList> {
                override fun onFailure(call: Call<PlayList>, t: Throwable) {
                    data.value = null
                }

                override fun onResponse(call: Call<PlayList>, response: Response<PlayList>) {
                    data.value = response.body()

                }
            })
        return data
    }

    fun fetchYoutubePlaylistById(id: String): MutableLiveData<PlayList> {
        apiService = RetrofitClient.create()
        val data = MutableLiveData<PlayList>()

        apiService?.getSelectedPlaylist(apiKey, part, id, maxResult)
            ?.enqueue(object : Callback<PlayList> {
                override fun onFailure(call: Call<PlayList>, t: Throwable) {
                    data.value = null
                }

                override fun onResponse(call: Call<PlayList>, response: Response<PlayList>) {
                    data.value = response.body()
                }
            })
        return data
    }

    fun fetchYoutubeSearchVideoId(videoId: String): MutableLiveData<PlayList> {
        apiService = RetrofitClient.create()
        val data = MutableLiveData<PlayList>()
        apiService?.searchVideo(apiKey, part, videoId)?.enqueue(object :
            Callback<PlayList> {
            override fun onFailure(call: Call<PlayList>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(call: Call<PlayList>, response: Response<PlayList>) {
                data.value = response.body()
            }
        })
        return data
    }
}