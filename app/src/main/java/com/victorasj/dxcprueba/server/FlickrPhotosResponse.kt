package com.victorasj.dxcprueba.server

import com.google.gson.annotations.SerializedName

data class FlickrPhotosResponse (
    @SerializedName("photos")
    val wrapper : PhotosWrapper,
)