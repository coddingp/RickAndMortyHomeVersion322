package com.example.rickandmortyhomeversion.main.ui

import com.example.rickandmortyhomeversion.common.basemvp.BaseFragmentContract
import com.example.rickandmortyhomeversion.common.basemvp.MvpPresenter
import com.example.rickandmortyhomeversion.common.basemvp.MvpView
import com.example.rickandmortyhomeversion.main.models.Result


interface MainContract : BaseFragmentContract {

    interface View : MvpView {
        fun showHeroList(result: List<Result>)
        fun failure(t: Throwable)
    }

    interface Presenter : MvpPresenter<View> {
        fun getHeroList()
    }

}