package com.victorasj.dxcprueba.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.victorasj.domain.Photo
import com.victorasj.dxcprueba.Event
import com.victorasj.dxcprueba.common.ScopedViewModel
import com.victorasj.interactor.GetPhotos
import kotlinx.coroutines.launch

class MainViewModel(private val getPhotos : GetPhotos, private val tag : String) : ScopedViewModel() {

    sealed class UiModel {
        object Loading : UiModel()
        class Content(val photos : List<Photo>) : UiModel()
    }

    private val _photos = MutableLiveData<UiModel>()
    val photos : LiveData<UiModel>
        get() {
            if(_photos.value == null) refresh(tag)
            return _photos
        }


    private val _navigateToPhoto = MutableLiveData<Event<Photo>>()
    val navigateToPhoto: LiveData<Event<Photo>> get() = _navigateToPhoto


    private fun refresh(tag : String) {
        launch {
            _photos.value = UiModel.Loading
            _photos.value = UiModel.Content(getPhotos.invoke(tag))
        }
    }


}