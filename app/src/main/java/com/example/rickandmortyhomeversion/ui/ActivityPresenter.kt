package com.example.rickandmortyhomeversion.ui

import com.example.rickandmortyhomeversion.api.InterfaceApi
import com.example.rickandmortyhomeversion.models.CharacterData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
            .enqueue(object : Callback<CharacterData> {
                override fun onResponse(
                    call: Call<CharacterData>,
                    response: Response<CharacterData>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        val characters = response.body()
                        interfaceContract?.showCharacters(characters!!)
                    }
                }

                override fun onFailure(call: Call<CharacterData>, t: Throwable) {
                    interfaceContract?.dataFailure(t)
                }
            })
    }
}

private fun <T> Call<T>.enqueue(callback: Callback<CharacterData>) {

}