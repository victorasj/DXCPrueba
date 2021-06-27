package com.victorasj.dxcprueba.server

import com.google.gson.annotations.SerializedName

data class PhotoInfo (
    val id : String,
    val secret : String,
    val server : String,
    val farm : Int,
    @SerializedName("owner")
    val photoOwner : Owner,
    @SerializedName("title")
    val photoTitle: PhotoTitle,
    @SerializedName("description")
    val photoDescription: Description,
    @SerializedName("dates")
    val photoDate: PhotoDate,

    )