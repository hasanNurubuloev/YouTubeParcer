package com.geektech.youtubeparcer.model

data class PlaylistItem(
    val snippet: Snippet? = null,
    val kind: String? = null,
    val etag: String? = null,
    val id: String? = null,
    val contentDetails: ContentDetails? = null
)