package com.example.rickandmortyhomeversion.main.ui

import com.example.rickandmortyhomeversion.common.basemvp.BaseFragmentContract
import com.example.rickandmortyhomeversion.common.basemvp.MvpPresenter
import com.example.rickandmortyhomeversion.common.basemvp.MvpView
import com.example.rickandmortyhomeversion.models.CharacterDataResponse
import org.w3c.dom.CharacterData


interface MainContract : BaseFragmentContract {

    interface View : MvpView {
        fun showHeroList(data: CharacterDataResponse)
        fun failure(t: Throwable)
    }

    interface Presenter : MvpPresenter<View> {
        fun getHeroList()
    }

}