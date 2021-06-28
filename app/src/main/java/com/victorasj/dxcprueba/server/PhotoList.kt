package com.victorasj.dxcprueba.server

import com.google.gson.annotations.SerializedName

data class PhotoList (
    @SerializedName("id")
    val id : String,
    @SerializedName("server")
    val server : String,
    @SerializedName("farm")
    val farm : Int
)