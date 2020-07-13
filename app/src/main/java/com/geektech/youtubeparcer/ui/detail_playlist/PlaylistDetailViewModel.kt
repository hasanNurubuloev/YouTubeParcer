package com.geektech.youtubeparcer.ui.detail_playlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geektech.youtubeparcer.model.PlayList
import com.geektech.youtubeparcer.repository.PlaylistRepository

class PlaylistDetailViewModel : ViewModel() {
    fun fetchDetailPlaylist(id: String): MutableLiveData<PlayList> {
        return PlaylistRepository().fetchYoutubePlaylistById(id)
    }
}