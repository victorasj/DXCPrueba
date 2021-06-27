package com.victorasj.dxcprueba.server

class PhotoInfo (
    val id : String,
    val secret : String,
    val server : String,
    val farm : Int,
    val photoOwner : Owner,
    val photoTitle: Title,
    val photoDescription: Description
)