package com.victorasj.dxcprueba.server

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface FlickrAPI {

    @GET
    suspend fun getPhotos(@Url url : String, @Query("tags") tag : String);

    suspend fun getPhoto(@Url url: String)
}