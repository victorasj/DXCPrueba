package com.victorasj.interactor

import com.victorasj.data.repository.PhotosRepository
import com.victorasj.domain.Photo

class GetPhoto(private val photosRepository: PhotosRepository) {
    suspend fun invoke(id : String) : Photo = photosRepository.getPhoto(id)
}