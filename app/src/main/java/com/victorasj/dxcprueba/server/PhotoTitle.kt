package com.victorasj.dxcprueba.server

import com.google.gson.annotations.SerializedName

data class PhotoTitle (
    @SerializedName("_content")
    val title : String
)