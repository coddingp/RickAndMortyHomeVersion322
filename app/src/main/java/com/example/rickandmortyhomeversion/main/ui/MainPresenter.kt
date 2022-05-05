package com.example.rickandmortyhomeversion.main.ui

import com.example.rickandmortyhomeversion.common.basemvp.BasePresenter
import com.example.rickandmortyhomeversion.main.interactor.MainInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class MainPresenter
    (
    private val interacter: MainInteractor
) : BasePresenter<MainContract.View>(),
    MainContract.Presenter {

    private val presenterScope = CoroutineScope(Dispatchers.Main.immediate)

    override fun getHeroList() {
        presenterScope.launch {
            try{
                val data = interacter.getResults()
                view?.showHeroList(data)
            }catch (t:Throwable){
                Timber.e(t.message)
            }
        }
    }
}