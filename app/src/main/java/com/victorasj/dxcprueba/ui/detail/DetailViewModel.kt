package com.victorasj.dxcprueba.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.victorasj.domain.Photo
import com.victorasj.dxcprueba.common.ScopedViewModel
import com.victorasj.interactor.GetPhoto
import kotlinx.coroutines.launch

class DetailViewModel(private val getPhoto : GetPhoto, private val id : String) : ScopedViewModel() {

    sealed class UiModel {
        class ContentPhoto(val photo : Photo) : UiModel()
    }

    private val _photo = MutableLiveData<UiModel>()
    val photo : LiveData<UiModel>
        get() {
            if(_photo.value == null) loadPhoto(id)
            return _photo
        }

    private fun loadPhoto(id : String){
        launch {
            _photo.value = UiModel.ContentPhoto(getPhoto.invoke(id))
        }
    }
}