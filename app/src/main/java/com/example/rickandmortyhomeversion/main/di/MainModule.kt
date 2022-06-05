package com.example.rickandmortyhomeversion.main.di

import com.example.rickandmortyhomeversion.main.interactor.MainInteractor
import com.example.rickandmortyhomeversion.main.repository.MainRemoteRepository
import com.example.rickandmortyhomeversion.main.ui.HeroListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

object MainModule {
    fun create() = module {
        factory {
            val interactor = MainInteractor(get())
            interactor
        } bind MainInteractor::class
        single<MainRemoteRepository> { MainRemoteRepository(get()) }
        viewModelOf(::HeroListViewModel)
    }
}