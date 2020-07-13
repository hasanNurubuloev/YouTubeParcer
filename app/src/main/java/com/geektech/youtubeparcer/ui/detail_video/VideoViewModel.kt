package com.geektech.youtubeparcer.ui.detail_video

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.geektech.youtubeparcer.model.PlayList
import com.geektech.youtubeparcer.repository.PlaylistRepository

class VideoViewModel : ViewModel() {

    fun fetchSearchVideo(relatedToVideoId: String): LiveData<PlayList?> {
        return PlaylistRepository().fetchYoutubeSearchVideoId(relatedToVideoId)
    }
}