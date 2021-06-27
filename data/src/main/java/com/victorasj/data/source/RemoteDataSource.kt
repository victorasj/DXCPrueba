package com.victorasj.data.source

import com.victorasj.domain.Photo

interface RemoteDataSource {

    suspend fun getPhotos(value: String) : List<Photo>
    suspend fun getPhoto(id: String) : Photo

}