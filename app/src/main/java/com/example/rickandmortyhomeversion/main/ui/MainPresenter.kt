package com.example.rickandmortyhomeversion.main.ui

import com.example.rickandmortyhomeversion.api.InterfaceApi
import com.example.rickandmortyhomeversion.common.basemvp.BasePresenter
import com.example.rickandmortyhomeversion.models.CharacterDataResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class MainPresenter
    (
    private val api: InterfaceApi
) : BasePresenter<MainContract.View>(),
    MainContract.Presenter {

    override fun getHeroList() {
        api.getAllCharacters()
            .enqueue(object : Callback<CharacterDataResponse> {
                override fun onResponse(
                    call: Call<CharacterDataResponse>,
                    response: Response<CharacterDataResponse>,
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        val characters = response.body()
                        Timber.i(characters.toString())
                        view?.showHeroList(characters!!)

                    }
                }

                override fun onFailure(call: Call<CharacterDataResponse>, t: Throwable) {
                    view?.failure(t)
                }
            })
    }
}