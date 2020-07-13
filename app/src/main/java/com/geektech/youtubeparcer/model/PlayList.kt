package com.geektech.youtubeparcer.model

import com.google.gson.annotations.SerializedName

data class PlayList(
    @SerializedName("kind")
    var kind: String,
    @SerializedName("etag")
    var etag: String,
    var nextPageToken: String,
    var pageInfo: PageInfo,
    var items: MutableList<PlaylistItem>

)