package com.example.rickandmortyhomeversion.main.di

import com.example.rickandmortyhomeversion.main.interactor.MainInteractor
import com.example.rickandmortyhomeversion.main.repository.MainRemoteRepository
import com.example.rickandmortyhomeversion.main.ui.MainContract
import com.example.rickandmortyhomeversion.main.ui.MainPresenter
import org.koin.dsl.bind
import org.koin.dsl.module

object MainModule {
    fun create() = module {
        single { MainPresenter(get()) } bind MainContract.Presenter::class
        factory {
            val interactor = MainInteractor(get())
            interactor
        } bind MainInteractor::class
        single<MainRemoteRepository> { MainRemoteRepository(get()) }
    }
}