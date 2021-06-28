package com.victorasj.dxcprueba.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.victorasj.domain.Photo
import com.victorasj.dxcprueba.Event
import com.victorasj.dxcprueba.common.ScopedViewModel
import com.victorasj.interactor.GetPhotos
import kotlinx.coroutines.launch

class MainViewModel(private val getPhotos : GetPhotos) : ScopedViewModel() {

    sealed class UiModel {
        class Content(val photos : List<Photo>) : UiModel()
    }

    private val _photos = MutableLiveData<UiModel>()
    val photos : LiveData<UiModel>
        get() {
            return _photos
        }


    private val _navigateToPhoto = MutableLiveData<Event<Photo>>()
    val navigateToPhoto: LiveData<Event<Photo>> get() = _navigateToPhoto


    private fun refresh(tag : String?) {
        launch {
            _photos.value = UiModel.Content(if(!tag.isNullOrEmpty()) getPhotos.invoke(tag) else listOf())
        }
    }

    fun search(tag : String?) {
        refresh(tag)
    }

    fun onPhotoClick(photo: Photo) {
        _navigateToPhoto.value = Event(photo)
    }

}