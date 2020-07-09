package com.geektech.youtubeparcer.model

import com.google.gson.annotations.SerializedName

data class Json4Kotlin_Base (
	@SerializedName("kind") val kind : String,
	@SerializedName("etag") val etag : String,
	@SerializedName("nextPageToken") val nextPageToken : String,
	@SerializedName("pageInfo") val pageInfo : PageInfo,
	@SerializedName("items") val items : List<Item>
)