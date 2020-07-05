package com.geektech.youtubeparcer.ui.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geektech.youtubeparcer.model.PlayList
import com.geektech.youtubeparcer.network.RetrofitClient
import com.geektech.youtubeparcer.network.YouTubeApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaylistViewModel : ViewModel (){

    fun fetchPlaylist() : LiveData<PlayList>{
        return fetchYoutubePlaylist()
    }

    val channelId = "UC_IfiZu3VkesO3L58L9WPhA"
    val apiKey = "AIzaSyCKf-0P4bFVs2KW11i9HB7ubO13f8iizcE"
    val part = "snippet,contentDetails"
    val maxResult = "50"

    private  var  apiService: YouTubeApi? = null
     fun fetchYoutubePlaylist(): LiveData<PlayList> {
        apiService = RetrofitClient.create()

         val data = MutableLiveData<PlayList>()
         apiService?.fetchAllPlaylist(part, apiKey, channelId, maxResult)
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
}