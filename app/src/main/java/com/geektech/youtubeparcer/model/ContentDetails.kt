package com.geektech.youtubeparcer.model

import com.google.gson.annotations.SerializedName

data class ContentDetails (
	@SerializedName("itemCount") val itemCount : Int
)