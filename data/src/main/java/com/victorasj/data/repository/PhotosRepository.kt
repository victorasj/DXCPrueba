package com.victorasj.data.repository

import com.victorasj.data.source.RemoteDataSource
import com.victorasj.domain.Photo

class PhotosRepository(private val photosDataSource: RemoteDataSource) {

    suspend fun getPhotos(value: String) : List<Photo> {
        return photosDataSource.getPhotos(value)
    }

    suspend fun getPhoto(id: String) : Photo {
        return photosDataSource.getPhoto(id)
    }

}