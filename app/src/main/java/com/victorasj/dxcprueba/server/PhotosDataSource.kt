package com.victorasj.dxcprueba.server

import com.victorasj.data.source.RemoteDataSource
import com.victorasj.domain.Photo
import com.victorasj.dxcprueba.toPhoto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PhotosDataSource : RemoteDataSource {


    override suspend fun getPhotos(value: String): List<Photo> = withContext(Dispatchers.IO) {
        val  listPhotosList : List<PhotoList>  = RetrofitInstance.SERVICE.getPhotos("?method=flickr.photos.search", "3dbd3988a9b7e3e5234741f122a3633b", value).photos


        var listPhotos : MutableList<PhotoInfo> = mutableListOf()
        listPhotosList.forEach {
            listPhotos.add(RetrofitInstance.SERVICE.getPhoto("?method=flickr.photos.getInfo", "3dbd3988a9b7e3e5234741f122a3633b", it.id))
        }
        listPhotos.map { it.toPhoto() }
    }


    override suspend fun getPhoto(id: String): Photo = withContext(Dispatchers.IO) {
        TODO("Not yet implemented")
    }

}