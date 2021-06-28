package com.victorasj.dxcprueba.server

import com.google.gson.annotations.SerializedName

data class PhotoInfo (
    @SerializedName("id")
    val id : String,
    @SerializedName("secret")
    val secret : String,
    @SerializedName("server")
    val server : String,
    @SerializedName("farm")
    val farm : Int,
    @SerializedName("owner")
    val photoOwner : PhotoOwner,
    @SerializedName("title")
    val photoTitle: PhotoTitle,
    @SerializedName("description")
    val photoDescription: Description,
    @SerializedName("dates")
    val photoDate: PhotoDate
    )