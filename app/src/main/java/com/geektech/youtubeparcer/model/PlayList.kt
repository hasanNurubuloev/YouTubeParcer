package com.geektech.youtubeparcer.model

import com.google.gson.annotations.SerializedName

data class PlayList(
    @SerializedName("kind")
    var kind: String? = null,
    @SerializedName("etag")
    var etag: String? = null,
    var nextPageToken: String? = null,
    var pageInfo: PageInfo? = null,
    var items: MutableList<Items>? = null

)