package com.victorasj.dxcprueba.server

import com.google.gson.annotations.SerializedName

data class PhotosWrapper (
    @SerializedName("page")
    val page : Int,
    @SerializedName("pages")
    val pages : Int,
    @SerializedName("perpage")
    val perpage : Int,
    @SerializedName("total")
    val total : Int,
    @SerializedName("photo")
    val photos : ArrayList<PhotoList>
)