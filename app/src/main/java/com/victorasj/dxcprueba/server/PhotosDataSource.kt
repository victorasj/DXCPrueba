package com.victorasj.dxcprueba.server

import com.victorasj.data.source.RemoteDataSource
import com.victorasj.domain.Photo

class PhotosDataSource : RemoteDataSource {
    override suspend fun getPhotos(value: String): List<Photo> {
        return RetrofitInstance.SERVICE.getPhotos("", "", "")
    }

    override suspend fun getPhoto(id: String): Photo {
        return RetrofitInstance.SERVICE.getPhoto("", "", "")
    }
}