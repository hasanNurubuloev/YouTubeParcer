package com.geektech.youtubeparcer.ui.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.geektech.youtubeparcer.model.PlayList
import com.geektech.youtubeparcer.repository.PlaylistRepository

class PlaylistViewModel : ViewModel() {

    fun fetchPlaylist(): LiveData<PlayList> {
        return PlaylistRepository().fetchYoutubePlaylist()
    }
}