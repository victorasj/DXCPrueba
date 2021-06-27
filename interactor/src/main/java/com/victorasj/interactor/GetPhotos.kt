package com.victorasj.interactor

import com.victorasj.data.repository.PhotosRepository
import com.victorasj.domain.Photo


class GetPhotos(private val photosRepository: PhotosRepository) {
    suspend fun invoke(value : String) : List<Photo> = photosRepository.getPhotos(value)
}