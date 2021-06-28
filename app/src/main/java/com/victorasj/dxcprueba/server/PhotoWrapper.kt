package com.victorasj.dxcprueba.server

import com.google.gson.annotations.SerializedName

data class PhotoWrapper (
    val page : Int,
    val pages : Int,
    val perpage : Int,
    val total : Int,
    @SerializedName("photo")
    val photos : List<PhotoList>
)