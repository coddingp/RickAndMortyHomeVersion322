package com.example.rickandmortyhomeversion.main.ui

import com.example.rickandmortyhomeversion.main.api.InterfaceApi
import com.example.rickandmortyhomeversion.common.basemvp.BasePresenter
import com.example.rickandmortyhomeversion.main.api.model.CharacterDataResponse
import com.example.rickandmortyhomeversion.main.interactor.MainInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class MainPresenter
    (
    private val interactor: MainInteractor
) : BasePresenter<MainContract.View>(),
    MainContract.Presenter {

    private val presenterScope = CoroutineScope(Dispatchers.Main.immediate)

    override fun getHeroList() {
        presenterScope.launch {
            try{
                val data = interactor.getResults()
                view?. = h
            }catch (t:Throwable){
                Timber.e(t.message)
            }
        }
    }
}