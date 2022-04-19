package com.example.rickandmortyhomeversion.api

import org.w3c.dom.CharacterData
import retrofit2.Call
import retrofit2.http.GET

interface InterfaceApi {
    @GET("character")
    fun getAllCharacters(): Call<CharacterData>
}