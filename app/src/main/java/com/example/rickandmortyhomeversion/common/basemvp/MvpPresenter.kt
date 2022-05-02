package com.example.rickandmortyhomeversion.common.basemvp

interface MvpPresenter<V : MvpView> {
    fun attach(view: V)
    fun detach()
}