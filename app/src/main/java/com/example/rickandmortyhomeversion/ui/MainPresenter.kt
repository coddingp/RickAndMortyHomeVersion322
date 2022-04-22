package com.example.rickandmortyhomeversion.ui

import com.example.rickandmortyhomeversion.api.InterfaceApi
import com.example.rickandmortyhomeversion.models.CharacterDataResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(private val api: InterfaceApi) {
    private var mainContract: MainContract? = null

    fun attach(mainContract: MainContract) {
        this.mainContract = mainContract
    }

    fun detach() {
        mainContract = null
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
                        mainContract?.showCharacters(characters!!)
                    }
                }

                override fun onFailure(call: Call<CharacterDataResponse>, t: Throwable) {
                    mainContract?.dataFailure(t)
                }
            })
    }
}

