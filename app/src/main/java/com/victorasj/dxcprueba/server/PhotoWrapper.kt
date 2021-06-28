package com.victorasj.dxcprueba.server

import com.google.gson.annotations.SerializedName

data class PhotoWrapper (
    @SerializedName("photo")
    val photo : PhotoInfo,
)