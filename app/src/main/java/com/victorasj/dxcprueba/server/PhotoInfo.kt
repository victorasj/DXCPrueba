package com.victorasj.dxcprueba.server

import com.google.gson.annotations.SerializedName

class PhotoInfo (
    val id : String,
    val secret : String,
    val server : String,
    val farm : Int,
    @SerializedName("owner")
    val photoOwner : Owner,
    @SerializedName("title")
    val photoTitle: Title,
    @SerializedName("description")
    val photoDescription: Description
)