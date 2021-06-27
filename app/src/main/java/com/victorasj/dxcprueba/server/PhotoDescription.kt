package com.victorasj.dxcprueba.server

import com.google.gson.annotations.SerializedName

class PhotoDescription (
    @SerializedName("_content")
    val description : String
)