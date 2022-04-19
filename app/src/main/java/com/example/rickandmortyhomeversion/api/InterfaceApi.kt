package com.example.rickandmortyhomeversion.api

import com.example.rickandmortyhomeversion.models.CharacterDataResponse
import retrofit2.Call
import retrofit2.http.GET

interface InterfaceApi {
    @GET("character")
    fun getAllCharacters(): Call<CharacterDataResponse>
}