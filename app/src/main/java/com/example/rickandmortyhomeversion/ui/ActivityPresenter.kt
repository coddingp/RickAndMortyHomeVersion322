package com.example.rickandmortyhomeversion.ui

import com.example.rickandmortyhomeversion.api.InterfaceApi
import com.example.rickandmortyhomeversion.models.CharacterDataResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class ActivityPresenter(private val api: InterfaceApi) {
    private var interfaceContract: InterfaceContract? = null

    fun attach(interfaceContract: InterfaceContract) {
        this.interfaceContract = interfaceContract
    }

    fun detach() {
        interfaceContract = null
    }

    fun getCharacterDataFromApi() {
        api.getAllCharacters()
            .enqueue(object : Callback<CharacterDataResponse> {
                override fun onResponse(
                    call: Call<CharacterDataResponse>,
                    response: Response<CharacterDataResponse>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        val characters = response.body()
                        Timber.tag("%%%").i(characters.toString())
                        interfaceContract?.showCharacters(characters!!)
                    }
                }

                override fun onFailure(call: Call<CharacterDataResponse>, t: Throwable) {
                    interfaceContract?.dataFailure(t)
                }
            })
    }
}

