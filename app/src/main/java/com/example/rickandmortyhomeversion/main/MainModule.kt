package com.example.rickandmortyhomeversion.main

import com.example.rickandmortyhomeversion.main.ui.MainContract
import com.example.rickandmortyhomeversion.main.ui.MainPresenter
import org.koin.dsl.bind
import org.koin.dsl.module

object MainModule {
    fun create() = module {
        single { MainPresenter(get()) } bind MainContract.Presenter::class
    }
}