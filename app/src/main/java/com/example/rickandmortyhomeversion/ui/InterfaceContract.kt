package com.example.rickandmortyhomeversion.ui

import com.example.rickandmortyhomeversion.models.CharacterDataResponse


interface InterfaceContract{
    fun showCharacters(data: CharacterDataResponse)
    fun dataFailure(t: Throwable)
}