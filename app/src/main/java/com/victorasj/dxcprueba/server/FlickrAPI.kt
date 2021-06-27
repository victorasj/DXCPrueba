package com.victorasj.dxcprueba.server

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface FlickrAPI {

    @GET
    suspend fun getPhotos(@Url url : String, @Query("format") format : String = "json", @Query("nojsoncallback") callback : String = "1", @Query("api_key") api_key : String, @Query("tags") tag : String) : List<PhotoList>

    @GET
    suspend fun getPhoto(@Url url: String, @Query("format") format : String = "json", @Query("nojsoncallback") callback : String = "1", @Query("api_key") api_key : String, @Query("photo_id") id : String) : PhotoInfo
}