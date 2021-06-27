package com.victorasj.dxcprueba

import android.app.Application
import com.victorasj.data.repository.PhotosRepository
import com.victorasj.data.source.RemoteDataSource
import com.victorasj.dxcprueba.server.PhotosDataSource
import com.victorasj.dxcprueba.ui.main.MainFragment
import com.victorasj.dxcprueba.ui.main.MainViewModel
import com.victorasj.interactor.GetPhotos
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun Application.initServiceLocator(){
    startKoin {
        androidLogger()
        androidContext(this@initServiceLocator)
        modules(listOf(appModule, dataModule, scopesModule))
    }
}

private val appModule = module {
    factory<RemoteDataSource> { PhotosDataSource() }
}

private val dataModule = module {
    factory { PhotosRepository(get()) }
}

private val scopesModule = module {
    scope(named<MainFragment>()){
        viewModel { (id : String) -> MainViewModel(get(), id) }
        scoped { GetPhotos(get())  }
    }
}
